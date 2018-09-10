package com.aramzy.activitylivecycle;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "LOG: onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "LOG: onDestroy");
    }

    public void openSettings(View view) {
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }

    public void openDialog(View view) {
        Intent intent = new Intent(this, DialogActivity.class);
        startActivity(intent);
    }
}