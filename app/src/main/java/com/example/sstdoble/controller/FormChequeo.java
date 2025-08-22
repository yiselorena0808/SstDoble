package com.example.sstdoble.controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sstdoble.api.ApiClient;
import com.example.sstdoble.api.ApiResponse;
import com.example.sstdoble.api.ApiService;
import com.example.sstdoble.databinding.ActivityFormChequeoBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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

        if (nombreUsuario.isEmpty() || fecha.isEmpty() || hora.isEmpty() ||
                modelo.isEmpty() || marca.isEmpty() || kilometraje.isEmpty() ||
                soat == null || tecnico == null) {
            Toast.makeText(this, "Por favor completa todos los campos.", Toast.LENGTH_LONG).show();
            return;
        }

        // Crear objeto con los mismos campos que espera el backend
        // Crear objeto con los mismos campos que espera el backend
        CrearListaChequeo nuevaLista = new CrearListaChequeo();
        nuevaLista.setIdUsuario(14); // ejemplo, hasta que uses el login real
        nuevaLista.setUsuarioNombre(nombreUsuario);
        nuevaLista.setFecha(fecha);
        nuevaLista.setHora(hora);
        nuevaLista.setModelo(modelo);
        nuevaLista.setMarca(marca);
        nuevaLista.setKilometraje(kilometraje);
        nuevaLista.setSoat(soat);
        nuevaLista.setTecnico(tecnico);

        String token = "TOKEN_JWT_VALIDO";

        ApiService apiService = ApiClient.getClient(token).create(ApiService.class);

        // Ahora pedimos una respuesta JSON, no Void
        Call<ApiResponse<CrearListaChequeo>> call = apiService.crearListaChequeo(nuevaLista);

        call.enqueue(new Callback<ApiResponse<CrearListaChequeo>>() {
            @Override
            public void onResponse(Call<ApiResponse<CrearListaChequeo>> call, Response<ApiResponse<CrearListaChequeo>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    Toast.makeText(FormChequeo.this, "Guardado: " + response.body().getMsj(), Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(FormChequeo.this, ListaChequeo.class));
                }
            }

            @Override
            public void onFailure(Call<ApiResponse<CrearListaChequeo>> call, Throwable t) {
                Toast.makeText(FormChequeo.this, "Error de conexión: " + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    private String getRadioValue(RadioButton rbSi, RadioButton rbNo) {
        if (rbSi.isChecked()) return "Si";  // <- sin tilde
        else if (rbNo.isChecked()) return "No";
        else return null;
    }

}
