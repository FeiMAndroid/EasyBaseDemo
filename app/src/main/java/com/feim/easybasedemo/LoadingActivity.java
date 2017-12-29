package com.feim.easybasedemo;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.Nullable;

import com.feim.easybaselib.activity.EasyBaseActivity;
import com.feim.easybaselib.entity.EventCenter;
import com.feim.easybaselib.util.LoadingDialogUtils;

/**
 * Created by feim on 2017/12/25.
 */

public class LoadingActivity extends EasyBaseActivity {

    private int i = 0;

    @Override
    protected int initContentView(Bundle savedInstanceState, Bundle extras) {
        return R.layout.activity_loading;
    }

    @Nullable
    @Override
    protected String initTitle() {
        return "Loading";
    }

    @Override
    protected void initView() {
    }

    @Override
    protected void initLogic() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                showLoading();
                //do retry logic...
                SystemClock.sleep(1000);
                //callback
                switch (i){
                    case 0:
                        showEmpty();
                        break;
                    case 1:
                        showError();
                        break;
                    case 2:
                        showTimeout();
                        break;
                    default:
                        showSuccess();
                        break;
                }
                i++;
            }
        }).start();
    }

    @Override
    protected void onEventComing(EventCenter center) {

    }

    @Override
    protected int initMenuRes() {
        return 0;
    }
}
