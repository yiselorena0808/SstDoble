package com.example.sstdoble;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sstdoble.databinding.ActivityListaActividadesBinding;
import com.example.sstdoble.databinding.ActivityListaChequeoBinding;

import java.util.ArrayList;
import java.util.List;

public class ListaActividades extends AppCompatActivity {

    ActivityListaActividadesBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityListaActividadesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ViewCompat.setOnApplyWindowInsetsListener(binding.main, (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Configurar RecyclerView
        RecyclerView recyclerView = binding.recyclerViewListaActividades;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<ListaActividadesItem> lista = new ArrayList<>();
        lista.add(new ListaActividadesItem("Juan Pérez", "2025-05-19"));
        lista.add(new ListaActividadesItem("Ana Torres", "2025-05-18"));

        ListaActividadesAdapter adapter = new ListaActividadesAdapter(this, lista);
        recyclerView.setAdapter(adapter);

        // Botón para crear nueva lista de chequeo
        binding.btncrear.setOnClickListener(v -> {
            startActivity(new Intent(ListaActividades.this, CreaActividades.class));
        });
    }
}