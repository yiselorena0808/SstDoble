package com.example.sstdoble;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Olvidaste_contrasenia extends AppCompatActivity {
    EditText editCorreoRe;
    Button btnOlvidaste;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_olvidaste_contrasenia);
        editCorreoRe= findViewById(R.id.edtCorreoRe);
        btnOlvidaste= findViewById(R.id.btnOlvido);



    }
}