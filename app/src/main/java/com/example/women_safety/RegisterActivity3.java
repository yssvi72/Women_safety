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

public class RegisterActivity3 extends AppCompatActivity {
    TextInputEditText  editTextemail ,editTextpasswordset;
    Button register;
    FirebaseAuth mAuth;
    TextView textviewclickregister;
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register3);

       EditText editTextemail=(EditText)findViewById(R.id.email);
       EditText editTextpasswordset=(EditText)findViewById(R.id.passwordset);
       Button register=findViewById(R.id.register);
        mAuth=FirebaseAuth.getInstance();
       TextView textViewclickregister=findViewById(R.id.clickregister);
       textViewclickregister.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
             Intent intent= new Intent(getApplicationContext(),LoginuserActivity1.class);
           startActivity(intent);
           finish();
           }
       });
       register.setOnClickListener(new View.OnClickListener(){
           public void onClick(View view){
            String email,passwordset;
            email=String.valueOf(editTextemail.getText());

            passwordset=String.valueOf(editTextpasswordset.getText());


            if(TextUtils.isEmpty(email)){
                Toast.makeText(RegisterActivity3.this,"Enter email",Toast.LENGTH_SHORT).show();
                 return; }
               if(TextUtils.isEmpty(passwordset)){
                   Toast.makeText(RegisterActivity3.this,"Enter password",Toast.LENGTH_SHORT).show();
                return; }
               mAuth.createUserWithEmailAndPassword(email, passwordset)
                       .addOnCompleteListener( new OnCompleteListener<AuthResult>() {
                           @Override
                           public void onComplete(@NonNull Task<AuthResult> task) {
                               if (task.isSuccessful()) {
                                   Toast.makeText(RegisterActivity3.this, "Account Created",
                                           Toast.LENGTH_SHORT).show();
                                   Intent intent =new Intent(getApplicationContext(),LoginuserActivity1.class);
                                   startActivity(intent);
                                   finish();
                               } else {
                                   // If sign in fails, display a message to the user.

                                   Toast.makeText(RegisterActivity3.this, "Authentication failed.",
                                           Toast.LENGTH_SHORT).show();

                               }
                           }
                       });

           }

       });


    }
}