package com.feim.easybasedemo;

import android.app.Application;

import com.feim.easybaselib.util.LoadSirUtils;

import butterknife.ButterKnife;

/**
 * Created by feim on 2017/12/25.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ButterKnife.setDebug(BuildConfig.DEBUG);
        LoadSirUtils.init();
    }
}
