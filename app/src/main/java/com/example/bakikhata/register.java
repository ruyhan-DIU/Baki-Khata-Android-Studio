package com.example.bakikhata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class register extends AppCompatActivity {
    TextView MainActivity;
    TextView OTP_verification;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        MainActivity=findViewById(R.id.btnRegister);
        MainActivity.setOnClickListener((v) -> {
            Intent intent = new Intent(register.this,MainActivity.class);
            startActivity(intent);

        });
        OTP_verification=findViewById(R.id.regbutton);
        OTP_verification.setOnClickListener((v) -> {
            Intent intent = new Intent(register.this,OTP_verification.class);
            startActivity(intent);

        });

    }
}