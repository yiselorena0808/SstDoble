// FormReportes.java
package com.example.sstdoble.controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.sstdoble.api.ApiClient;
import com.example.sstdoble.api.ApiResponse;
import com.example.sstdoble.api.ApiService;
import com.example.sstdoble.databinding.ActivityFormReporteBinding;
import com.example.sstdoble.model.ManagerDb;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FormReportes extends AppCompatActivity {

    private ActivityFormReporteBinding binding;
    private ManagerDb managerDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFormReporteBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        managerDb = new ManagerDb(this);

        binding.btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guardarDatos();
            }
        });
    }

    private void guardarDatos() {
        // ID (opcional)
        Integer id = null;
        String idText = binding.etId.getText().toString().trim();
        if (!idText.isEmpty()) {
            try {
                id = Integer.parseInt(idText);
            } catch (NumberFormatException e) {
                Toast.makeText(this, "El ID debe ser numérico.", Toast.LENGTH_LONG).show();
                return;
            }
        }

        String nombreUsuario = binding.etNombreUsuarioR.getText().toString().trim();
        String cargo = binding.etCargo.getText().toString().trim();
        String cedula = binding.etCedula.getText().toString().trim();
        String fecha = binding.etFecha.getText().toString().trim();
        String lugar = binding.etLugar.getText().toString().trim();
        String descripcion = binding.etDescripcion.getText().toString().trim();
        String imagen = binding.etImagen.getText().toString().trim();
        String archivos = binding.etArchivos.getText().toString().trim();
        String estado = binding.etEstado.getText().toString().trim();

        if (nombreUsuario.isEmpty() || cargo.isEmpty() || cedula.isEmpty() ||
                fecha.isEmpty() || lugar.isEmpty() || descripcion.isEmpty() ||
                imagen.isEmpty() || archivos.isEmpty() || estado.isEmpty()) {
            Toast.makeText(this, "Por favor completa todos los campos.", Toast.LENGTH_LONG).show();
            return;
        }

        // Armar objeto
        CrearReportes nuevoReporte = new CrearReportes();
        nuevoReporte.setIdUsuario(5);
        nuevoReporte.setNombreUsuario(nombreUsuario);
        nuevoReporte.setCargo(cargo);
        nuevoReporte.setCedula(cedula);
        nuevoReporte.setFecha(fecha);
        nuevoReporte.setLugar(lugar);
        nuevoReporte.setDescripcion(descripcion);
        nuevoReporte.setImagen(imagen);
        nuevoReporte.setArchivos(archivos);
        nuevoReporte.setEstado(estado);

        // 1) Guardar en SQLite local (autoincrementa si no pasamos id)
        long rowId = managerDb.insertarReporte(nuevoReporte);
        if (rowId <= 0) {
            Toast.makeText(this, "No se pudo guardar localmente.", Toast.LENGTH_LONG).show();
            return;
        }

        // Si no vino id, usar el autogenerado y mostrarlo
        if (id == null) {
            binding.etId.setText(String.valueOf(rowId));
            nuevoReporte.setIdUsuario((int) rowId);
        }

        // 2) Enviar al backend
        String token = "TOKEN_JWT_VALIDO"; // reemplázalo por el de tu login
        ApiService apiService = ApiClient.getClient(token).create(ApiService.class);

        Call<ApiResponse<CrearReportes>> call = apiService.crearReporte(nuevoReporte);
        call.enqueue(new Callback<ApiResponse<CrearReportes>>() {
            @Override
            public void onResponse(@NonNull Call<ApiResponse<CrearReportes>> call,
                                   @NonNull Response<ApiResponse<CrearReportes>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    Toast.makeText(FormReportes.this,
                            "Guardado en servidor: " + response.body().getMsj(),
                            Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(FormReportes.this, ListaReportes.class));
                } else {
                    Toast.makeText(FormReportes.this,
                            "Error del servidor: " + response.code(),
                            Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<ApiResponse<CrearReportes>> call, @NonNull Throwable t) {
                Toast.makeText(FormReportes.this,
                        "Error de conexión: " + t.getMessage(),
                        Toast.LENGTH_LONG).show();
            }
        });
    }
}
