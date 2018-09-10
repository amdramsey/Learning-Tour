package com.aramzy.internal.myapplication;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {
    EditText uname1, pass1, mail1, fname1, lname1;
    Button btnSD, btnDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        uname1 = (EditText)findViewById(R.id.uname1);
        pass1 = (EditText)findViewById(R.id.pass1);
        mail1 = (EditText)findViewById(R.id.mail1);
        fname1 = (EditText)findViewById(R.id.fname1);
        lname1 = (EditText)findViewById(R.id.lname1);
        btnSD = (Button)findViewById(R.id.btnSD);
        btnDB = (Button)findViewById(R.id.btnDB);

        btnSD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Save();
            }
        });

        btnDB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Next();
            }
        });
    }

    protected void Save() {
        String uname2 = uname1.getText().toString();
        String pass2 = pass1.getText().toString();
        String mail2 = mail1.getText().toString();
        String fname2 = fname1.getText().toString();
        String lname2 = lname1.getText().toString();
        File file = null;
        //if(uname2.trim().equals("") && pass2.trim().equals("") && mail2.trim().equals("") && fname2.trim().equals("") && lname2.trim().equals("")) {
            uname2    = uname2 + " ";
            pass2     = pass2 + " ";
            mail2     = mail2 + " ";
            fname2    = fname2 + " ";
            lname2    = lname2 + " ";
            try {
                file = getFilesDir();
                FileOutputStream fileOutputStream = openFileOutput("/storage/emulated/0/muhammed", Context.MODE_PRIVATE);
                fileOutputStream.write(uname2.getBytes());
                fileOutputStream.write(pass2.getBytes());
                fileOutputStream.write(mail2.getBytes());
                fileOutputStream.write(fname2.getBytes());
                fileOutputStream.write(lname2.getBytes());
                fileOutputStream.close();
            } catch(Exception ex) {
                Toast.makeText(this, "Error: " + ex.toString(), Toast.LENGTH_SHORT);
            }
            Toast.makeText(this, "Saved successfully: " + file, Toast.LENGTH_SHORT).show();
        //} else {
            Toast.makeText(this, "Please enter all fields", Toast.LENGTH_SHORT).show();
        //}
    }

    protected void Next() {
        Toast.makeText(this, "Database page", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, DBActivity.class);
        startActivity(intent);
    }
}