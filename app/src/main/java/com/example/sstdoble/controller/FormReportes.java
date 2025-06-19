package com.example.sstdoble.controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sstdoble.databinding.ActivityFormReporteBinding;
import com.example.sstdoble.model.ManagerDb;


public class FormReportes extends AppCompatActivity {

    private ActivityFormReporteBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityFormReporteBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (guardarDatos()) {
                    startActivity(new Intent(FormReportes.this, com.example.sstdoble.controller.ListaReportes.class));
                    finish();
                }
            }
        });
    }

    private boolean guardarDatos() {
        String nombreUsuario = binding.etNombreUsuarioR.getText().toString().trim();
        String cargo = binding.etCargo.getText().toString().trim();
        String cedula = binding.etCedula.getText().toString().trim();
        String fecha = binding.etFecha.getText().toString().trim();
        String lugar = binding.etLugar.getText().toString().trim();
        String descripcion = binding.etDescripcion.getText().toString().trim();
        String imagen = binding.etImagen.getText().toString().trim();
        String archivos = binding.etArchivos.getText().toString().trim();
        String estado = binding.etEstado.getText().toString().trim();

        if (nombreUsuario.isEmpty() || cargo.isEmpty() || cedula.isEmpty() || fecha.isEmpty()
                || lugar.isEmpty() || descripcion.isEmpty() || estado.isEmpty()) {
            Toast.makeText(this, "Por favor completa todos los campos obligatorios.", Toast.LENGTH_LONG).show();
            return false;
        }

        // Crear el objeto Reporte
        com.example.sstdoble.controller.CrearListaReportes nuevoReporte = new com.example.sstdoble.controller.CrearListaReportes();
        nuevoReporte.setNombreUsuario(nombreUsuario);
        nuevoReporte.setCargo(cargo);
        nuevoReporte.setCedula(cedula);
        nuevoReporte.setFecha(fecha);
        nuevoReporte.setLugar(lugar);
        nuevoReporte.setDescripcion(descripcion);
        nuevoReporte.setImagen(imagen);
        nuevoReporte.setArchivos(archivos);


        // Guardar en la base de datos
        ManagerDb managerDb = new ManagerDb(this);
        long resultado = managerDb.insertarReporte(nuevoReporte);

        if (resultado > 0) {
            Toast.makeText(this, "Guardado exitosamente", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            Toast.makeText(this, "Error al guardar", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    private String getRadioValue(RadioButton rbSi, RadioButton rbNo) {
        if (rbSi.isChecked()) return "Sí";
        else if (rbNo.isChecked()) return "No";
        else return null;
    }
}
