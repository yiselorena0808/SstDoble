package com.example.sstdoble.controlador;

public class CrearGestion {
    public String nombre;
    public String apellido;
    public int cedula;
    public String cargo;
    public String producto;

    public String importancia;
    public int cantidad;

    public CrearGestion(String nombre, String apellido, String cedula, String cargo, String producto, String cantidad, String importancia){
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.producto = producto;
        this.cantidad = cantidad;
        this.importancia = importancia;
        this.cargo = cargo;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){this.nombre = nombre;}

    public String getApellido(){
        return apellido;
    }

    public void setApellido(String apellido){this.apellido = apellido;}

    public int getCedula(){
        return cedula;
    }

    public void setCedula(int cedula){this.cedula = cedula;}

    public String getProducto(){
        return producto;
    }

    public void setProducto(String producto){this.producto = producto;}

    public String getCargo(){
        return cargo;
    }

    public void setCargo(String cargo){this.cargo = cargo;}

    public String getImportancia(){
        return importancia;
    }

    public void setImportancia(String importancia){this.importancia=importancia;}

    public int getCantidad(){
        return cantidad;
    }

    public void setCantidad(int cantidad){this.cantidad = cantidad;}


    @Override
    public String toString(){
        return "CrearGestion" +
                "nombre="+ nombre +
                ", apellido=" + apellido +
                ", cedula=" + cedula +
                ", cargo=" + cargo +
                ", producto="+ producto +
                ", cantidad=" + cantidad +
                ", importancia=" + importancia + '\'' +
                "}";

    }
}
