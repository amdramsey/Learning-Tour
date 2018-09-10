package com.aramzy.myapplication2;

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View
import android.widget.Button
import android.widget.EditText;
import android.widget.Toast

class MainActivity: AppCompatActivity(){

    lateinit var txt: EditText;
    lateinit var btn: Button;

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.txt = findViewById(R.id.txt);
        this.btn = findViewById(R.id.btn);

        this.btn.setOnClickListener(View.OnClickListener {

            this.btn.text = "${btn.text} ${txt.text}";

            Toast.makeText(this, "Hello ${txt.text}", Toast.LENGTH_SHORT).show();

        });

    }

}