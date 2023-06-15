package com.example.imobiliariaapp.Contract;

import com.example.imobiliariaapp.Model.Cliente;

public interface RegisterContract {
    interface View {
        void navigateToLoginScreen();
        void navigateToHomeScreen();
        void showMessage(String message);
        void register();
    }

    interface Presenter {
        void register(Cliente cliente);
        void saveLogin(String email, String senha);
    }
}
