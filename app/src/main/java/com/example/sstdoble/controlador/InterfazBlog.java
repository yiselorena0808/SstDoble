package com.example.sstdoble.controlador;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.sstdoble.CrearBlog;
import com.example.sstdoble.R;

public class InterfazBlog extends AppCompatActivity {

    EditText txttitu,txtdesc;

    Button btnAgregarImagen, btnGuardar;

    ManagerDb managerDb;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_crear_blog);

        txttitu = findViewById(R.id.txttitu);
        txtdesc = findViewById(R.id.txtdesc);
        btnAgregarImagen = findViewById(R.id.btnAgregarImagen);
        btnGuardar = findViewById(R.id.btnPubli);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String titulo = txttitu.getText().toString();
                String descrip = txtdesc.getText().toString();
                String urlimg = btnAgregarImagen.toString();



                managerDb = new ManagerDb(InterfazBlog.this);


                CrearBlog blog = new CrearBlog(titulo,descrip,urlimg);
                long resul = managerDb.insertarBlog(blog);

                if(resul > 0){
                    Toast.makeText(InterfazBlog.this, "DATOS INGRESADOS CORRECTAMENTE" + resul, Toast.LENGTH_SHORT).show();
                    txttitu.setText(" ");
                    txtdesc.setText(" ");
                    btnAgregarImagen.setText(" ");
                } else {
                    Toast.makeText(InterfazBlog.this, "DATOS NO INGRESADOS" + resul, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
