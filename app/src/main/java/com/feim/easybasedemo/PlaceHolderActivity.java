package com.feim.easybasedemo;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.feim.easybaselib.activity.EasyBaseActivity;
import com.feim.easybaselib.entity.EventCenter;

/**
 * Created by feim on 2017/12/25.
 */

public class PlaceHolderActivity extends EasyBaseActivity {
    @Override
    protected int initContentView(Bundle savedInstanceState, Bundle extras) {
        return R.layout.activity_placeholder;
    }

    @Nullable
    @Override
    protected String initTitle() {
        return "Placeholder";
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initLogic() {

    }

    @Override
    protected void onEventComing(EventCenter center) {

    }

    @Override
    protected int initMenuRes() {
        return 0;
    }
}
