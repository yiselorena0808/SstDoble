package com.example.sstdoble.controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;


import com.example.sstdoble.R;
import com.example.sstdoble.databinding.ActivityRegistrarmeBinding;

public class Registrarme extends AppCompatActivity {

    ActivityRegistrarmeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_registrarme);

        binding = ActivityRegistrarmeBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.btnIniciarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Registrarme.this, Menu.class));

            }
        });


    }
}