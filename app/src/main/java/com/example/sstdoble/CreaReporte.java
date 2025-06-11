package com.example.sstdoble;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sstdoble.databinding.ActivityCreaReporteBinding;

import java.util.ArrayList;
import java.util.List;

public class CreaReporte extends AppCompatActivity {

    ActivityCreaReporteBinding binding;

    private RecyclerView recyclerView;
    private PubliAdapter adapter;
    private List<PubliBlog> publicaciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Inflate con ViewBinding
        binding = ActivityCreaReporteBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        // Configuración del RecyclerView
        recyclerView = binding.reciclereportes; // Asegúrate de tener este ID en tu XML
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        publicaciones = new ArrayList<>();

        // Obtener datos del Intent (si vienen)
        Intent intent = getIntent();
        String titulo = intent.getStringExtra("titulo");
        String descripcion = intent.getStringExtra("descripcion");
        String imagenUri = intent.getStringExtra("imagenUri");

        if (titulo != null && descripcion != null) {
            publicaciones.add(new PubliBlog(titulo, descripcion, imagenUri));
        }

        adapter = new PubliAdapter(publicaciones);
        recyclerView.setAdapter(adapter);

        // Acción del botón "Regresar"
        binding.btnregresarGestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CreaReporte.this, ListaReportes.class));
            }
        });
    }
}
