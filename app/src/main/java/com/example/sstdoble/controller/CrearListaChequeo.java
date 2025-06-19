package com.example.sstdoble.controller;

public class CrearListaChequeo {

    private int id;
    private String usuarioNombre;
    private String fecha;
    private String hora;
    private String modelo;
    private String marca;
    private String soat;
    private String tecnico;
    private String kilometraje;

    public CrearListaChequeo() {
    }

    public CrearListaChequeo(int id, String usuarioNombre, String fecha, String hora,
                             String modelo, String marca, String soat, String tecnico,
                             String kilometraje) {
        this.id = id;
        this.usuarioNombre = usuarioNombre;
        this.fecha = fecha;
        this.hora = hora;
        this.modelo = modelo;
        this.marca = marca;
        this.soat = soat;
        this.tecnico = tecnico;
        this.kilometraje = kilometraje;
    }

    // Getters y Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuarioNombre() {
        return usuarioNombre;
    }

    public void setUsuarioNombre(String usuarioNombre) {
        this.usuarioNombre = usuarioNombre;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getSoat() {
        return soat;
    }

    public void setSoat(String soat) {
        this.soat = soat;
    }

    public String getTecnico() {
        return tecnico;
    }

    public void setTecnico(String tecnico) {
        this.tecnico = tecnico;
    }

    public String getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(String kilometraje) {
        this.kilometraje = kilometraje;
    }

    @Override
    public String toString() {
        return "ListaChequeo{" +
                "id=" + id +
                ", usuarioNombre='" + usuarioNombre + '\'' +
                ", fecha='" + fecha + '\'' +
                ", hora='" + hora + '\'' +
                ", modelo='" + modelo + '\'' +
                ", marca='" + marca + '\'' +
                ", soat='" + soat + '\'' +
                ", tecnico='" + tecnico + '\'' +
                ", kilometraje='" + kilometraje + '\'' +
                '}';
    }
}