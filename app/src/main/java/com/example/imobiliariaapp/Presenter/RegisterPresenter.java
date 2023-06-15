package com.example.imobiliariaapp.Presenter;

import android.content.Context;
import android.content.SharedPreferences;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.imobiliariaapp.Contract.RegisterContract;
import com.example.imobiliariaapp.Model.Cliente;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class RegisterPresenter implements RegisterContract.Presenter{

    private final RegisterContract.View view;
    private final Context context;

    public RegisterPresenter(RegisterContract.View view, Context context) {
        this.view = view;
        this.context = context;
    }

    @Override
    public void register(Cliente cliente) {
        String API_URL = "http://192.168.1.2:8081/cliente/register";

        RequestQueue requestQueue = Volley.newRequestQueue(context);

        JSONObject request = new JSONObject();
        try {
            request.put("nome", cliente.getNome());
            request.put("senha", cliente.getSenha());
            request.put("email", cliente.getEmail());
            request.put("dataNascimento", cliente.getDataNascimento());
            request.put("cpf", cliente.getCpf());
            request.put("telefone", cliente.getTelefone());
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
                                    saveLogin(cliente.getEmail(), cliente.getSenha());
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
