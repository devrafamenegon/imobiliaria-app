package com.example.imobiliariaapp.Contract;

public interface LoginContract {
    interface View {
        void navigateToHomeScreen();
        void navigateToRegisterScreen();
        void showMessage(String message);
    }

    interface Presenter {
        void login(String email, String senha);
        void saveLogin(String email, String senha);
    }
}
