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
import com.example.sstdoble.databinding.ActivityListaGestionBinding;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ListaGestion extends AppCompatActivity {

    ActivityListaGestionBinding binding;
    ListaGestionAdapter adapter;
    List<ListaGestionItem> listaGestion = new ArrayList<>();

    // 🔹 Ajusta esta URL a tu endpoint real
    String URL_API = "https://backsst.onrender.com/listarGestiones";

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

        // Configurar RecyclerView
        RecyclerView recyclerView = binding.recyclerViewListaGestion;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ListaGestionAdapter(this, listaGestion);
        recyclerView.setAdapter(adapter);

        // Llamar API
        obtenerGestiones();

        // Botón para crear nueva gestión

    }

    private void obtenerGestiones() {
        RequestQueue queue = Volley.newRequestQueue(this);

        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.GET,
                URL_API,
                null,
                response -> {
                    try {
                        JSONArray datos = response.getJSONArray("datos");

                        listaGestion.clear();
                        for (int i = 0; i < datos.length(); i++) {
                            JSONObject obj = datos.getJSONObject(i);

                            ListaGestionItem item = new ListaGestionItem(
                                    obj.getInt("idUsuario"),
                                    obj.getString("nombre"),
                                    obj.getString("apellido"),
                                    obj.getString("cedula"),
                                    obj.getString("cargo"),
                                    obj.getString("productos"),
                                    obj.getInt("cantidad"),
                                    obj.getString("importancia"),
                                    obj.optString("estado"),
                                    obj.getString("fechaCreacion")
                            );
                            listaGestion.add(item);
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
