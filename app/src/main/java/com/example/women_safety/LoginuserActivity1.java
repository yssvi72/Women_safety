package com.example.women_safety;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginuserActivity1 extends AppCompatActivity {
    TextInputEditText editTextemlog ,editTextpasslog;
    Button login;
    FirebaseAuth mAuth;
    TextView textviewclicklogin;
    @Override

    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            Intent intent =new Intent(getApplicationContext(),MainActivity2.class);
            startActivity(intent);
            finish();
        }
    }
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginuser1);
        EditText editTextemlog=(EditText)findViewById(R.id.emaillog);
        EditText editTextpasslog=(EditText)findViewById(R.id.passlog);
        Button login=findViewById(R.id.login);
        mAuth=FirebaseAuth.getInstance();
        TextView textViewclickregister=findViewById(R.id.clickregister);
        textViewclickregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getApplicationContext(),RegisterActivity3.class);
                startActivity(intent);
                finish();
            }
        });
        login.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                String email, passwordset;
                email = String.valueOf(editTextemlog.getText());

                passwordset = String.valueOf(editTextpasslog.getText());


                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(LoginuserActivity1.this, "Enter email", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(passwordset)) {
                    Toast.makeText(LoginuserActivity1.this, "Enter password", Toast.LENGTH_SHORT).show();
                    return;
                }
                mAuth.signInWithEmailAndPassword(email, passwordset)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    Toast.makeText(LoginuserActivity1.this, "Login successful.",
                                                                         Toast.LENGTH_SHORT).show();
                                    Intent intent =new Intent(getApplicationContext(),MainActivity2.class);
                                    startActivity(intent);
                                    finish();
                                } else {
                                    // If sign in fails, display a message to the user.

                                    Toast.makeText(LoginuserActivity1.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();

                                }
                            }
                        });


            }
            });
        }
    }
