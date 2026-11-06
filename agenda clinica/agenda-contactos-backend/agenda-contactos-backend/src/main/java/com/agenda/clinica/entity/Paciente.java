package com.agenda.clinica.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDateTime;
@Entity @Table(name="pacientes")
public class Paciente {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @NotBlank @Column(nullable=false,length=120) private String nombre;
 @NotBlank @Column(nullable=false,length=30) private String telefono;
 @Email @Column(length=140) private String correo;
 @Column(name="documento",length=30,unique=true) private String documento;
 @Column(name="creado_en",nullable=false) private LocalDateTime creadoEn=LocalDateTime.now();
 public Long getId(){return id;} public String getNombre(){return nombre;} public void setNombre(String v){nombre=v;} public String getTelefono(){return telefono;} public void setTelefono(String v){telefono=v;} public String getCorreo(){return correo;} public void setCorreo(String v){correo=v;} public String getDocumento(){return documento;} public void setDocumento(String v){documento=v;} public LocalDateTime getCreadoEn(){return creadoEn;}
}
