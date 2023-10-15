package com.example.women_safety;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity11 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main11);
        Button user_1=findViewById(R.id.user_1);
        Button guardian=findViewById(R.id.guardian);
        Button admin=findViewById(R.id.admin);
        user_1.setOnClickListener(View-> {
            Intent intent= new Intent(MainActivity11.this,MainActivity2.class);
            startActivity(intent);
            finish();
        });
        guardian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity11.this,RegisterActivity3.class);
                startActivity(intent);
                finish();
            }
        });

        admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity11.this,LoginuserActivity1.class);
                startActivity(intent);
                finish();
            }
        });

    }
}