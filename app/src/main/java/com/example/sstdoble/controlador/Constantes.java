package com.example.sstdoble.controlador;

public class Constantes {

    public static final String NOMBRE_BD = "SSTDB";
    public static final int VERSION_BD = 2;

    public static String BLOG = "Create table Blog (id integer primary key autoincrement, titulo text, urlImagen text, descripcion text)";

    public static String REPORTE = "Create table Reportes (id integer primary key autoincrement, nombreUsuario text, cargoUsuario text, cedula text, fecha text, lugar text, descripcion text, rutaImagen text, rutaArchivos text, estado text)";

    public static String ACTIVIDADES_LUDICAS = "Create table ActividadesLudicas (id integer primary key autoincrement, nombreUsuario text, nombreActividad text, fechaActividad text, descripcion text, urlEvidencia text)";

    public static String SOLICITUDES = "Create table Solicitudes (id integer primary key autoincrement, nombre text, apellido text, cedula integer, cargo text, producto text, cantidad integer ";



}

