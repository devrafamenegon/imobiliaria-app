package com.example.imobiliariaapp.Presenter;

import android.content.Context;
import android.content.SharedPreferences;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.imobiliariaapp.Contract.LoginContract;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class LoginPresenter implements LoginContract.Presenter {
    private final LoginContract.View view;
    private final Context context;

    public LoginPresenter(LoginContract.View view, Context context) {
        this.view = view;
        this.context = context;
    }
    @Override
    public void login(String email, String senha) {
        String API_URL = "http://192.168.1.2:8081/cliente/login";

        RequestQueue requestQueue = Volley.newRequestQueue(context);

        JSONObject request = new JSONObject();
        try {
            request.put("email", email);
            request.put("senha", senha);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        JsonObjectRequest jsonObjectRequest =
                new JsonObjectRequest(Request.Method.POST, API_URL, request,
                    response -> {
                        try {
                            String status = response.getString("status");
                            String message = response.optString("message");

                            if (status.equals("success")) {
                                view.showMessage(message);
                                view.navigateToHomeScreen();
                                saveLogin(email, senha);
                            } else {
                                view.showMessage(message);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    },
                    error -> {
                        try {
                            NetworkResponse networkResponse = error.networkResponse;
                            if (networkResponse != null && networkResponse.statusCode == 400) {
                                view.showMessage("Email e/ou Senha inválidos!");
                            } else {
                                System.out.println(error.getMessage());
                                view.showMessage("Erro na requisição");
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                ) {
                    @Override
                    public Map<String, String> getHeaders() {
                        Map<String, String> headers = new HashMap<>();
                        headers.put("Content-Type", "application/json");
                        return headers;
                    }
                };

        requestQueue.add(jsonObjectRequest);
    }

    @Override
    public void saveLogin(String email, String senha) {
        SharedPreferences sharedPref = context.getSharedPreferences("", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("email", email);
        editor.putString("senha", senha);
        editor.commit();
    }
}
