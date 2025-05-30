package com.example.sstdoble;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.sstdoble.databinding.ActivityCrearBlogBinding;


public class CrearBlog extends AppCompatActivity {

    private ActivityResultLauncher<Intent> pickImageLauncher;
    ActivityCrearBlogBinding binding;

    private Uri imagenUri = null;
    private Intent data;


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

            Intent intent = new Intent(CrearBlog.this, Blog.class);
            intent.putExtra("titulo", titulo);
            intent.putExtra("descripcion", descripcion);
            intent.putExtra("imagenUri", imagenUri.toString());
            startActivity(intent);
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