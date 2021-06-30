package com.bussinessIntelligence.BussinessIntelligence.dto;

public class DetalleVentaDto {
    private int idventa;
    private int idproducto;
    private  String detalle;
    private int idempleado;

    public DetalleVentaDto() {
    }

    public DetalleVentaDto(int idventa, int idproducto, String detalle, int idempleado) {
        this.idventa = idventa;
        this.idproducto = idproducto;
        this.detalle = detalle;
        this.idempleado = idempleado;
    }

    public int getIdventa() {
        return idventa;
    }

    public void setIdventa(int idventa) {
        this.idventa = idventa;
    }

    public int getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(int idproducto) {
        this.idproducto = idproducto;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public int getIdempleado() {
        return idempleado;
    }

    public void setIdempleado(int idempleado) {
        this.idempleado = idempleado;
    }
}
