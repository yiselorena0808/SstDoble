package com.example.sstdoble.controller;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sstdoble.databinding.ActivityListaChequeoBinding;
import com.example.sstdoble.model.ManagerDb;

import java.util.List;

public class ListaChequeo extends AppCompatActivity {

    ActivityListaChequeoBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityListaChequeoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ViewCompat.setOnApplyWindowInsetsListener(binding.main, (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Configurar RecyclerView
        RecyclerView recyclerView = binding.recyclerViewListaChequeo;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Obtener datos desde la base de datos usando ManagerDb
        ManagerDb managerDb = new ManagerDb(this);
        List<ListaChequeoItem> lista = managerDb.obtenerListasChequeo();

        // Asignar el adapter con la lista desde SQLite
        ListaChequeoAdapter adapter = new ListaChequeoAdapter(this, lista);
        recyclerView.setAdapter(adapter);

        // Botón para crear nueva lista de chequeo
        binding.imgButtonCrear2.setOnClickListener(v -> {
            startActivity(new Intent(ListaChequeo.this, FormChequeo.class));
        });
    }
}

