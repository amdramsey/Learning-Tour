package com.aramzy.form;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignInActivity extends AppCompatActivity {
    Button signInButton, backButton;
    EditText mailEditText, passEditText;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        signInButton           = (Button)findViewById(R.id.sign_in_button);
        backButton             = (Button)findViewById(R.id.back_button);

        mailEditText           = (EditText)findViewById(R.id.mail_edit_text);
        passEditText           = (EditText)findViewById(R.id.pass_edit_text);

        intent                 = new Intent(SignInActivity.this, MainActivity.class);

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });
    }
}
