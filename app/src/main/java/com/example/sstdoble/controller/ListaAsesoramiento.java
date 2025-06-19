package com.example.sstdoble.controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sstdoble.R;
import com.example.sstdoble.databinding.ActivityListaAsesoramientoBinding;

public class ListaAsesoramiento extends AppCompatActivity {

    ActivityListaAsesoramientoBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_lista_asesoramiento);

        binding = ActivityListaAsesoramientoBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.item1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ListaAsesoramiento.this, CreaAsesoramiento.class));
            }
        });


    }
}