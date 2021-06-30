package com.bussinessIntelligence.BussinessIntelligence.dto;

public class VentaDto {
    private int idcliente;
    private String fecha;
    private int idproducto;
    private int cantidad;
    private float precio;
    private float total;

    public VentaDto() {
    }

    public VentaDto(int idcliente, String fecha, int idproducto, int cantidad, float precio, float total) {
        this.idcliente = idcliente;
        this.fecha = fecha;
        this.idproducto = idproducto;
        this.cantidad = cantidad;
        this.precio = precio;
        this.total = total;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(int idproducto) {
        this.idproducto = idproducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }
}
