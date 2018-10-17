package com.sholi.lama.lamataskmngr2018;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignInActivity extends AppCompatActivity {
    // private EditText etFirstName;
    //  private EditText etLastName;
    //  private EditText etPhone;
    // private EditText etEmail;
    // private EditText etPassword;
    private FirebaseAuth auth;
    private FirebaseUser firebaseUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        auth = FirebaseAuth.getInstance();
        firebaseUser = auth.getCurrentUser();
        //  etFirstName=(EditText)findViewById(R.id.etFirstName);
        //  etLastName=(EditText)findViewById(R.id.etLastName);
        //  etPhone=(EditText)findViewById(R.id.etLastName);
        // etEmail=(EditText)findViewById(R.id.etEmail);
        //  etPassword=(EditText)findViewById(R.id.etPassword);
        if (firebaseUser == null) {
            startActivity(new Intent(this, SignInActivity.class));
            finish();
            return;
        } else {
            String userName = firebaseUser.getDisplayName();
            if (firebaseUser.getPhotoUrl() != null) {
                String photoUrl = firebaseUser.getPhotoUrl().toString();
            }
        }
        FirebaseAuth.AuthStateListener authStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    Toast.makeText(SignInActivity.this, "user is signed in", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(SignInActivity.this,"user signed out",Toast.LENGTH_SHORT).show();
                }

                }


        };
    }
}