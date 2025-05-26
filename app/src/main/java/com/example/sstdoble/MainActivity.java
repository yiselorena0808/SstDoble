package com.example.sstdoble;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sstdoble.databinding.ActivityMainBinding;

import android.util.Patterns;


public class MainActivity extends AppCompatActivity {
    Button btnLogin,btnRegistrarse,btnOlvido;
    EditText etCorreo, etPassword;

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etCorreo = findViewById(R.id.etCorreo);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String correo = etCorreo.getText().toString().trim();
                String password = etPassword.getText().toString().trim();

                if (correo.isEmpty() || password.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Debe completar ambos campos", Toast.LENGTH_SHORT).show();

                    if (!Patterns.EMAIL_ADDRESS.matcher(correo).matches()) {
                        Toast.makeText(MainActivity.this, "Correo no válido", Toast.LENGTH_SHORT).show();
                        return;
                    }


                    Intent intent = new Intent(MainActivity.this, Registrarme.class);
                    intent.putExtra("correo", correo);
                    startActivity(intent);
                }

            }
        });
        binding.btnOlvido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Registrarme.class));
            }
        });
        binding.btnRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainActivity.this,Menu.class));
            }
        });



    }
}