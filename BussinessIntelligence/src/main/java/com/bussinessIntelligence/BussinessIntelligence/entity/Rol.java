package com.bussinessIntelligence.BussinessIntelligence.entity;

import javax.persistence.*;

@Entity
@Table(name = "rol")
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idrol;
    private  String nombre;
    private  int idusuario;
}
