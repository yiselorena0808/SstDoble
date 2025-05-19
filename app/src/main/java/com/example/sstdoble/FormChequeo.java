package com.example.sstdoble;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.sstdoble.databinding.ActivityFormChequeoBinding;
import com.example.sstdoble.databinding.ActivityMenuBinding;

public class FormChequeo extends AppCompatActivity {

    ActivityFormChequeoBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_form_chequeo);

        binding = ActivityFormChequeoBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.btnChequeo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FormChequeo.this, ListaChequeo.class));
            }
        });

    }
}