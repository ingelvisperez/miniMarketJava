package com.generation.recuperativa.models;

// Esta clase hereda el "nombre de la categoria" de la clase TipoProducto
public class Producto extends TipoProducto {
    // Creacion de Atributos
    public String nombreProducto;
    public Double precioProveedor;
    public Double precioVenta;
    public Integer cantidad;

    
    // Creacion de los construcctores
    public Producto() {
    }

    public Producto(String nombreProducto, Double precioProveedor, Double precioVenta, Integer cantidad) {
        this.nombreProducto = nombreProducto;
        this.precioProveedor = precioProveedor;
        this.precioVenta = precioVenta;
        this.cantidad = cantidad;
    }

    public Producto(String nombreCategoria, String nombreProducto, Double precioProveedor, Double precioVenta, Integer cantidad) {
        super(nombreCategoria);
        this.nombreProducto = nombreProducto;
        this.precioProveedor = precioProveedor;
        this.precioVenta = precioVenta;
        this.cantidad = cantidad;
    }

    // Funciones Getters y Setters
    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public Double getPrecioProveedor() {
        return precioProveedor;
    }

    public void setPrecioProveedor(Double precioProveedor) {
        this.precioProveedor = precioProveedor;
    }

    public Double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(Double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
    

    @Override
    public String toString() {
        return super.toString() + "Producto [nombreProducto=" + nombreProducto + ", precioProveedor=" + precioProveedor + ", precioVenta="
                + precioVenta + "]";
    }



    

    



}
