package com.example.sstdoble.controlador;

public class Constantes {


    public static final String NOMBRE_BD = "SSTDB";
    public static final int VERSION_BD = 4;

    public static String BLOG = "Create table Blog (id integer primary key autoincrement, titulo text, urlImagen text, descripcion text)";

        public static final String gestiones_epp = "solicitudes";

        public static final String C_ID = "id";
        public static final String C_NOMBRE = "nombre";
        public static final String C_APELLIDO = "apellido";
        public static final String C_CEDULA = "cedula";
        public static final String C_CARGO = "cargo";
        public static final String C_PRODUCTO = "producto";
        public static final String C_CANTIDAD = "cantidad";
        public static final String C_IMPORTANCIA = "importancia";

    public static String LISTA_CHEQUEO = "CREATE TABLE lista_chequeo (" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "usuario_nombre TEXT, " +
            "fecha TEXT, " +
            "hora TEXT, " +
            "modelo TEXT, " +
            "marca TEXT, " +
            "soat TEXT, " +
            "tecnico TEXT, " +
            "kilometraje TEXT)";
    public static String ACTIVIDADES_LUDICAS = "Create table ActividadesLudicas (id integer primary key autoincrement, nombreUsuario text, nombreActividad text, fechaActividad text, descripcion text, urlEvidencia text)";

}
