package com.example.sstdoble;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sstdoble.databinding.ActivityListaReportesBinding;

import java.util.ArrayList;
import java.util.List;

public class ListaReportes extends AppCompatActivity {

    ActivityListaReportesBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Inflar el layout con ViewBinding
        binding = ActivityListaReportesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Aplicar márgenes para las barras del sistema (status bar, navegación)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main, (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Configurar RecyclerView
        RecyclerView recyclerView = binding.recyclerViewListaReportes;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Datos de prueba
        List<ListaReporterItem> lista = new ArrayList<>();
        lista.add(new ListaReporterItem("Juan Pérez", "2025-05-19"));
        lista.add(new ListaReporterItem("Ana Torres", "2025-05-18"));

        // Asignar adaptador
        ListaReportesAdapter adapter = new ListaReportesAdapter(this, lista);
        recyclerView.setAdapter(adapter);

        // Botón para crear nuevo reporte
        binding.imgButtonCrear.setOnClickListener(v -> {
            startActivity(new Intent(ListaReportes.this, CreaReporte.class));
        });
    }
}
