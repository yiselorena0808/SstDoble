package com.example.sstdoble.controller;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sstdoble.databinding.ActivityListaReportesBinding;
import com.example.sstdoble.model.ManagerDb;


import java.util.List;

public class ListaReportes extends AppCompatActivity {

    private ActivityListaReportesBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityListaReportesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ViewCompat.setOnApplyWindowInsetsListener(binding.main, (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Configurar RecyclerView
        RecyclerView recyclerView = binding.recyclerViewListaReportes;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Obtener datos desde la base de datos usando ManagerDb
        ManagerDb managerDb = new ManagerDb(this);
        List<ListaReporterItem> lista = managerDb.obtenerReportes();

        // Asignar el adapter con la lista desde SQLite
        ListaReportesAdapter adapter = new ListaReportesAdapter(this, lista);
        recyclerView.setAdapter(adapter);

        // Botón para crear nuevo reporte
        binding.imgButtonCrearreporte.setOnClickListener(v -> {
            startActivity(new Intent(ListaReportes.this, FormReportes.class));
        });
    }
}
