package com.example.sstdoble.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {

    public DbHelper(Context context) {
        super(context, Constantes.NOMBRE_BD, null, Constantes.VERSION_BD);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Constantes.CREAR_TABLA_LISTA_CHEQUEO);
        db.execSQL(Constantes.CREAR_TABLA_REPORTES);
        db.execSQL(Constantes.CREAR_TABLA_ACTIVIDADES);
        db.execSQL(Constantes.CREAR_TABLA_SOLICITUDES);
        db.execSQL(Constantes.CREAR_TABLA_BLOG);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Constantes.TABLA_LISTA_CHEQUEO);
        db.execSQL("DROP TABLE IF EXISTS " + Constantes.TABLA_REPORTES);
        db.execSQL("DROP TABLE IF EXISTS " + Constantes.TABLA_ACTIVIDADES);
        db.execSQL("DROP TABLE IF EXISTS " + Constantes.TABLA_SOLICITUDES);
        db.execSQL("DROP TABLE IF EXISTS " + Constantes.TABLA_BLOG);

        // 🔹 Vuelves a crear las tablas
        onCreate(db);
    }
}
