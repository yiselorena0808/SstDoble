package com.example.sstdoble.controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sstdoble.R;
import com.example.sstdoble.databinding.ActivityBlogBinding;

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
        setContentView(binding.getRoot());


        binding.recyclerPublicaciones1.setLayoutManager(new LinearLayoutManager(this));

        binding = ActivityBlogBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.btnCrear1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Blog.this, CrearBlog.class));
            }
        });



            recyclerView = findViewById(R.id.recyclerPublicaciones1);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

            publicaciones = new ArrayList<>();


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
