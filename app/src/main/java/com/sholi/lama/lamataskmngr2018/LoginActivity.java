package com.sholi.lama.lamataskmngr2018;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.sholi.lama.lamataskmngr2018.taskfragments.AddTaskActivity;

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
        signIn(email,password);
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
            FirebaseAuth auth=FirebaseAuth.getInstance().getInstance();
            auth.signInWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        Toast.makeText(LoginActivity.this,"signIn Successful",Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(LoginActivity.this,MainTabsActivity.class );
                        startActivity(intent);
                        finish();

                    }
                    else {
                        Toast.makeText(LoginActivity.this, "signIn"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        task.getException().printStackTrace();
                    }
                }

            });


    }
}