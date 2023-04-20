package com.example.imobiliariaapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.imobiliariaapp.R;

public class LoginActivity extends AppCompatActivity {
    TextView loginTxtViewRegister = findViewById(R.id.loginTxtViewCadastrar);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginTxtViewRegister.setOnClickListener(view -> {
            Intent intent = new Intent(this, RegisterActivity.class);
            this.startActivity(intent);
        });
    }
}