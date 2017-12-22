package com.feim.easybaselib.widget;

/**
 * Created by SLF-001 on 2017/9/29.
 */

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.feim.easybaselib.R;

/**
 * 宽高比 ImageView
 * Created by bakumon on 17-7-27.
 * 确定宽高比的基准，控件的宽高必须有一个为 0dp，另一个即为基准。
 * xml： app:dimensionRatio="3:1"
 * java： ratioImageView.setDimensionRatio(3, 1);
 */

public class RatioImageView extends ImageView {

    private int ratioWidth;
    private int ratioHeight;

    public RatioImageView(Context context) {
        this(context, null);
    }

    public RatioImageView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RatioImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.RatioImageView);
        String ratioAttr = a.getString(R.styleable.RatioImageView_dimensionRatio);
        if (!TextUtils.isEmpty(ratioAttr)) {
            try {
                String[] ratio = ratioAttr.split(":");
                if (ratio.length > 1) {
                    ratioWidth = Integer.parseInt(ratio[0]);
                    ratioHeight = Integer.parseInt(ratio[1]);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        a.recycle();

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        if (ratioWidth == 0 || ratioHeight == 0) {
            return;
        }

        int measuredHeight = getMeasuredHeight();
        int measuredWidth = getMeasuredWidth();

        if ((measuredHeight == 0 && measuredWidth != 0)) {
            setMeasuredDimension(measuredWidth, measuredWidth * ratioHeight / ratioWidth);
        }

        if ((measuredWidth == 0 && measuredHeight != 0)) {
            setMeasuredDimension(measuredHeight * ratioWidth / ratioHeight, measuredHeight);
        }
    }

    public void setDimensionRatio(int ratioWidth, int ratioHeight) {
        this.ratioWidth = ratioWidth;
        this.ratioHeight = ratioHeight;
        requestLayout();
    }
}