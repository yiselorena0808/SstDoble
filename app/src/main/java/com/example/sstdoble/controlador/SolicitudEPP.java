package com.example.sstdoble.controlador;

public class SolicitudEPP {
    private String nombre;
    private String fecha;

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
