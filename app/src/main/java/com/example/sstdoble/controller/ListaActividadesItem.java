package com.example.sstdoble.controller;

public class ListaActividadesItem {
    private int id;
    private String usuario;
    private String nombreActividad;
    private String fecha;
    private String descripcion;
    private String evidencia;
    private String lugar;
    private String imagenActividad;

    public ListaActividadesItem(int id, String usuario, String nombreActividad, String fecha, String descripcion, String evidencia) {
        this.id = id;
        this.usuario = usuario;
        this.nombreActividad = nombreActividad;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.evidencia = evidencia;
        this.lugar = lugar;
        this.imagenActividad = imagenActividad;
    }

    public int getId() {
        return id;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getNombreActividad() {
        return nombreActividad;
    }

    public String getFecha() {
        return fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getEvidencia() {
        return evidencia;
    }

    public String getLugar() {
        return lugar;
    }

    public String getImagenActividad() {
        return imagenActividad;
    }
}
