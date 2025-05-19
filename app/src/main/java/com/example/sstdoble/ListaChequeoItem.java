package com.example.sstdoble;

public class ListaChequeoItem {
    private String nombre;
    private String fecha;

    public ListaChequeoItem(String nombre, String fecha) {
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