package com.example.sstdoble.controlador;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.sstdoble.CrearBlog;

public class ManagerDb {

    DbHelper bdHelper;

    SQLiteDatabase db;

    public ManagerDb(Context context){
        bdHelper=new DbHelper(context);
    }

    public void openDNWRITE() {db = bdHelper.getWritableDatabase();}
    public void openDbRd(){db= bdHelper.getReadableDatabase();}

    public long insertarBlog(CrearBlog blog){
        openDNWRITE();

        ContentValues values = new ContentValues();

        values.put("titulo",blog.getTitulo());
        values.put("descripcion",blog.getDesc());
        values.put("imagen",blog.getUrlImg());

        long resul = db.insert("Blog", null,values);
        return resul;
    }


}
