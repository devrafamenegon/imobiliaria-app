package com.example.imobiliariaapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
        introStartBtn.setOnClickListener(view -> startActivity(new Intent(IntroActivity.this, HomeActivity.class)));
    }
}