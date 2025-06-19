package com.example.sstdoble.controller;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import com.example.sstdoble.controller.ListaActividadesItem;


import com.example.sstdoble.R;
import com.example.sstdoble.model.ManagerDb;

public class CreaActividades extends AppCompatActivity {

    EditText etUsuario, etNombreActividad, etFecha, etDescripcion;
    Button btnEnviarEvidencia;
    Uri imagenUri = null;
    ManagerDb managerDb;

    private ActivityResultLauncher<Intent> pickImageLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crea_actividades);

        etUsuario = findViewById(R.id.etUsuario);
        etNombreActividad = findViewById(R.id.etNombreActividad);
        etFecha = findViewById(R.id.etFecha);
        etDescripcion = findViewById(R.id.etDescripcion);
        btnEnviarEvidencia = findViewById(R.id.btnEnviarEvidencia);

        managerDb = new ManagerDb(this);

        pickImageLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                        imagenUri = result.getData().getData();
                        Toast.makeText(this, "Evidencia seleccionada correctamente", Toast.LENGTH_SHORT).show();
                    }
                }
        );

        btnEnviarEvidencia.setOnClickListener(v -> {
            String usuario = etUsuario.getText().toString().trim();
            String nombreActividad = etNombreActividad.getText().toString().trim();
            String fecha = etFecha.getText().toString().trim();
            String descripcion = etDescripcion.getText().toString().trim();

            if (usuario.isEmpty() || nombreActividad.isEmpty() || fecha.isEmpty() || descripcion.isEmpty()) {
                Toast.makeText(this, "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show();
                return;
            }

            if (imagenUri == null) {
                Toast.makeText(this, "Debe seleccionar una imagen de evidencia", Toast.LENGTH_SHORT).show();
                return;
            }

            String urlImagen = imagenUri.toString();
            ListaActividadesItem actividad = new ListaActividadesItem(0, usuario, nombreActividad, fecha, descripcion, urlImagen);

            long resultado = managerDb.insertarActividad(actividad);

            if (resultado > 0) {
                Toast.makeText(this, "Actividad guardada correctamente", Toast.LENGTH_SHORT).show();
                limpiarCampos();
            } else {
                Toast.makeText(this, "Error al guardar la actividad", Toast.LENGTH_SHORT).show();
            }
        });

        btnEnviarEvidencia.setOnLongClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            pickImageLauncher.launch(intent);
            return true;
        });

        cargarDatosSiExisten();
    }

    private void limpiarCampos() {
        etUsuario.setText("");
        etNombreActividad.setText("");
        etFecha.setText("");
        etDescripcion.setText("");
        imagenUri = null;
    }

    private void cargarDatosSiExisten() {
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("nombreActividad")) {
            etUsuario.setText(intent.getStringExtra("usuario"));
            etNombreActividad.setText(intent.getStringExtra("nombreActividad"));
            etFecha.setText(intent.getStringExtra("fecha"));
            etDescripcion.setText(intent.getStringExtra("descripcion"));
            String urlImagen = intent.getStringExtra("evidencia");
            if (urlImagen != null) {
                imagenUri = Uri.parse(urlImagen);
            }
        }
    }
}
