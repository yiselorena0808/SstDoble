package com.example.sstdoble.controller;

public class ListaGestionItem {
    private String nombre;
    private String fecha;

    public ListaGestionItem(String nombre, String fecha) {
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
