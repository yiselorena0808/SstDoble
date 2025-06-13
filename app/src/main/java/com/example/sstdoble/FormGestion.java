package com.example.sstdoble;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sstdoble.controlador.CrearGestion;
import com.example.sstdoble.controlador.ManagerDb;
import com.example.sstdoble.databinding.ActivityFormGestionBinding;

public class FormGestion extends AppCompatActivity {

    EditText etNombre, etApellido;
    ActivityFormGestionBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        etNombre = findViewById(R.id.et_nombre);
        etApellido = findViewById(R.id.et_apellido);

        binding = ActivityFormGestionBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.btnEnviarSolicitud.setOnClickListener(v -> {
            String nombre = binding.etNombre.getText().toString();
            String apellido = binding.etApellido.getText().toString();
            String cedula = binding.etCedula.getText().toString();
            String cargo = binding.etCargo11.getText().toString();
            String producto = binding.etLugar.getText().toString();
            String cantidad = binding.etFecha.getText().toString();

            String importancia = "";
            int selectedId = binding.getRoot().findViewById(binding.getRoot().getId()).findViewById(R.id.radioGroup).getId();
            RadioButton radioButton = findViewById(binding.radioGroup.getCheckedRadioButtonId());

            if (radioButton != null) {
                importancia = radioButton.getText().toString();
            }

            // Guardar en base de datos
            ManagerDb managerDB = new ManagerDb(this);

            CrearGestion gestion = new CrearGestion(nombre, apellido, cedula, cargo, producto, cantidad, importancia);
            long resultado = managerDB.insertarSolicitud(gestion);

            if (resultado != -1) {
                Toast.makeText(this, "Solicitud guardada", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Error al guardar", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
