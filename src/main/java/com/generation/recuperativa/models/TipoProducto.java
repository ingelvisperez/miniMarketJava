package com.generation.recuperativa.models;


public class TipoProducto {
    // Creacion de Atributos
    public String nombreCategoria;
    
    // Creacion de los Constructores
    public TipoProducto() {
    }
    public TipoProducto(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    // Funciones Getters y Setters
    public String getNombreCategoria() {
        return nombreCategoria;
    }
    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }
    @Override
    public String toString() {
        return "TipoProducto [nombreCategoria=" + nombreCategoria + "]";
    }

    

}
