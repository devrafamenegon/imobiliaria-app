package com.example.imobiliariaapp.Contract;

import com.example.imobiliariaapp.Model.Cliente;

public class RegisterContract {
    interface View {
        void navigateToLoginScreen();
        void navigateToHomeScreen();
        void showMessage(String message);
    }

    interface Presenter {
        void register(Cliente cliente);
    }
}
