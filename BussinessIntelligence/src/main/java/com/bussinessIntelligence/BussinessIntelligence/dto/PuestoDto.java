package com.bussinessIntelligence.BussinessIntelligence.dto;

public class PuestoDto {
    private String rolempleado;
    private String descripcion;

    public PuestoDto() {
    }

    public PuestoDto(String rolempleado, String descripcion) {
        this.rolempleado = rolempleado;
        this.descripcion = descripcion;
    }

    public String getRolempleado() {
        return rolempleado;
    }

    public void setRolempleado(String rolempleado) {
        this.rolempleado = rolempleado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
