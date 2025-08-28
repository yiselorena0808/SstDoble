package com.example.sstdoble.controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sstdoble.api.ApiClient;
import com.example.sstdoble.api.ApiService;
import com.example.sstdoble.api.LoginRequest;
import com.example.sstdoble.api.LoginResponse;
import com.example.sstdoble.databinding.ActivityMainBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding; // tu XML se llama activity_main.xml (según lo que pegaste)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Botón login
        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hacerLogin();
            }
        });

        // Botón registrarse
        binding.btnRegistrarse.setOnClickListener(v ->
                Toast.makeText(MainActivity.this, "Aquí abrirías tu registro", Toast.LENGTH_SHORT).show()
        );

        // Botón olvidó contraseña
        binding.btnOlvido.setOnClickListener(v ->
                Toast.makeText(MainActivity.this, "Aquí abrirías recuperación de contraseña", Toast.LENGTH_SHORT).show()
        );
    }

    private void hacerLogin() {
        String correo = binding.etCorreo.getText().toString().trim();
        String password = binding.etPassword.getText().toString().trim();

        if (correo.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Completa todos los campos", Toast.LENGTH_SHORT).show();
            return;
        }

        LoginRequest request = new LoginRequest(correo, password);

        ApiService apiService = ApiClient.getClient(null).create(ApiService.class);
        Call<LoginResponse> call = apiService.login(request);

        call.enqueue(new Callback<LoginResponse>() {

            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    LoginResponse loginResponse = response.body();

                    if (loginResponse.getToken() != null && !loginResponse.getToken().isEmpty()) {
                        // ✅ Token válido
                        String token = loginResponse.getToken();
                        Toast.makeText(MainActivity.this, "Bienvenido " + correo, Toast.LENGTH_SHORT).show();

                        // Guardar token
                        getSharedPreferences("auth", MODE_PRIVATE)
                                .edit()
                                .putString("token", token)
                                .apply();

                        startActivity(new Intent(MainActivity.this, MainActivity.class));
                        finish();
                    } else {
                        // ⚠️ Respuesta sin token → credenciales inválidas
                        Toast.makeText(MainActivity.this, "Credenciales incorrectas", Toast.LENGTH_SHORT).show();
                    }

                } else {
                    Toast.makeText(MainActivity.this, "Error: " + response.message(), Toast.LENGTH_SHORT).show();
                }
            }


            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error de conexión: " + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
