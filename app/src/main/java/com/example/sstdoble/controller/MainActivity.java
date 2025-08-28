package com.example.sstdoble.controller;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sstdoble.R;
import com.example.sstdoble.api.ApiService;
import com.example.sstdoble.databinding.ActivityMainBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import com.example.sstdoble.api.LoginRequest;
import com.example.sstdoble.api.LoginResponse;



public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    private ApiService apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        // Configurar Retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://backsst.onrender.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiService = retrofit.create(ApiService.class);

        // Botón Login
        binding.btnLogin.setOnClickListener(v -> {
            String correo = binding.etCorreo.getText().toString().trim();
            String password = binding.etPassword.getText().toString().trim();

            if (correo.isEmpty() || password.isEmpty()) {
                Toast.makeText(MainActivity.this, "Debe completar ambos campos", Toast.LENGTH_SHORT).show();
                return;
            }

            if (!Patterns.EMAIL_ADDRESS.matcher(correo).matches()) {
                Toast.makeText(MainActivity.this, "Correo no válido", Toast.LENGTH_SHORT).show();
                return;
            }

            // 👉 Consumir API
            loginUser(correo, password);
        });

        // Botón Olvido
        binding.btnOlvido.setOnClickListener(v ->
                startActivity(new Intent(MainActivity.this, Registrarme.class))
        );

        // Botón Registrarse
        binding.btnRegistrarse.setOnClickListener(v ->
                startActivity(new Intent(MainActivity.this, Registrarme.class))
        );
    }

    private void loginUser(String correo, String password) {
        LoginRequest request = new LoginRequest(correo, password);

        Call<LoginResponse> call = apiService.login(request);

        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    LoginResponse loginResponse = response.body();

                    if (loginResponse.isSuccess()) {
                        Toast.makeText(MainActivity.this, "Bienvenido " + loginResponse.getMessage(), Toast.LENGTH_LONG).show();

                        // 🚀 Ir a Menu si el login es correcto
                        Intent intent = new Intent(MainActivity.this, Menu.class);
                        intent.putExtra("correo", correo);
                        startActivity(intent);

                    } else {
                        Toast.makeText(MainActivity.this, "Error: " + loginResponse.getMessage(), Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Credenciales incorrectas o error del servidor", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Fallo en la conexión: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
