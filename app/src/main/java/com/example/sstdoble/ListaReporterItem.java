package com.example.sstdoble;

class ListaReporterItem {
    private String nombre;
    private String fecha;

    public ListaReporterItem(String nombre, String fecha) {
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