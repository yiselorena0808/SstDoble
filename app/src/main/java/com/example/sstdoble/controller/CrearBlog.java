package com.example.sstdoble.controller;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import com.example.sstdoble.R;
import com.example.sstdoble.model.ManagerDb;

public class CrearBlog extends AppCompatActivity {

    private EditText txtTitulo, txtDescripcion;
    private Button btnAgregarImagen, btnPublicar, btnRegresar;
    private Uri imagenUriSeleccionada;

    private final ActivityResultLauncher<String> seleccionImagenLauncher =
            registerForActivityResult(new ActivityResultContracts.GetContent(), uri -> {
                if (uri != null) {
                    imagenUriSeleccionada = uri;
                    btnAgregarImagen.setText("Imagen seleccionada");
                }
            });

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_blog);

        txtTitulo = findViewById(R.id.txttitu);
        txtDescripcion = findViewById(R.id.txtdesc);
        btnAgregarImagen = findViewById(R.id.btnAgregarImagen);
        btnPublicar = findViewById(R.id.btnPubli);
        btnRegresar = findViewById(R.id.btnRegreso);

        btnAgregarImagen.setOnClickListener(v -> seleccionImagenLauncher.launch("image/*"));
        btnRegresar.setOnClickListener(v -> finish());

        btnPublicar.setOnClickListener(v -> {
            String titulo = txtTitulo.getText().toString().trim();
            String descripcion = txtDescripcion.getText().toString().trim();

            if (titulo.isEmpty() || descripcion.isEmpty()) {
                Toast.makeText(this, "Título y descripción son obligatorios", Toast.LENGTH_SHORT).show();
                return;
            }

            ManagerDb db = new ManagerDb(this);
            PubliBlog publi = new PubliBlog(titulo, descripcion,
                    imagenUriSeleccionada != null ? imagenUriSeleccionada.toString() : null);
            long id = db.insertarPubli(publi);
            if (id > -1) {
                Toast.makeText(this, "Publicación guardada", Toast.LENGTH_SHORT).show();
                setResult(RESULT_OK);
                finish();
            } else {
                Toast.makeText(this, "Error al guardar", Toast.LENGTH_SHORT).show();
            }
        });
    }
}


