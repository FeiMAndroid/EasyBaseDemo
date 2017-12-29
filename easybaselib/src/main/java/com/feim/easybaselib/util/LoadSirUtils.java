package com.feim.easybaselib.util;


import com.feim.easybaselib.callback.CustomCallback;
import com.feim.easybaselib.callback.EmptyCallback;
import com.feim.easybaselib.callback.ErrorCallback;
import com.feim.easybaselib.callback.LoadingCallback;
import com.feim.easybaselib.callback.PlaceholderCallback;
import com.feim.easybaselib.callback.TimeoutCallback;
import com.kingja.loadsir.core.LoadSir;

/**
 * Created by feim on 2017/12/14.
 */

public class LoadSirUtils {

    public static void init() {
        LoadSir.beginBuilder()
                .addCallback(new ErrorCallback())
                .addCallback(new EmptyCallback())
                .addCallback(new LoadingCallback())
                .addCallback(new TimeoutCallback())
                .addCallback(new CustomCallback())
                .addCallback(new PlaceholderCallback())
                .commit();
    }
}
