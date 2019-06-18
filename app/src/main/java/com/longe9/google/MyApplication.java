package com.longe9.google;

import android.app.Application;
import android.content.Context;

import com.longe9.google.lifecycle.AndroidServiceModule;
import com.longe9.google.lifecycle.IAndroidLifeCycle;
import com.longe9.google.lifecycle.IAndroidService;

public class MyApplication extends Application {

    private IAndroidService androidService;

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        androidService = AndroidServiceModule.getInstance();
        androidService.initApplication(this);

        Test test = new Test();
        test.main();

    }

    @Override
    public void onCreate() {
        super.onCreate();
        androidService.getLifeCycle().dispatch(IAndroidLifeCycle.Type.OnApplicationCreate);
    }
}
