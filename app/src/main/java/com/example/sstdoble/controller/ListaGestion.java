package com.example.sstdoble.controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sstdoble.databinding.ActivityListaGestionBinding;

import java.util.ArrayList;
import java.util.List;

public class ListaGestion extends AppCompatActivity {

    ActivityListaGestionBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityListaGestionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ViewCompat.setOnApplyWindowInsetsListener(binding.main, (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        RecyclerView recyclerView = binding.recyclerViewListaGestion;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Lista de ejemplo
        List<ListaGestionItem> lista = new ArrayList<>();
        lista.add(new ListaGestionItem("Juan Pérez", "2025-05-19"));
        lista.add(new ListaGestionItem("Ana Torres", "2025-05-18"));

        ListaGestionAdapter adapter = new ListaGestionAdapter(this, lista);
        recyclerView.setAdapter(adapter);

        binding.btncrear.setOnClickListener(v -> {
            startActivity(new Intent(ListaGestion.this, FormGestion.class));
        });
    }
}
