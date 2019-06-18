package com.longe9.google.lifecycle;


public interface IAndroidLifeCycle {
    void register(Type funcName, Action1<Object[]> action1);

    void unregister(Type funcName, Action1<Object[]> action);

    void dispatch(Type funcName, Object... objects);

    enum Type {
        OnApplicationCreate,
        OnCreate,
        OnStart,
        OnResume,
        OnPause,
        OnStop,
        OnDestroy,
        OnActivityResult,
        OnNewIntent
    }
}

