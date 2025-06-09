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

    public long insertarBlog(CrearBlogs blog){
        openDNWRITE();

        ContentValues values = new ContentValues();

        values.put("id", 2);
        values.put("titulo",blog.getTitulo());
        values.put("descripcion",blog.getDesc());
        values.put("urlImagen",blog.getUrlImg());

        long resul = db.insert("Blog", null,values);
        return resul;
    }
    public long insertarSolicitud(String nombre, String apellido, String cedula, String cargo,
                                  String producto, String cantidad, String importancia) {
        SQLiteDatabase db = bdHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Constantes.C_NOMBRE, nombre);
        values.put(Constantes.C_APELLIDO, apellido);
        values.put(Constantes.C_CEDULA, cedula);
        values.put(Constantes.C_CARGO, cargo);
        values.put(Constantes.C_PRODUCTO, producto);
        values.put(Constantes.C_CANTIDAD, cantidad);
        values.put(Constantes.C_IMPORTANCIA, importancia);

        return db.insert(Constantes.gestiones_epp, null, values);
    }

    public long insertarListaChequeo(CrearListaChequeo listaChequeo) {
        openDNWRITE();

        ContentValues values = new ContentValues();

        values.put("usuario_nombre", listaChequeo.getUsuarioNombre());
        values.put("fecha", listaChequeo.getFecha());
        values.put("hora", listaChequeo.getHora());
        values.put("modelo", listaChequeo.getModelo());
        values.put("marca", listaChequeo.getMarca());
        values.put("soat", listaChequeo.getSoat());
        values.put("tecnico", listaChequeo.getTecnico());
        values.put("kilometraje", listaChequeo.getKilometraje());

        long resul = db.insert("lista_chequeo", null, values);
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
