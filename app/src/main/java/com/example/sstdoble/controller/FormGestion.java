package com.example.sstdoble.controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sstdoble.api.ApiClient;
import com.example.sstdoble.api.ApiResponse;
import com.example.sstdoble.api.ApiService;
import com.example.sstdoble.databinding.ActivityFormGestionBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FormGestion extends AppCompatActivity {

    private ActivityFormGestionBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFormGestionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnGuardarGestion.setOnClickListener(v -> guardarGestion());
    }

    private void guardarGestion() {
        // Obtener valores de los EditText
        String nombre = binding.etNombre.getText().toString().trim();
        String apellido = binding.etApellido.getText().toString().trim();
        String cedula = binding.etCedula.getText().toString().trim();
        String cargo = binding.etCargo.getText().toString().trim();
        String productos = binding.etProductos.getText().toString().trim();
        String cantidad = binding.etCantidad.getText().toString().trim();
        String estado = binding.etEstado.getText().toString().trim();
        String fechaCreacion = binding.etFechaCreacion.getText().toString().trim();

        // Obtener valor del RadioGroup de importancia
        RadioGroup importanciaGroup = binding.rgImportancia;
        int selectedId = importanciaGroup.getCheckedRadioButtonId();
        String importanciaSeleccionada = "";

        if (selectedId != -1) {
            RadioButton selectedRadio = findViewById(selectedId);
            importanciaSeleccionada = selectedRadio.getText().toString();
        }

        // Validaciones adicionales
        if (nombre.isEmpty() || apellido.isEmpty() || cedula.isEmpty() ||
                cargo.isEmpty() || productos.isEmpty() || cantidad.isEmpty() ||
                importanciaSeleccionada.isEmpty() || estado.isEmpty() || fechaCreacion.isEmpty()) {

            Toast.makeText(this, "Por favor completa todos los campos.", Toast.LENGTH_LONG).show();
            return;
        }

        if (!cedula.matches("\\d+")) {
            Toast.makeText(this, "La cédula solo debe contener números.", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!cantidad.matches("\\d+")) {
            Toast.makeText(this, "La cantidad debe ser numérica.", Toast.LENGTH_SHORT).show();
            return;
        }

        // Crear objeto de gestión
        CrearGestion nuevaGestion = new CrearGestion();
        nuevaGestion.setIdUsuario(1); // Temporal, se debe reemplazar con el ID real del usuario
        nuevaGestion.setNombre(nombre);
        nuevaGestion.setApellido(apellido);
        nuevaGestion.setCedula(cedula);
        nuevaGestion.setCargo(cargo);
        nuevaGestion.setProductos(productos);
        nuevaGestion.setCantidad(cantidad);
        nuevaGestion.setImportancia(importanciaSeleccionada);
        nuevaGestion.setEstado(estado);
        nuevaGestion.setFechaCreacion(fechaCreacion);

        // Token (debería obtenerse dinámicamente, no hardcodear)
        String token = "TOKEN_JWT_VALIDO";

        ApiService apiService = ApiClient.getClient(token).create(ApiService.class);
        Call<ApiResponse<CrearGestion>> call = apiService.crearGestion(nuevaGestion);

        call.enqueue(new Callback<ApiResponse<CrearGestion>>() {
            @Override
            public void onResponse(Call<ApiResponse<CrearGestion>> call, Response<ApiResponse<CrearGestion>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    Toast.makeText(FormGestion.this, "Guardado: " + response.body().getMsj(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(FormGestion.this, ListaGestion.class);
                    startActivity(intent);
                    finish(); // Evita regresar al formulario vacío
                } else {
                    Toast.makeText(FormGestion.this, "Error al guardar la gestión.", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<ApiResponse<CrearGestion>> call, Throwable t) {
                Toast.makeText(FormGestion.this, "Error de conexión: " + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
