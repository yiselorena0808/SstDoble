package com.example.sstdoble.controller;

public class CrearActividades {

    private int id;
    private String nombreUsuario;
    private String nombreActividad;
    private String fechaActividad;
    private String descripcion;
    private String urlEvidencia;

    public CrearActividades() {
    }

    public CrearActividades(int id, String nombreUsuario, String nombreActividad, String fechaActividad, String descripcion, String urlEvidencia) {
        this.id = id;
        this.nombreUsuario = nombreUsuario;
        this.nombreActividad = nombreActividad;
        this.fechaActividad = fechaActividad;
        this.descripcion = descripcion;
        this.urlEvidencia = urlEvidencia;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getNombreActividad() {
        return nombreActividad;
    }

    public void setNombreActividad(String nombreActividad) {
        this.nombreActividad = nombreActividad;
    }

    public String getFechaActividad() {
        return fechaActividad;
    }

    public void setFechaActividad(String fechaActividad) {
        this.fechaActividad = fechaActividad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUrlEvidencia() {
        return urlEvidencia;
    }

    public void setUrlEvidencia(String urlEvidencia) {
        this.urlEvidencia = urlEvidencia;
    }

    @Override
    public String toString() {
        return "CrearActividadesL{" +
                "id=" + id +
                ", nombreUsuario='" + nombreUsuario + '\'' +
                ", nombreActividad='" + nombreActividad + '\'' +
                ", fechaActividad='" + fechaActividad + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", urlEvidencia='" + urlEvidencia + '\'' +
                '}';
    }
}