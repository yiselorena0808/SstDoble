package com.example.sstdoble.controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sstdoble.R;
import com.example.sstdoble.databinding.ActivityCreaAsesoramientoBinding;


public class CreaAsesoramiento extends AppCompatActivity {

    ActivityCreaAsesoramientoBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_crea_asesoramiento);

        binding = ActivityCreaAsesoramientoBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.btnSubirAses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CreaAsesoramiento.this, ListaAsesoramiento.class));
            }
        });

    }
}