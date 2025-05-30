package com.example.sstdoble;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.example.sstdoble.databinding.ActivityListaAsesoramientoBinding;
import com.example.sstdoble.databinding.ActivityMenuBinding;

public class ListaAsesoramiento extends AppCompatActivity {

    ActivityListaAsesoramientoBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_lista_asesoramiento);

        binding = ActivityListaAsesoramientoBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.item1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ListaAsesoramiento.this, CreaAsesoramiento.class));
            }
        });


    }
}