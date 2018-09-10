package com.aramzy.internal.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class DBActivity extends AppCompatActivity {
    Button btnShow, btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_db);
        btnShow = (Button)findViewById(R.id.btnShow);
        btnBack = (Button)findViewById(R.id.btnBack);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Back();
            }
        });
    }

    protected void Show() {
        Toast.makeText(this, "Data found", Toast.LENGTH_SHORT).show();
    }

    protected void Back() {
        Toast.makeText(this, "Main page", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}