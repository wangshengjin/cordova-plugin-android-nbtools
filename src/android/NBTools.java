package com.nbtools;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;

import android.content.Context;
import android.content.res.Configuration;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;

public class NBTools extends CordovaPlugin {
    @Override
    protected void pluginInitialize() {

        super.pluginInitialize();

    }


    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        Log.d("NBIsPad", "execute action:" + action);
        if (action.equals("isPad")) {
            Boolean boo = (cordova.getContext().getResources().getConfiguration().screenLayout
                    & Configuration.SCREENLAYOUT_SIZE_MASK)
                    >= Configuration.SCREENLAYOUT_SIZE_LARGE;

            callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, boo));
            return true;
        }else if(action.equals("isPadFromscreen")) {
            Boolean boo = false;
            WindowManager wm = (WindowManager) cordova.getActivity().getSystemService(Context.WINDOW_SERVICE);
            Display display = wm.getDefaultDisplay();
            // 屏幕宽度
            float screenWidth = display.getWidth();
            // 屏幕高度
            float screenHeight = display.getHeight();
            DisplayMetrics dm = new DisplayMetrics();
            display.getMetrics(dm);
            double x = Math.pow(dm.widthPixels / dm.xdpi, 2);
            double y = Math.pow(dm.heightPixels / dm.ydpi, 2);
            // 屏幕尺寸
            double screenInches = Math.sqrt(x + y);
            // 大于6尺寸则为Pad
            if (screenInches >= 6.0) {
                boo = true;
            }
            callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, boo));
            return true;
        }else if(action.equals("hideBottomNavigationBar")) {
          this.hideBottomNavigationBar(callbackContext);
        }
        return false;
    }

    /**
     * 隐藏android底部虚拟按钮
     * @param callbackContext
     * @info 参考：https://blog.csdn.net/QQxiaoqiang1573/article/details/79867127
     */
    private void hideBottomNavigationBar(CallbackContext callbackContext) {
        cordova.getActivity().runOnUiThread(new Runnable() {
            public void run() {
                View decorView = cordova.getActivity().getWindow().getDecorView();
                int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_IMMERSIVE
                        | View.SYSTEM_UI_FLAG_LOW_PROFILE
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY; // 这个是关键
                decorView.setSystemUiVisibility(uiOptions);
                callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, true));
            }
        });
    }

}