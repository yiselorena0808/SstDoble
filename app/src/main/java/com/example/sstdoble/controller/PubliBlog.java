package com.example.sstdoble.controller;

public class PubliBlog {

    private String titulo;
    private String descripcion;

    private String imagenUri;
    public PubliBlog(String titulo, String descripcion, String imagenUri) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.imagenUri = this.imagenUri;
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
