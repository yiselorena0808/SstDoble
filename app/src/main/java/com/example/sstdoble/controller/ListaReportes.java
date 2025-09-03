package com.example.sstdoble.controller;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.sstdoble.databinding.ActivityListaReportesBinding;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ListaReportes extends AppCompatActivity {

    ActivityListaReportesBinding binding;
    ListaReportesAdapter adapter;
    List<ListaReporterItem> listaReportes = new ArrayList<>();

    // URL de la API en producción
    String URL_API = "https://backsst.onrender.com/listarReportes";

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
        adapter = new ListaReportesAdapter(this, listaReportes);
        recyclerView.setAdapter(adapter);

        // Botón para crear nuevo reporte
        binding.imgButtonCrearreporte.setOnClickListener(v -> {
            startActivity(new Intent(ListaReportes.this, FormReportes.class));
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        obtenerReportes(); // cada vez que vuelve la activity, se actualiza la lista
    }

    private void obtenerReportes() {
        RequestQueue queue = Volley.newRequestQueue(this);

        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.GET,
                URL_API,
                null,
                response -> {
                    try {
                        JSONArray datos = response.getJSONArray("datos");

                        listaReportes.clear();
                        for (int i = 0; i < datos.length(); i++) {
                            JSONObject obj = datos.getJSONObject(i);

                            ListaReporterItem item = new ListaReporterItem(
                                    obj.optInt("id", -1),  // usa optInt para evitar crash si no hay id
                                    obj.optString("nombre_usuario", ""),
                                    obj.optString("cargo", ""),
                                    obj.optString("cedula", ""),
                                    obj.optString("fecha", ""),
                                    obj.optString("lugar", ""),
                                    obj.optString("descripcion", ""),
                                    obj.optString("imagen", ""),   // puede venir null
                                    obj.optString("archivos", ""), // puede venir null
                                    obj.optString("estado", "")
                            );
                            listaReportes.add(item);
                        }
                        adapter.notifyDataSetChanged();

                    } catch (Exception e) {
                        Toast.makeText(this, "Error parseando datos: " + e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                },
                error -> Toast.makeText(this, "Error API: " + error.getMessage(), Toast.LENGTH_LONG).show()
        );

        queue.add(request);
    }
}
