package com.bussinessIntelligence.BussinessIntelligence.entity;

import javax.persistence.*;

@Entity
@Table(name = "puesto")
public class Puesto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idpuesto;
    private  String rolempleado;
    private  String descripcion;

    public Puesto() {
    }

    public Puesto(String rolempleado, String descripcion) {
        this.rolempleado = rolempleado;
        this.descripcion = descripcion;
    }

    public int getIdpuesto() {
        return idpuesto;
    }

    public void setIdpuesto(int idpuesto) {
        this.idpuesto = idpuesto;
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
