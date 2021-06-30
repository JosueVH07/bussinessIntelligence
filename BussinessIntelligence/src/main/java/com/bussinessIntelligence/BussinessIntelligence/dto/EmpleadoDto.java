package com.bussinessIntelligence.BussinessIntelligence.dto;

public class EmpleadoDto {
    private int idpuesto;
    private int idusuario;
    private int idrol;
    private  String nombre;
    private  String telefono;
    private  String direccion;
    private  String correo;

    public EmpleadoDto() {
    }

    public EmpleadoDto(int idpuesto, int idusuario, int idrol, String nombre, String telefono, String direccion, String correo) {
        this.idpuesto = idpuesto;
        this.idusuario = idusuario;
        this.idrol = idrol;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.correo = correo;
    }

    public int getIdpuesto() {
        return idpuesto;
    }

    public void setIdpuesto(int idpuesto) {
        this.idpuesto = idpuesto;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public int getIdrol() {
        return idrol;
    }

    public void setIdrol(int idrol) {
        this.idrol = idrol;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
