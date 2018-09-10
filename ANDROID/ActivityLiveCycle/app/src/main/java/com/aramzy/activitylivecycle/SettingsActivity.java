package com.aramzy.activitylivecycle;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class SettingsActivity extends AppCompatActivity {

    private static final String TAG = SettingsActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        Log.i(TAG, "LOG: onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "LOG: onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "LOG: onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "LOG: onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "LOG: onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "LOG: onDestroy");
    }

}