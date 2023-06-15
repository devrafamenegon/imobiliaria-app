package com.example.imobiliariaapp.Contract;

public class LoginContract {
    interface View {
        void navigateToHomeScreen();
        void navigateToRegisterScreen();
        void showMessage(String message);
    }

    interface Presenter {
        void login(String login, String password, String ip);
    }
}
