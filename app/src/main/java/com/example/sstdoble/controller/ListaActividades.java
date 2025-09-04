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
import com.example.sstdoble.databinding.ActivityListaActividadesBinding;
import com.example.sstdoble.model.ManagerDb;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ListaActividades extends AppCompatActivity {

    ActivityListaActividadesBinding binding;
    List<ListaActividadesItem> listaActividades = new ArrayList<>();
    ListaActividadesAdapter adapter;
    String URL_API = "https://backsst.onrender.com/listarActividadesLudicas";
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

        // Asignar el adapter con la lista desde SQLite
        adapter = new ListaActividadesAdapter(this, listaActividades);
        recyclerView.setAdapter(adapter);

        // Botón para crear nueva actividad
        binding.btncrear.setOnClickListener(v -> {
            startActivity(new Intent(ListaActividades.this, CreaActividades.class));
        });
    }

    private void obtenerActividades(){
        RequestQueue queue = Volley.newRequestQueue(this);
        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.GET,
                URL_API,
                null,
                response -> {
                    try {
                        // Extraer el array "datos" del objeto JSON
                        JSONArray datos = response.getJSONArray("datos");

                        listaActividades.clear();
                        for (int i = 0; i < datos.length(); i++) {
                            JSONObject obj = datos.getJSONObject(i);

                            ListaActividadesItem item = new ListaActividadesItem(
                                    obj.getInt("id"),
                                    obj.getString("nombreUsuario"),
                                    obj.getString("nombreActividad"),
                                    obj.getString("fechaActividad"),
                                    obj.getString("descripcion"),
                                    obj.getString("archivoAdjunto"),
                                    obj.getString("imagenVideo")
                            );
                            listaActividades.add(item);
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
