package com.example.women_safety;

import androidx.appcompat.app.AppCompatActivity;
import android.view.Window;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                if (MainActivity.this == null) {
                    return;
                }
                Intent intent = new Intent(getApplicationContext(), MainActivity11.class);
                startActivity(intent);
                finish();
            }
        }, 3000);

    }
}