package com.example.sstdoble;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sstdoble.databinding.ActivityFormChequeoBinding;

public class FormChequeo extends AppCompatActivity {

    private ActivityFormChequeoBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Inflar el layout con ViewBinding
        binding = ActivityFormChequeoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Ir a Lista de Chequeo
        binding.btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FormChequeo.this, ListaChequeo.class));
            }
        });

        // Guardar los datos del formulario
        binding.btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guardarDatos();
            }
        });
    }

    private void guardarDatos() {
        String nombreUsuario = binding.etUsuarioNombre.getText().toString().trim();
        String fecha = binding.etFecha.getText().toString().trim();
        String hora = binding.etHora.getText().toString().trim();
        String modelo = binding.etModelo.getText().toString().trim();
        String marca = binding.etMarca.getText().toString().trim();
        String kilometraje = binding.etKilometraje.getText().toString().trim();

        String soat = getRadioValue(binding.rbSoatSi, binding.rbSoatNo);
        String tecnico = getRadioValue(binding.rbTecnicoSi, binding.rbTecnicoNo);

        // Validación
        if (nombreUsuario.isEmpty() || fecha.isEmpty() || hora.isEmpty() ||
                modelo.isEmpty() || marca.isEmpty() || kilometraje.isEmpty() ||
                soat == null || tecnico == null) {
            Toast.makeText(this, "Por favor completa todos los campos.", Toast.LENGTH_LONG).show();
            return;
        }

        // Mostrar los datos
        String resumen = "Nombre: " + nombreUsuario + "\n" +
                "Fecha: " + fecha + "\n" +
                "Hora: " + hora + "\n" +
                "Modelo: " + modelo + "\n" +
                "Marca: " + marca + "\n" +
                "SOAT: " + soat + "\n" +
                "Técnico: " + tecnico + "\n" +
                "Kilometraje: " + kilometraje;

        Toast.makeText(this, "Datos guardados:\n" + resumen, Toast.LENGTH_LONG).show();
    }

    private String getRadioValue(RadioButton rbSi, RadioButton rbNo) {
        if (rbSi.isChecked()) return "Sí";
        else if (rbNo.isChecked()) return "No";
        else return null;
    }
}
