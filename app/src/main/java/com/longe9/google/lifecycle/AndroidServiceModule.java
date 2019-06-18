package com.longe9.google.lifecycle;

import android.app.Activity;
import android.app.Application;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AndroidServiceModule implements IAndroidService {

    private Activity activity;
    private Application application;
    private IAndroidLifeCycle lifeCycle = new LifeCycle();

    private static AndroidServiceModule instance = new AndroidServiceModule();
    private AndroidServiceModule(){}
    public static AndroidServiceModule getInstance(){
        return instance;
    }

    private static class LifeCycle extends HashMap<IAndroidLifeCycle.Type,List<Action1<Object[]>>> implements IAndroidLifeCycle {
        @Override
        public void register(Type funcName, Action1<Object[]> action1) {
            List<Action1<Object[]>> list;
            if (containsKey(funcName)){
                list = get(funcName);
            }else{
                list = new ArrayList<>();
                put(funcName,list);
            }
            list.add(action1);
        }

        @Override
        public void unregister(Type funcName, Action1<Object[]> action) {
            if (containsKey(funcName)){
                get(funcName).remove(action);
            }
        }

        @Override
        public void dispatch(Type funcName, Object... objects) {
            if (containsKey(funcName)){
                for(Action1<Object[]> action:get(funcName)){
                    try {
                        action.call(objects);
                    }catch (Throwable ex){
                        System.out.println("!!!!!!!! dispatch "+funcName+" !!!!!!!!");
                        ex.printStackTrace();
                        System.out.println("!!!!!!!! dispatch "+funcName+" !!!!!!!!");
                    }
                }
            }
        }
    }

    @Override
    public Activity getActivity() {
        return activity;
    }

    @Override
    public Application getApplication() {
        return application;
    }

    @Override
    public IAndroidLifeCycle getLifeCycle() {
        return lifeCycle;
    }

    @Override
    public void initActivity(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void initApplication(Application application) {
        this.application = application;
    }
}
