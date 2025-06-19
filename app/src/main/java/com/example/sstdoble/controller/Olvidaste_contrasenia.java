package com.example.sstdoble.controller;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sstdoble.R;

public class Olvidaste_contrasenia extends AppCompatActivity {
    EditText editCorreoRe;
    Button btnOlvidaste;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_olvidaste_contrasenia);
        editCorreoRe = findViewById(R.id.edtCorreoRe);
        btnOlvidaste = findViewById(R.id.btnOlvido);

        btnOlvidaste.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String correoIngresado = editCorreoRe.getText().toString().trim();

                if (correoIngresado.isEmpty()) {
                    Toast.makeText(Olvidaste_contrasenia.this, "Por favor ingresa tu correo", Toast.LENGTH_SHORT).show();
                } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(correoIngresado).matches()) {
                    Toast.makeText(Olvidaste_contrasenia.this, "Correo inválido", Toast.LENGTH_SHORT).show();
                } else {
                    // Aquí puedes agregar lógica para enviar correo de recuperación
                    Toast.makeText(Olvidaste_contrasenia.this, "Se ha enviado un correo de recuperación", Toast.LENGTH_LONG).show();
                }
            }
        });
    }


    }
