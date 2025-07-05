package com.example.sstdoble.model;

public class Constantes {

    // Nombre y versión de la base de datos
    public static final String NOMBRE_BD = "SSTDB";
    public static final int VERSION_BD = 6;

    // Nombres de tablas
    public static final String TABLA_LISTA_CHEQUEO = "lista_chequeo";
    public static final String TABLA_REPORTES = "reportes";
    public static final String TABLA_ACTIVIDADES = "actividades";
    public static final String TABLA_SOLICITUDES = "solicitudes";

    // Crear tabla lista_chequeo
    public static final String CREAR_TABLA_LISTA_CHEQUEO = "CREATE TABLE " + TABLA_LISTA_CHEQUEO + " (" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "usuarioNombre TEXT, " +
            "fecha TEXT, " +
            "hora TEXT, " +
            "modelo TEXT, " +
            "marca TEXT, " +
            "soat TEXT, " +
            "tecnico TEXT, " +
            "kilometraje TEXT" +
            ")";

    // Crear tabla reportes
    public static final String CREAR_TABLA_REPORTES = "CREATE TABLE " + TABLA_REPORTES + " (" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "nombre_usuario TEXT, " +
            "cargo TEXT, " +
            "cedula TEXT, " +
            "fecha TEXT, " +
            "lugar TEXT, " +
            "descripcion TEXT, " +
            "imagen TEXT, " +
            "archivos TEXT, " +
            "estado TEXT" +
            ")";

    // Crear tabla actividades
    public static final String CREAR_TABLA_ACTIVIDADES = "CREATE TABLE " + TABLA_ACTIVIDADES + " (" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "usuario TEXT, " +
            "nombre_actividad TEXT, " +
            "fecha TEXT, " +
            "descripcion TEXT, " +
            "evidencia TEXT" +
            ")";

    // Crear tabla solicitudes (gestión EPP)
    public static final String CREAR_TABLA_SOLICITUDES = "CREATE TABLE " + TABLA_SOLICITUDES + " (" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "nombre TEXT, " +
            "apellido TEXT, " +
            "cedula TEXT, " +
            "cargo TEXT, " +
            "producto TEXT, " +
            "cantidad TEXT, " +
            "importancia TEXT" +
            ")";
    //Crear tabla blog
    public static final String TABLA_BLOG = "blog";

    public static final String CREAR_TABLA_BLOG = "CREATE TABLE " + TABLA_BLOG + " (" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "titulo TEXT, " +
            "descripcion TEXT, " +
            "imagenUri TEXT" +
            ")";

}
