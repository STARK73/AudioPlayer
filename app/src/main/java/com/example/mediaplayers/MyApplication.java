package com.example.mediaplayers;

import android.app.Application;

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        MediaPlay.init(this);
    }
}