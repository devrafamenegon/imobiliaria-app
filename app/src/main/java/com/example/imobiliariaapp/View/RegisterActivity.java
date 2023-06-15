package com.example.imobiliariaapp.View;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.imobiliariaapp.Contract.LoginContract;
import com.example.imobiliariaapp.Contract.RegisterContract;
import com.example.imobiliariaapp.Model.Cliente;
import com.example.imobiliariaapp.Presenter.LoginPresenter;
import com.example.imobiliariaapp.Presenter.RegisterPresenter;
import com.example.imobiliariaapp.R;

public class RegisterActivity extends AppCompatActivity implements RegisterContract.View {

    private RegisterContract.Presenter presenter = new RegisterPresenter(this, this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        TextView loginTextView = findViewById(R.id.signupTextViewEntrar);
        loginTextView.setOnClickListener(view -> navigateToLoginScreen());

        Button registerButton = findViewById(R.id.signupBt);
        registerButton.setOnClickListener(view -> register());

    }

    @Override
    public void navigateToLoginScreen() {
        Intent intent = new Intent(this, LoginActivity.class);
        this.startActivity(intent);
    }

    @Override
    public void navigateToHomeScreen() {
        Intent intent = new Intent(this, HomeActivity.class);
        this.startActivity(intent);
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void register() {
        Cliente cliente = new Cliente();
        cliente.setNome(getNome());
        cliente.setCpf(getCpf());
        cliente.setSenha(getSenha());
        cliente.setEmail(getEmail());
        cliente.setTelefone(getTelefone());
        cliente.setDataNascimento(getDataNascimento());
        this.presenter.register(cliente);
    }

    private String getNome() {
        EditText edtTxtNome = findViewById(R.id.signupEtName);
        return edtTxtNome.getText().toString();
    }

    private String getCpf() {
        EditText edtTxtCpf = findViewById(R.id.signupEtCpf);
        return edtTxtCpf.getText().toString();
    }

    private String getTelefone() {
        EditText edtTxtCpf = findViewById(R.id.signupEtTelefone);
        return edtTxtCpf.getText().toString();
    }

    private String getDataNascimento() {
        EditText edtTxtCpf = findViewById(R.id.signupEtDate);
        return edtTxtCpf.getText().toString();
    }

    private String getEmail() {
        EditText edtTxtLogin = findViewById(R.id.signupEtEmail);
        return edtTxtLogin.getText().toString();
    }

    private String getSenha() {
        EditText edtTxtSenha = findViewById(R.id.signupEtPassword);
        return edtTxtSenha.getText().toString();
    }
}