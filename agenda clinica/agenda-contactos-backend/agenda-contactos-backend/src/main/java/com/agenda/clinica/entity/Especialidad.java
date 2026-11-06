package com.agenda.clinica.entity;
import jakarta.persistence.*;
@Entity @Table(name="especialidades")
public class Especialidad { @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id; @Column(nullable=false,unique=true,length=90) private String nombre; public Long getId(){return id;} public String getNombre(){return nombre;} public void setNombre(String v){nombre=v;} }
