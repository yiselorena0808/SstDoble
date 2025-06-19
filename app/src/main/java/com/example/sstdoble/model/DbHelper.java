package com.example.sstdoble.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {

    public DbHelper(@Nullable Context context) {
        super(context, Constantes.NOMBRE_BD, null, Constantes.VERSION_BD);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Crear tablas
        db.execSQL(Constantes.CREAR_TABLA_REPORTES);         // Tabla de reportes (reportessebastian)
        db.execSQL(Constantes.CREAR_TABLA_LISTA_CHEQUEO);    // Tabla lista_chequeo (sstdoble)
        db.execSQL(Constantes.CREAR_TABLA_ACTIVIDADES);
        // Si agregas más tablas, añádelas aquí:
        // db.execSQL(Constantes.OTRA_TABLA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Eliminar tablas existentes
        db.execSQL("DROP TABLE IF EXISTS " + Constantes.TABLA_REPORTES);
        db.execSQL("DROP TABLE IF EXISTS " + Constantes.TABLA_LISTA_CHEQUEO);
        db.execSQL("DROP TABLE IF EXISTS " + Constantes.TABLA_ACTIVIDADES);
        // Agrega más DROP si tienes más tablas:
        // db.execSQL("DROP TABLE IF EXISTS otra_tabla");

        // Recrear estructura
        onCreate(db);
    }
}
