package com.some.retrofitpractice;

import android.app.Application;

public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Repo.getInstance().init(this);
    }
}
