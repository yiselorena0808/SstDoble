package com.example.sstdoble;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.sstdoble.databinding.ActivityListaActividadesBinding;
import com.example.sstdoble.databinding.ActivityMenuBinding;

public class ListaActividades extends AppCompatActivity {

    ActivityListaActividadesBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_lista_actividades);

        binding = ActivityListaActividadesBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.btncrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ListaActividades.this, CreaActividades.class));
            }
        });

    }
}