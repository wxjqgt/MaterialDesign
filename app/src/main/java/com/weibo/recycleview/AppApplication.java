package com.weibo.recycleview;

import android.app.Application;
import android.content.Context;

/**
 * Created by Administrator on 2016/7/15.
 */
public class AppApplication extends Application {

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }

    public static Context getAppContext(){
        return context;
    }
}
