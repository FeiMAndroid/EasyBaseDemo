package com.feim.easybaselib.util;

import android.util.Log;

import com.feim.easybaselib.dialog.ProgressDialog;


/**
 * author 姚智胜
 * version V1.0
 * Description: 加载数据时显示的对话框
 * date 2016/11/17 21:33
 */
public class LoadingDialogUtils {
    private static final String TAG = "LoadingDialogUtils";

    private static ProgressDialog progressDialog;

    /**
     * 默认载入loading
     */
    public static void showLoadingDialog() {
        try {
            if (progressDialog == null) {
                progressDialog = new ProgressDialog(ActivityStackManager.getInstance().getTopActivity(), "请稍候");
            }
            progressDialog.setCancelable(false);

            progressDialog.show();
        } catch (Exception e) {
            Log.e(TAG, "progressDialog启动失败");
        }
    }

    /**
     * 载入默认loading 自定义message
     *
     * @param message
     */
    public static void showLoadingDialog(String message) {
        try {
            if (progressDialog == null) {
                progressDialog = new ProgressDialog(ActivityStackManager.getInstance().getTopActivity(), null == message ? "请稍候" : message);
            }
            progressDialog.setCancelable(false);

            progressDialog.show();
        } catch (Exception e) {
            Log.e(TAG, "progressDialog启动失败");
        }
    }

    /**
     * 取消loading
     */
    public static void cancelLoadingDialog() {

        if (progressDialog != null && progressDialog.isShowing()) {
            try {
                progressDialog.dismiss();
            } catch (Exception e) {
                Log.e(TAG, "progressDialog销毁失败");
            }
        }
        progressDialog = null;
    }
}
