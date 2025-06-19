package com.example.sstdoble.controller;

public class SolicitudEPP {
    public String nombre;
    public String fecha;


    public SolicitudEPP(String nombre, String fecha) {
        this.nombre = nombre;
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public String getFecha() {
        return fecha;
    }
}
