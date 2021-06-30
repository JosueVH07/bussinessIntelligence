package com.bussinessIntelligence.BussinessIntelligence.dto;

public class RolDto {
    private  String nombre;
    private  int idusuario;

    public RolDto() {
    }

    public RolDto(String nombre, int idusuario) {
        this.nombre = nombre;
        this.idusuario = idusuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }
}
