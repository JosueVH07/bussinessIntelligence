package com.bussinessIntelligence.BussinessIntelligence.dto;

public class ProductoDto {
    private int idproveedor;
    private String nombre;
    private float precio;
    private String descripcion;
    private int stock;

    public ProductoDto() {
    }

    public ProductoDto(int idproveedor, String nombre, float precio, String descripcion, int stock) {
        this.idproveedor = idproveedor;
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
        this.stock = stock;
    }

    public int getIdproveedor() {
        return idproveedor;
    }

    public void setIdproveedor(int idproveedor) {
        this.idproveedor = idproveedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
