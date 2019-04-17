package com.thetruders.food;


import android.os.Handler;
import android.support.annotation.NonNull;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.util.Log;
import android.widget.EditText;
import android.content.Intent;


import android.view.View;
import android.widget.Button;


import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class LoginActivity extends AppCompatActivity {


    FirebaseAuth.AuthStateListener authStateListener;
    private static final String TAG = "";








    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.login_activity);


        final FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();

        if (firebaseAuth.getCurrentUser() != null) {
            startActivity(new Intent(LoginActivity.this, HomeActivity.class));
            finish();
        }

//        setContentView(R.layout.login_activity);

        final ProgressBar progressBar = findViewById(R.id.progressbar);
        Button forgetPass = findViewById(R.id.forget_button);
        final Button login = findViewById(R.id.buttonLogin);
        Button signup = findViewById(R.id.newUserBtn);
        final EditText email = findViewById(R.id.login_emailid);
        final EditText password = findViewById(R.id.login_password);
        Log.d("Login==`11111===","Loginnnnn");
        authStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {

                    Toast.makeText(LoginActivity.this, "user logged in", Toast.LENGTH_SHORT).show();
                    Intent I = new Intent(LoginActivity.this, HomeActivity.class);
                    startActivity(I);
                    finish();
                } else {
                    Toast.makeText(LoginActivity.this, "Login to continue", Toast.LENGTH_SHORT).show();
                }
            }
        };


        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, SignUpActivity.class));
            }
        });

        forgetPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, ResetPassword.class));
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                String user_email = email.getText().toString();
                final String user_password = password.getText().toString();

                if (user_email.isEmpty()) {
                    email.setError("Provide your email first");
                    email.requestFocus();
                }
                if (user_password.isEmpty()) {
                    password.setError("Enter Password");
                    password.requestFocus();
                }



                progressBar.setVisibility(View.VISIBLE);

                firebaseAuth.signInWithEmailAndPassword(user_email, user_password).addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        progressBar.setVisibility(View.GONE);

                        if (task.isSuccessful()) {

                            Log.d(TAG, "signInWithEmail:success");
                            Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                            startActivity(intent);
                            finish();
                        }


                        else {

                            Log.d(TAG, "singInWithEmail:Fail");
                            Toast.makeText(LoginActivity.this, getString(R.string.auth_failed), Toast.LENGTH_LONG).show();
                        }
                    }

                });
            }
        });
    }
}
