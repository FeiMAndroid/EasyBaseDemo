package com.feim.easybaselib.util;

import android.hardware.Camera;

import com.feim.easybaselib.callback.CustomCallback;
import com.feim.easybaselib.callback.EmptyCallback;
import com.feim.easybaselib.callback.ErrorCallback;
import com.feim.easybaselib.callback.LoadingCallback;
import com.feim.easybaselib.callback.TimeoutCallback;
import com.kingja.loadsir.core.LoadSir;

/**
 * Created by feim on 2017/12/14.
 */

public  class LoadSirUtil {
    public static void init(){
        LoadSir.beginBuilder()
                .addCallback(new ErrorCallback())
                .addCallback(new EmptyCallback())
                .addCallback(new LoadingCallback())
                .addCallback(new TimeoutCallback())
                .addCallback(new CustomCallback())
                .setDefaultCallback(LoadingCallback.class)
                .commit();
    }
}
