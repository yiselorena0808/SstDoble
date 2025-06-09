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
        String query = "CREATE TABLE " + Constantes.gestiones_epp + " (" +
                Constantes.C_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                Constantes.C_NOMBRE + " TEXT, " +
                Constantes.C_APELLIDO + " TEXT, " +
                Constantes.C_CEDULA + " TEXT, " +
                Constantes.C_CARGO + " TEXT, " +
                Constantes.C_PRODUCTO + " TEXT, " +
                Constantes.C_CANTIDAD + " TEXT, " +
                Constantes.C_IMPORTANCIA + " TEXT)";
        sqLiteDatabase.execSQL(query);

}

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS blog");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Constantes.gestiones_epp);
        onCreate(sqLiteDatabase);
    }
}
