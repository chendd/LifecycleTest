package com.longe9.google.lifecycle;

import android.app.Activity;
import android.app.Application;

public interface IAndroidService {

    Activity getActivity();
    Application getApplication();

    IAndroidLifeCycle getLifeCycle();
    void initActivity(Activity activity);
    void initApplication(Application application);

}
