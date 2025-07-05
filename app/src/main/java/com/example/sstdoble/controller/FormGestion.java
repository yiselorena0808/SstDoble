package com.example.sstdoble.controller;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.sstdoble.databinding.ActivityFormGestionBinding;
import com.example.sstdoble.model.ManagerDb;

public class FormGestion extends AppCompatActivity {

    ActivityFormGestionBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFormGestionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnEnviarSolicitud.setOnClickListener(v -> {
            String nombre = binding.etNombre.getText().toString().trim();
            String apellido = binding.etApellido.getText().toString().trim();
            String cedula = binding.etCedula.getText().toString().trim();
            String cargo = binding.etCargo11.getText().toString().trim();
            String producto = binding.etLugar.getText().toString().trim();
            String cantidad = binding.etFecha.getText().toString().trim();

            // Obtener el texto del RadioButton seleccionado
            int selectedId = binding.radioGroup.getCheckedRadioButtonId();
            String importancia = "";
            if (selectedId != -1) {
                RadioButton selectedRadio = findViewById(selectedId);
                importancia = selectedRadio.getText().toString();
            }

            // Validación mínima
            if (nombre.isEmpty() || apellido.isEmpty()) {
                Toast.makeText(this, "Nombre y apellido son obligatorios", Toast.LENGTH_SHORT).show();
                return;
            }

            // Guardar en base de datos
            ManagerDb managerDb = new ManagerDb(this);
            CrearGestion gestion = new CrearGestion(nombre, apellido, cedula, cargo, producto, cantidad, importancia);
            long resultado = managerDb.insertarGestion(gestion); // ✅ Método corregido

            if (resultado != -1) {
                Toast.makeText(this, "Solicitud guardada exitosamente", Toast.LENGTH_SHORT).show();
                finish();
            } else {
                Toast.makeText(this, "Error al guardar la solicitud", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
