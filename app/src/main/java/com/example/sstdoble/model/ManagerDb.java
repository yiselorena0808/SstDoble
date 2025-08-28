package com.example.sstdoble.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.sstdoble.controller.CrearGestion;
import com.example.sstdoble.controller.CrearListaChequeo;
import com.example.sstdoble.controller.CrearListaReportes;
import com.example.sstdoble.controller.ListaActividadesItem;
import com.example.sstdoble.controller.ListaChequeoItem;
import com.example.sstdoble.controller.ListaReporterItem;
import com.example.sstdoble.controller.PubliBlog;

import java.util.ArrayList;
import java.util.List;

public class ManagerDb {

    private final DbHelper dbHelper;
    private SQLiteDatabase db;

    public ManagerDb(Context context) {
        this.dbHelper = new DbHelper(context);
    }

    // Abrir base de datos para escritura
    public void openDbWrite() {
        if (db == null || !db.isOpen()) {
            db = dbHelper.getWritableDatabase();
        }
    }

    // Abrir base de datos para lectura
    public void openDbRead() {
        if (db == null || !db.isOpen()) {
            db = dbHelper.getReadableDatabase();
        }
    }

    // Cerrar la base de datos
    public void cerrarDB() {
        if (db != null && db.isOpen()) {
            db.close();
        }
    }

    // ============ LISTA DE CHEQUEO ============
    public long insertarListaChequeo(CrearListaChequeo lista) {
        openDbWrite();
        ContentValues values = new ContentValues();
        values.put("usuarioNombre", lista.getUsuarioNombre());
        values.put("fecha", lista.getFecha());
        values.put("hora", lista.getHora());
        values.put("modelo", lista.getModelo());
        values.put("marca", lista.getMarca());
        values.put("soat", lista.getSoat());
        values.put("tecnico", lista.getTecnico());
        values.put("kilometraje", lista.getKilometraje());

        long resultado = db.insert(Constantes.TABLA_LISTA_CHEQUEO, null, values);
        cerrarDB();
        return resultado;
    }

    public List<ListaChequeoItem> obtenerListasChequeo() {
        List<ListaChequeoItem> lista = new ArrayList<>();
        openDbRead();

        Cursor cursor = db.rawQuery("SELECT * FROM " + Constantes.TABLA_LISTA_CHEQUEO, null);
        if (cursor.moveToFirst()) {
            do {
                String usuario = cursor.getString(cursor.getColumnIndexOrThrow("usuarioNombre"));
                String fecha = cursor.getString(cursor.getColumnIndexOrThrow("fecha"));
                String hora = cursor.getString(cursor.getColumnIndexOrThrow("hora"));
                String modelo = cursor.getString(cursor.getColumnIndexOrThrow("modelo"));
                String marca = cursor.getString(cursor.getColumnIndexOrThrow("marca"));
                String soat = cursor.getString(cursor.getColumnIndexOrThrow("soat"));
                String tecnico = cursor.getString(cursor.getColumnIndexOrThrow("tecnico"));
                String kilometraje = cursor.getString(cursor.getColumnIndexOrThrow("kilometraje"));

                lista.add(new ListaChequeoItem(usuario, fecha, hora, modelo, marca, soat, tecnico, kilometraje));
            } while (cursor.moveToNext());
        }

        cursor.close();
        cerrarDB();
        return lista;
    }

    // ============ REPORTES ============
    public long insertarReporte(CrearListaReportes reporte) {
        openDbWrite();
        ContentValues values = new ContentValues();
        values.put("nombre_usuario", reporte.getNombreUsuario());
        values.put("cargo", reporte.getCargo());
        values.put("cedula", reporte.getCedula());
        values.put("fecha", reporte.getFecha());
        values.put("lugar", reporte.getLugar());
        values.put("descripcion", reporte.getDescripcion());
        values.put("imagen", reporte.getImagen());
        values.put("archivos", reporte.getArchivos());
        values.put("estado", reporte.getEstado());

        long resultado = db.insert(Constantes.TABLA_REPORTES, null, values);
        cerrarDB();
        return resultado;
    }

    public List<ListaReporterItem> obtenerReportes() {
        List<ListaReporterItem> lista = new ArrayList<>();
        openDbRead();

        Cursor cursor = db.rawQuery("SELECT * FROM " + Constantes.TABLA_REPORTES, null);
        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndexOrThrow("id"));
                String nombreUsuario = cursor.getString(cursor.getColumnIndexOrThrow("nombre_usuario"));
                String cargo = cursor.getString(cursor.getColumnIndexOrThrow("cargo"));
                String cedula = cursor.getString(cursor.getColumnIndexOrThrow("cedula"));
                String fecha = cursor.getString(cursor.getColumnIndexOrThrow("fecha"));
                String lugar = cursor.getString(cursor.getColumnIndexOrThrow("lugar"));
                String descripcion = cursor.getString(cursor.getColumnIndexOrThrow("descripcion"));
                String imagen = cursor.getString(cursor.getColumnIndexOrThrow("imagen"));
                String archivos = cursor.getString(cursor.getColumnIndexOrThrow("archivos"));
                String estado = cursor.getString(cursor.getColumnIndexOrThrow("estado"));

                lista.add(new ListaReporterItem(id, nombreUsuario, cargo, cedula, fecha, lugar, descripcion, imagen, archivos, estado));
            } while (cursor.moveToNext());
        }

        cursor.close();
        cerrarDB();
        return lista;
    }

    // ============ ACTIVIDADES ============
    public long insertarActividad(ListaActividadesItem actividad) {
        openDbWrite();
        ContentValues values = new ContentValues();
        values.put("usuario", actividad.getNombreActividad());
        values.put("nombre_actividad", actividad.getLugar());
        values.put("fecha", actividad.getFecha());
        values.put("descripcion", actividad.getDescripcion());
        values.put("evidencia", actividad.getImagenActividad());

        long resultado = db.insert(Constantes.TABLA_ACTIVIDADES, null, values);
        cerrarDB();
        return resultado;
    }

    public List<ListaActividadesItem> obtenerActividades() {
        List<ListaActividadesItem> lista = new ArrayList<>();
        openDbRead();

        Cursor cursor = db.rawQuery("SELECT * FROM " + Constantes.TABLA_ACTIVIDADES, null);
        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndexOrThrow("id"));
                String usuario = cursor.getString(cursor.getColumnIndexOrThrow("usuario"));
                String nombreActividad = cursor.getString(cursor.getColumnIndexOrThrow("nombre_actividad"));
                String fecha = cursor.getString(cursor.getColumnIndexOrThrow("fecha"));
                String descripcion = cursor.getString(cursor.getColumnIndexOrThrow("descripcion"));
                String evidencia = cursor.getString(cursor.getColumnIndexOrThrow("evidencia"));

                lista.add(new ListaActividadesItem(id, usuario, nombreActividad, fecha, descripcion, evidencia));
            } while (cursor.moveToNext());
        }

        cursor.close();
        cerrarDB();
        return lista;
    }

    // ============ BLOG ============
    public long insertarPubli(PubliBlog publi) {
        openDbWrite();
        ContentValues values = new ContentValues();
        values.put("titulo", publi.getTitulo());
        values.put("descripcion", publi.getDescripcion());
        values.put("imagenUri", publi.getImagenUri());

        long resultado = db.insert(Constantes.TABLA_BLOG, null, values);
        cerrarDB();
        return resultado;
    }

    public List<PubliBlog> obtenerSolicitudes() {
        List<PubliBlog> lista = new ArrayList<>();
        openDbRead();

        Cursor cursor = db.rawQuery("SELECT * FROM " + Constantes.TABLA_BLOG, null);
        if (cursor.moveToFirst()) {
            do {
                long id = cursor.getLong(cursor.getColumnIndexOrThrow("id"));
                String titulo = cursor.getString(cursor.getColumnIndexOrThrow("titulo"));
                String descripcion = cursor.getString(cursor.getColumnIndexOrThrow("descripcion"));
                String imagenUri = cursor.getString(cursor.getColumnIndexOrThrow("imagenUri"));

                lista.add(new PubliBlog(id, titulo, descripcion, imagenUri));
            } while (cursor.moveToNext());
        }

        cursor.close();
        cerrarDB();
        return lista;
    }
    public long insertarGestion(CrearGestion gestion) {
        openDbWrite();

        ContentValues values = new ContentValues();
        values.put("nombre", gestion.getNombre());
        values.put("apellido", gestion.getApellido());
        values.put("cedula", gestion.getCedula());
        values.put("cargo", gestion.getCargo());
        values.put("cantidad", gestion.getCantidad());
        values.put("importancia", gestion.getImportancia());

        long resultado = db.insert(Constantes.TABLA_SOLICITUDES, null, values);
        cerrarDB();
        return resultado;
    }

}
