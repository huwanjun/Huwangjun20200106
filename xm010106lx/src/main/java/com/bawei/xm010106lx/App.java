package com.bawei.xm010106lx;

import android.app.Application;

/**
 * author: 斛万珺
 * data: 2020/1/6 14:14:19
 * function:
 */
public class App extends Application {

    public static App app;

    @Override
    public void onCreate() {
        super.onCreate();
        app=this;
    }
}
