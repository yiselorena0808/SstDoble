package com.example.sstdoble.controlador;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.sstdoble.CrearBlog;

public class ManagerDb {

    DbHelper bdHelper;
    SQLiteDatabase db;

    public ManagerDb(Context context) {
        bdHelper = new DbHelper(context);
    }

    public void openDNWRITE() {
        db = bdHelper.getWritableDatabase();
    }

    public void openDbRd() {
        db = bdHelper.getReadableDatabase();
    }

    public long insertarBlog(com.example.sstdoble.controlador.CrearBlogs blog){
        openDNWRITE();

        ContentValues values = new ContentValues();

        values.put("id", 1);
        values.put("titulo",blog.getTitulo());
        values.put("descripcion",blog.getDesc());
        values.put("urlImagen",blog.getUrlImg());

        long resul = db.insert("Blog", null,values);
        return resul;
    }

    public long insertarReporte(CrearReportes reporte) {
        openDNWRITE();

        ContentValues values = new ContentValues();
        values.put("nombreUsuario", reporte.getNombreUsuario());
        values.put("cargoUsuario", reporte.getCargo());
        values.put("cedula", reporte.getCedula());
        values.put("fecha", reporte.getFecha());
        values.put("lugar", reporte.getLugar());
        values.put("descripcion", reporte.getDescripcion());
        values.put("rutaImagen", reporte.getImagen());
        values.put("rutaArchivos", reporte.getArchivos());
        values.put("estado", reporte.getEstado());

        long resul = db.insert("Reporte", null, values);
        return resul;
    }
    public long insertarActividad(CrearActividades actividad) {
        openDNWRITE();

        ContentValues values = new ContentValues();
        values.put("usuario", actividad.getNombreUsuario());
        values.put("nombre_actividad", actividad.getNombreActividad());
        values.put("fecha", actividad.getFechaActividad());
        values.put("descripcion", actividad.getDescripcion());
        values.put("imagen_uri", actividad.getUrlEvidencia());

        return db.insert("Actividades", null, values);
    }

}

