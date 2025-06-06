package com.example.sstdoble;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {

    private static final String NOMBRE_BD = "Base.db";
    private static final int VERSION_BD = 1;

    public DbHelper(Context context){
        super(context, NOMBRE_BD, null, VERSION_BD);


    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table blog(id integer primary key autoincrement, titulo text, urlImagen text, descripcion text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS blog");
        onCreate(db);
    }
}
