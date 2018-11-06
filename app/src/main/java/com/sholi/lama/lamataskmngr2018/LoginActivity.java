package com.sholi.lama.lamataskmngr2018;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {
    private EditText etEmail;
    private EditText etPassword;
    private Button btnSignIn;
    private Button btnSignUp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etPassword = (EditText) findViewById(R.id.etPassword);
        btnSignIn = (Button) findViewById(R.id.btnSignIn);
        btnSignUp = (Button) findViewById(R.id.btnSignUp);

        btnSignIn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                dataHandler();
            }
        });
    }

    private void dataHandler() {
        boolean isok = true;

        String email = etEmail.getText().toString();
        String password = etPassword.getText().toString();
        if (email.length() < 4) {
            etEmail.setError("Title have to be than 4 Char");
            isok = false;
        }
        if (password.length() < 4) {
            etPassword.setError("Title have to be than 4 Char");
            isok = false;

        }

    }
    private void signIn(String email,String password){
        auth.signInWithEmailAndPassword(email,password).addOnCompleteListener(LoginActivity.this)

    }
}