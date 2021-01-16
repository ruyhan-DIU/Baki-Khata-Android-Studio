package com.example.bakikhata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.TextView;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {
    TextView register;
    TextView Home;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        register = findViewById(R.id.btnRegister);
        register.setOnClickListener((v) -> {
           Intent intent = new Intent(MainActivity.this,register.class);
           startActivity(intent);

        });

        Home = findViewById(R.id.btnLogin);
        Home.setOnClickListener((v) -> {
            Intent intent = new Intent(MainActivity.this,Home.class);
            startActivity(intent);

        });
    }
}