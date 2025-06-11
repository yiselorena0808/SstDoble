package com.example.sstdoble.controlador;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {



    public DbHelper(@Nullable Context context){
        super(context, Constantes.NOMBRE_BD, null, Constantes.VERSION_BD);

    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(Constantes.BLOG);
        sqLiteDatabase.execSQL(Constantes.ACTIVIDADES_LUDICAS);




}

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS blog");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS lista_chequeo");
        sqLiteDatabase.execSQL(Constantes.ACTIVIDADES_LUDICAS);

        onCreate(sqLiteDatabase);
    }
}
