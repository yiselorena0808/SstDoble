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
import com.example.sstdoble.databinding.ActivityListaChequeoBinding;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ListaChequeo extends AppCompatActivity {

    ActivityListaChequeoBinding binding;
    ListaChequeoAdapter adapter;
    List<ListaChequeoItem> listaChequeos = new ArrayList<>();

    String URL_API = "https://backsst.onrender.com/listarListasChequeo";

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
        adapter = new ListaChequeoAdapter(this, listaChequeos);
        recyclerView.setAdapter(adapter);

        // Llamar API
        obtenerListasChequeo();

        // Botón para crear nueva lista de chequeo
        binding.imgButtonCrear2.setOnClickListener(v -> {
            startActivity(new Intent(ListaChequeo.this, FormChequeo.class));
        });
    }

    private void obtenerListasChequeo() {
        RequestQueue queue = Volley.newRequestQueue(this);

        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.GET,
                URL_API,
                null,
                response -> {
                    try {
                        // Extraer el array "datos" del objeto JSON
                        JSONArray datos = response.getJSONArray("datos");

                        listaChequeos.clear();
                        for (int i = 0; i < datos.length(); i++) {
                            JSONObject obj = datos.getJSONObject(i);

                            ListaChequeoItem item = new ListaChequeoItem(
                                    obj.getString("usuarioNombre"),
                                    obj.getString("fecha"),
                                    obj.getString("hora"),
                                    obj.getString("modelo"),
                                    obj.getString("marca"),
                                    obj.getString("soat"),
                                    obj.getString("tecnico"),
                                    obj.getString("kilometraje")
                            );
                            listaChequeos.add(item);
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
