package com.example.sstdoble.controller;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sstdoble.R;
import com.example.sstdoble.databinding.ActivityBlogBinding;
import com.example.sstdoble.model.ManagerDb;
import java.util.List;

public class Blog extends AppCompatActivity {

    private ActivityBlogBinding binding;
    private RecyclerView recyclerView;
    private PubliAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBlogBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        recyclerView = findViewById(R.id.recyclerPublicaciones);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Configura el botón para crear una nueva publicación
        binding.btnCrear1.setOnClickListener(v ->
                startActivityForResult(new Intent(this, CrearBlog.class), 100));

        // Cargar publicaciones
        loadPublis();
    }

    private void loadPublis() {
        List<com.example.sstdoble.controller.PubliBlog> list = new ManagerDb(this).obtenerSolicitudes(gestion);
        adapter = new PubliAdapter(list);
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onActivityResult(int req, int res, @Nullable Intent data) {
        super.onActivityResult(req, res, data);
        if (req == 100 && res == RESULT_OK) loadPublis();
    }
}
