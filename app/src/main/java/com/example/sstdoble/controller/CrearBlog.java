package com.example.sstdoble.controller;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import com.example.sstdoble.R;
import com.example.sstdoble.model.ManagerDb;
import com.example.sstdoble.databinding.ActivityCrearBlogBinding;


public class CrearBlog extends AppCompatActivity {

    ActivityCrearBlogBinding binding;
    private ActivityResultLauncher<Intent> pickImageLauncher;

    private Uri imagenUri = null;
    private Intent data;

    ManagerDb managerDb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_crear_blog);

        binding = ActivityCrearBlogBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.btnRegreso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CrearBlog.this, Blog.class));
            }
        });

        binding.btnPubli.setOnClickListener(v -> {

            String titulo = binding.txttitu.getText().toString();
            String descripcion = binding.txtdesc.getText().toString();
            Uri imagenUri = data.getData();
            String urlImagen = imagenUri.toString();


            Intent intent = new Intent(CrearBlog.this, Blog.class);
            intent.putExtra("titulo", titulo);
            intent.putExtra("descripcion", descripcion);
            intent.putExtra("imagenUri", urlImagen);
            startActivity(intent);
            int id = 2;





            managerDb = new ManagerDb(CrearBlog.this);


            CrearBlogs blog = new CrearBlogs(id,titulo,descripcion,urlImagen);
            long resul = managerDb.insertarBlog(blog);

            if(resul > 0){
                Toast.makeText(CrearBlog.this, "DATOS INGRESADOS CORRECTAMENTE" + resul, Toast.LENGTH_SHORT).show();
                binding.txttitu.setText(" ");
                binding.txtdesc.setText(" ");
                binding.btnAgregarImagen.setText(" ");
            } else {
                Toast.makeText(CrearBlog.this, "DATOS NO INGRESADOS" + resul, Toast.LENGTH_SHORT).show();
            }
        });

        binding.btnAgregarImagen.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(intent, 100);
        });

        pickImageLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                        imagenUri = result.getData().getData();

                  
                        binding.btnAgregarImagen.setBackground(null);
                        binding.btnAgregarImagen.setText("");
                        binding.btnAgregarImagen.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
                        binding.btnAgregarImagen.setBackgroundResource(0);
                        binding.btnAgregarImagen.setCompoundDrawablePadding(0);
                        binding.btnAgregarImagen.setPadding(0, 0, 0, 0);
                    }
                }
        );



    }
}