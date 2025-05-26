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

import com.example.sstdoble.databinding.ActivityBlogBinding;
import com.example.sstdoble.databinding.ActivityMenuBinding;

import java.util.ArrayList;
import java.util.List;


public class Blog extends AppCompatActivity {

    ActivityBlogBinding binding;

    private RecyclerView recyclerView;
    private PubliAdapter adapter;
    private List<PubliBlog> publicaciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_blog);

        binding = ActivityBlogBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.btnCrear1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Blog.this, CrearBlog.class));
            }
        });

            setContentView(R.layout.activity_blog);

            recyclerView = findViewById(R.id.recyclerPublicaciones1);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

            publicaciones = new ArrayList<>();

            // Puedes recibir datos por intent desde CrearBlog
            Intent intent = getIntent();
            String titulo = intent.getStringExtra("titulo");
            String descripcion = intent.getStringExtra("descripcion");
            String imagenUri = intent.getStringExtra("imagenUri");

            if (titulo != null && descripcion != null) {
                publicaciones.add(new PubliBlog(titulo, descripcion, imagenUri));
            }

            adapter = new PubliAdapter(publicaciones);
            recyclerView.setAdapter(adapter);
        }
    }
