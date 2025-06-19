package com.example.sstdoble.controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sstdoble.databinding.ActivityFormChequeoBinding;
import com.example.sstdoble.model.ManagerDb;


public class FormChequeo extends AppCompatActivity {

    private ActivityFormChequeoBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Inflar el layout con ViewBinding
        binding = ActivityFormChequeoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Acción al hacer clic en el botón Guardar
        binding.btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (guardarDatos()) {
                    // Si los datos son válidos, ir a la siguiente pantalla
                    startActivity(new Intent(FormChequeo.this, ListaChequeo.class));
                }
            }
        });
    }

    private boolean guardarDatos() {
        String nombreUsuario = binding.etUsuarioNombre.getText().toString().trim();
        String fecha = binding.etFecha.getText().toString().trim();
        String hora = binding.etHora.getText().toString().trim();
        String modelo = binding.etModelo.getText().toString().trim();
        String marca = binding.etMarca.getText().toString().trim();
        String kilometraje = binding.etKilometraje.getText().toString().trim();

        String soat = getRadioValue(binding.rbSoatSi, binding.rbSoatNo);
        String tecnico = getRadioValue(binding.rbTecnicoSi, binding.rbTecnicoNo);

        if (nombreUsuario.isEmpty() || fecha.isEmpty() || hora.isEmpty() ||
                modelo.isEmpty() || marca.isEmpty() || kilometraje.isEmpty() ||
                soat == null || tecnico == null) {
            Toast.makeText(this, "Por favor completa todos los campos.", Toast.LENGTH_LONG).show();
            return false;
        }

        // Crear el objeto
        CrearListaChequeo nuevaLista = new CrearListaChequeo();
        nuevaLista.setUsuarioNombre(nombreUsuario);
        nuevaLista.setFecha(fecha);
        nuevaLista.setHora(hora);
        nuevaLista.setModelo(modelo);
        nuevaLista.setMarca(marca);
        nuevaLista.setKilometraje(kilometraje);
        nuevaLista.setSoat(soat);
        nuevaLista.setTecnico(tecnico);

        // Guardar en la base de datos
        ManagerDb managerDb = new ManagerDb(this);
        long resultado = managerDb.insertarListaChequeo(nuevaLista);

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
