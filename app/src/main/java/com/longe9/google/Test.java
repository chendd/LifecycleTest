package com.longe9.google;

import com.longe9.google.lifecycle.Action1;
import com.longe9.google.lifecycle.AndroidServiceModule;
import com.longe9.google.lifecycle.IAndroidLifeCycle;
import com.longe9.google.lifecycle.IAndroidService;

/**
 * @author Administrator
 * @Time 2019/6/17.
 */
public class Test {

    IAndroidService androidService;

    void main() {
        androidService = AndroidServiceModule.getInstance();

        androidService.getLifeCycle().register(IAndroidLifeCycle.Type.OnApplicationCreate, new Action1<Object[]>() {
            @Override
            public void call(Object[] params) {
                System.out.println("-------------- OnApplicationCreate --------------");
            }
        });

        androidService.getLifeCycle().register(IAndroidLifeCycle.Type.OnCreate, new Action1<Object[]>() {
            @Override
            public void call(Object[] params) {
                System.out.println("-------------- OnCreate --------------");
            }
        });

        androidService.getLifeCycle().register(IAndroidLifeCycle.Type.OnStart, new Action1<Object[]>() {
            @Override
            public void call(Object[] params) {
                System.out.println("-------------- OnStart --------------");
            }
        });

        androidService.getLifeCycle().register(IAndroidLifeCycle.Type.OnResume, new Action1<Object[]>() {
            @Override
            public void call(Object[] params) {
                System.out.println("-------------- OnResume --------------");
            }
        });

        androidService.getLifeCycle().register(IAndroidLifeCycle.Type.OnPause, new Action1<Object[]>() {
            @Override
            public void call(Object[] params) {
                System.out.println("-------------- OnPause --------------");
            }
        });

        androidService.getLifeCycle().register(IAndroidLifeCycle.Type.OnStop, new Action1<Object[]>() {
            @Override
            public void call(Object[] params) {
                System.out.println("-------------- OnStop --------------");
            }
        });

        androidService.getLifeCycle().register(IAndroidLifeCycle.Type.OnDestroy, new Action1<Object[]>() {
            @Override
            public void call(Object[] params) {
                System.out.println("-------------- OnDestroy --------------");
            }
        });

        androidService.getLifeCycle().register(IAndroidLifeCycle.Type.OnActivityResult, new Action1<Object[]>() {
            @Override
            public void call(Object[] params) {
                System.out.println("-------------- OnActivityResult --------------");
            }
        });

        androidService.getLifeCycle().register(IAndroidLifeCycle.Type.OnNewIntent, new Action1<Object[]>() {
            @Override
            public void call(Object[] params) {
                System.out.println("-------------- OnNewIntent --------------");
            }
        });

    }

}
