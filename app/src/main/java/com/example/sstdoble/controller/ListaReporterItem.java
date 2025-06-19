package com.example.sstdoble.controller;


public class ListaReporterItem {

    private int id;
    private String nombre_usuario;
    private String cargo;
    private String cedula;
    private String fecha;
    private String lugar;
    private String descripcion;
    private String imagen;
    private String archivos;
    private String estado;

    public ListaReporterItem(int id, String nombre_usuario, String cargo, String cedula, String fecha, String lugar,
                             String descripcion, String imagen, String archivos, String estado) {
        this.id = id;
        this.nombre_usuario = nombre_usuario;
        this.cargo = cargo;
        this.cedula = cedula;
        this.fecha = fecha;
        this.lugar = lugar;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.archivos = archivos;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public String getCargo() {
        return cargo;
    }

    public String getCedula() {
        return cedula;
    }

    public String getFecha() {
        return fecha;
    }

    public String getLugar() {
        return lugar;
    }

    public String getDescripcionreportes() {
        return descripcion;
    }

    public String getImagenreportes() {
        return imagen;
    }

    public String getArchivos() {
        return archivos;
    }

    public String getEstado() {
        return estado;
    }
}
