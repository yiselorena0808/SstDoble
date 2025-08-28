package com.example.sstdoble.controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sstdoble.api.ApiClient;
import com.example.sstdoble.api.ApiResponse;
import com.example.sstdoble.api.ApiService;
import com.example.sstdoble.databinding.ActivityFormReporteBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FormReportes extends AppCompatActivity {

    private ActivityFormReporteBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Inflar el layout con ViewBinding
        binding = ActivityFormReporteBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Acción al hacer clic en el botón Guardar
        binding.btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guardarDatos();
            }
        });
    }

    private void guardarDatos() {
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
                fecha.isEmpty() || lugar.isEmpty() || descripcion.isEmpty() || estado.isEmpty()) {
            Toast.makeText(this, "Por favor completa todos los campos.", Toast.LENGTH_LONG).show();
            return;
        }

        // Crear objeto con los mismos campos que espera el backend
        CrearReportes nuevoReporte = new CrearReportes();
        nuevoReporte.setId(14); // <-- igual que en FormChequeo, id manual
        nuevoReporte.setNombreUsuario(nombreUsuario);
        nuevoReporte.setCargo(cargo);
        nuevoReporte.setCedula(cedula);
        nuevoReporte.setFecha(fecha);
        nuevoReporte.setLugar(lugar);
        nuevoReporte.setDescripcion(descripcion);
        nuevoReporte.setImagen(imagen);
        nuevoReporte.setArchivos(archivos);
        nuevoReporte.setEstado(estado);

        String token = "TOKEN_JWT_VALIDO";

        ApiService apiService = ApiClient.getClient(token).create(ApiService.class);

        // Ahora pedimos una respuesta JSON, no Void
        Call<ApiResponse<CrearReportes>> call = apiService.crearReporte(nuevoReporte);

        call.enqueue(new Callback<ApiResponse<CrearReportes>>() {
            @Override
            public void onResponse(Call<ApiResponse<CrearReportes>> call, Response<ApiResponse<CrearReportes>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    Toast.makeText(FormReportes.this, "Guardado: " + response.body().getMsj(), Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(FormReportes.this, ListaReportes.class));
                }
            }

            @Override
            public void onFailure(Call<ApiResponse<CrearReportes>> call, Throwable t) {
                Toast.makeText(FormReportes.this, "Error de conexión: " + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
