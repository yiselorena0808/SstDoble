package com.example.sstdoble;

class ListaActividadesItem {
    private  String nombre;
    private  String fecha;

    public ListaActividadesItem(String nombre, String fecha) {
        this.nombre= nombre;
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public String getFecha() {
        return fecha;
    }
}

