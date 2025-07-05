package com.example.sstdoble.controller;;

public class PubliBlog {

    private long id;
    private String titulo;
    private String descripcion;
    private String imagenUri;

    // Constructor para insertar publicación sin id
    public PubliBlog(String titulo, String descripcion, String imagenUri) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.imagenUri = imagenUri;
    }

    // Constructor con id (cuando obtienes la publicación de la base de datos)
    public PubliBlog(long id, String titulo, String descripcion, String imagenUri) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.imagenUri = imagenUri;
    }

    public long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getImagenUri() {
        return imagenUri;
    }
}
