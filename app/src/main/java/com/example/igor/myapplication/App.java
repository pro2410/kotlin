package com.example.igor.myapplication;

import android.app.Application;

import com.example.igor.myapplication.di.AppComponentBuilder;


public class App extends Application {
    private static AppComponentBuilder mAppComponentBuilder;
    @Override
    public void onCreate() {
        super.onCreate();
//        mAppComponentBuilder = DaggerAppComponent.builder().build();
    }

    public static AppComponentBuilder getmAppComponentBuilder() {
        return mAppComponentBuilder;
    }
}
