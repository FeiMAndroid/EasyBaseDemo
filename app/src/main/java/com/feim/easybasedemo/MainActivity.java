package com.feim.easybasedemo;

import android.os.Bundle;

import com.feim.easybaselib.EasyBaseActivity;
import com.feim.easybaselib.entity.EventCenter;
import com.feim.feimbasedemo.R;

public class MainActivity extends EasyBaseActivity {

    @Override
    protected void initContentView(Bundle savedInstanceState, Bundle extras) {
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void initTitle() {
        setTitle("首页");
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

}
