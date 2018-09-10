package com.aramzy.form;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;

public class SignUpActivity extends AppCompatActivity {
    private Button signUpButton, backButton;
    private EditText fnameEditText, lnameEditText, unameEditText, passEditText, cpassEditText, mailEditText, cmailEditText, bdateEditText;
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        intent           = new Intent(SignUpActivity.this, MainActivity.class);

        signUpButton     = (Button)findViewById(R.id.sign_up_button);
        backButton       = (Button)findViewById(R.id.back_button);

        fnameEditText    = (EditText)findViewById(R.id.fname_edit_text);
        lnameEditText    = (EditText)findViewById(R.id.lname_edit_text);
        unameEditText    = (EditText)findViewById(R.id.uname_edit_text);
        passEditText     = (EditText)findViewById(R.id.pass_edit_text);
        cpassEditText    = (EditText)findViewById(R.id.cpass_edit_text);
        mailEditText     = (EditText)findViewById(R.id.mail_edit_text);
        cmailEditText    = (EditText)findViewById(R.id.cmail_edit_text);
        bdateEditText    = (EditText)findViewById(R.id.bdate_edit_text);



        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(
                        !"".equals(fnameEditText.getText().toString().trim()) &&
                        !"".equals(lnameEditText.getText().toString().trim()) &&
                        !"".equals(unameEditText.getText().toString().trim()) &&
                        !"".equals(passEditText.getText().toString().trim())  &&
                        !"".equals(cpassEditText.getText().toString().trim()) &&
                        !"".equals(mailEditText.getText().toString().trim())  &&
                        !"".equals(cmailEditText.getText().toString().trim()) &&
                        !"".equals(bdateEditText.getText().toString().trim())) {
                    if(passEditText.getText().toString().equals(cpassEditText.getText().toString())) {
                        if(mailEditText.getText().toString().equals(cmailEditText.getText().toString())) {
                            saveData();
                        } else {
                            Toast.makeText(SignUpActivity.this, getResources().getString(R.string.email_does_not_match), Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(SignUpActivity.this, getResources().getString(R.string.password_does_not_match), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(SignUpActivity.this, getResources().getString(R.string.wrong), Toast.LENGTH_SHORT).show();
                }
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });
    }

    private void saveData() {
        try {
            File f = new File(getFilesDir(), "data.txt");
            FileOutputStream file = openFileOutput("data.txt", Context.MODE_PRIVATE);
            file.write((fnameEditText.getText().toString().trim()   + "\n").getBytes());
            file.write((lnameEditText.getText().toString().trim()   + "\n").getBytes());
            file.write((unameEditText.getText().toString().trim()   + "\n").getBytes());
            file.write((passEditText.getText().toString().trim()    + "\n").getBytes());
            file.write((cpassEditText.getText().toString().trim()   + "\n").getBytes());
            file.write((mailEditText.getText().toString().trim()    + "\n").getBytes());
            file.write((cmailEditText.getText().toString().trim()   + "\n").getBytes());
            file.write((bdateEditText.getText().toString().trim()   + "\n").getBytes());
            file.close();
            Log.d("My tag", f.getAbsolutePath());
        } catch(Exception ex) {
            Log.d("My tag", ex.toString());
        }
    }
}