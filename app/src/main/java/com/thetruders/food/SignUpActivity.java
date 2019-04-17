package com.thetruders.food;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import static com.thetruders.food.R.layout.signup_activity;

public class SignUpActivity extends AppCompatActivity {

    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(signup_activity);

        final FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();


        final EditText inputEmail = findViewById(R.id.signup_email);
        final EditText inputPassword = findViewById(R.id.password);
        Button btnSignup = findViewById(R.id.signUpBtn);
        Button btnAlreadyUser = findViewById(R.id.backToLoginBtn);
        progressBar = findViewById(R.id.progressbar);


        btnAlreadyUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String signup_email = inputEmail.getText().toString().trim();
                String password = inputPassword.getText().toString().trim();

                if (TextUtils.isEmpty(signup_email)){

                    Toast.makeText(getApplicationContext(), "Enter Email Address!!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(password)){

                    Toast.makeText(getApplicationContext(), "Enter Password!!", Toast.LENGTH_SHORT).show();
                    return;
                }
                
                if (password.length() < 6){

                    Toast.makeText(getApplicationContext(), "Password to short,enter minimum 6 digits!!", Toast.LENGTH_SHORT).show();
                    return;
                }

                progressBar.setVisibility(View.VISIBLE);

                firebaseAuth.createUserWithEmailAndPassword(signup_email,password).addOnCompleteListener(SignUpActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Toast.makeText(SignUpActivity.this, "createUserWithEmail:onComplete:" + task.isSuccessful(), Toast.LENGTH_SHORT).show();
                        progressBar.setVisibility(View.GONE);

                        if (!task.isSuccessful()){
                            Toast.makeText(SignUpActivity.this, "Authentication Failed" + task.getException(), Toast.LENGTH_SHORT).show();
                        }
                        else{

                            startActivity(new Intent(SignUpActivity.this,HomeActivity.class));
                            finish();
                        }
                    }
                });


            }
        });

    }

//   @Override
//    protected void onResume() {
//        super.onResume();
//        progressBar.setVisibility(View.GONE);
//    }
}

