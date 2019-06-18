package com.longe9.google;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.longe9.google.lifecycle.AndroidServiceModule;
import com.longe9.google.lifecycle.IAndroidLifeCycle;
import com.longe9.google.lifecycle.IAndroidService;

public class MainActivity extends Activity {

    private IAndroidService androidService;
    private IAndroidLifeCycle lifeCycler;//负责：重启、暂停、结束




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        androidService = AndroidServiceModule.getInstance();
        androidService.initActivity(this);
        lifeCycler = androidService.getLifeCycle();
        lifeCycler.dispatch(IAndroidLifeCycle.Type.OnCreate);

        findViewById(R.id.btn_test).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(MainActivity.this,SecondActivity.class),1);
            }
        });

    }


    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        lifeCycler.dispatch(IAndroidLifeCycle.Type.OnNewIntent, intent);
    }

    // Quit Unity
    @Override
    protected void onDestroy()// [UnityMake]
    {
        lifeCycler.dispatch(IAndroidLifeCycle.Type.OnDestroy);
        super.onDestroy();// [UnityMake]
    }

    // Pause Unity
    @Override
    protected void onPause()// [UnityMake]
    {
        lifeCycler.dispatch(IAndroidLifeCycle.Type.OnPause);
        super.onPause();// [UnityMake]
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        lifeCycler.dispatch(IAndroidLifeCycle.Type.OnActivityResult, requestCode, resultCode, data);
    }

    @Override
    protected void onResume()// [UnityMake]
    {
        super.onResume();// [UnityMake]
        lifeCycler.dispatch(IAndroidLifeCycle.Type.OnResume);
    }

    @Override
    protected void onStart() {
        super.onStart();
        lifeCycler.dispatch(IAndroidLifeCycle.Type.OnStart);
    }

    @Override
    protected void onStop() {
        super.onStop();
        lifeCycler.dispatch(IAndroidLifeCycle.Type.OnStop);
    }


}
