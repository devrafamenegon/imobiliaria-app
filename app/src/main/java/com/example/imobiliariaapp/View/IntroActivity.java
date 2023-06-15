package com.example.imobiliariaapp.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;

import com.example.imobiliariaapp.R;

public class IntroActivity extends AppCompatActivity {
    private Button introStartBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        initView();
    }

    private void initView() {
        introStartBtn = findViewById(R.id.introStartBtn);
        introStartBtn.setOnClickListener(view -> startActivity(new Intent(this, LoginActivity.class)));

        SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
        String email = sharedPref.getString("email", "");

        if (email != "") {
            startActivity(new Intent(this, HomeActivity.class));
        }
    }
}