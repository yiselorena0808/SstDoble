package com.example.sstdoble.controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sstdoble.R;
import com.example.sstdoble.databinding.ActivityMenuBinding;

public class Menu extends AppCompatActivity {

    ActivityMenuBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        binding = ActivityMenuBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.btnGestionEpp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Menu.this, ListaGestion.class));
            }
        });

        binding.btnAct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Menu.this, ListaActividades.class));
            }
        });

        binding.btnAsesoramiento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Menu.this, ListaAsesoramiento.class));
            }
        });

        binding.btnListaChequeo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Menu.this, ListaChequeo.class));
            }
        });

        binding.btnBlog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Menu.this, Blog.class));
            }
        });

        binding.btnReportes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Menu.this, ListaReportes.class));
            }
        });


    }
}