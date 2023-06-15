package com.example.imobiliariaapp.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.imobiliariaapp.Contract.LoginContract;
import com.example.imobiliariaapp.Presenter.LoginPresenter;
import com.example.imobiliariaapp.R;

public class LoginActivity extends AppCompatActivity implements LoginContract.View {
    private LoginContract.Presenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        presenter = new LoginPresenter(this, this);

        TextView loginTxtViewRegister = findViewById(R.id.loginTxtViewCadastrar);
        Button loginButton = findViewById(R.id.loginBt);

        loginTxtViewRegister.setOnClickListener(view -> navigateToRegisterScreen());
        loginButton.setOnClickListener(view -> presenter.login(getEmail(), getSenha()));
    }

    @Override
    public void navigateToHomeScreen() {
        Intent intent = new Intent(this, HomeActivity.class);
        this.startActivity(intent);
    }

    @Override
    public void navigateToRegisterScreen() {
        Intent intent = new Intent(this, RegisterActivity.class);
        this.startActivity(intent);
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    private String getEmail() {
        EditText edtTxtLogin = findViewById(R.id.loginEtEmail);
        return edtTxtLogin.getText().toString();
    }

    private String getSenha() {
        EditText edtTxtSenha = findViewById(R.id.loginEtPassword);
        return edtTxtSenha.getText().toString();
    }
}