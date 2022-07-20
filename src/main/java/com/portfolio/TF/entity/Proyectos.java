/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.TF.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.persistence.Entity;
import javax.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
public class Proyectos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_proyecto;
    @Basic
    private String nombre_proyecto;
    private LocalDate fecha_activo;
    private String descripcion;
    private String link_proyecto;
    private String imagen_muestra;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pers")
    @JsonBackReference
    private Persona persona;

    public Proyectos() {
    }

    public Proyectos(int id_proyecto, String nombre_proyecto, String fecha_activo, String descripcion, String link_proyecto, String imagen_muestra, Persona persona) {
        this.id_proyecto = id_proyecto;
        this.nombre_proyecto = nombre_proyecto;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate fecha_act = LocalDate.parse(fecha_activo, formatter);
        this.fecha_activo = fecha_act;
        this.descripcion = descripcion;
        this.link_proyecto = link_proyecto;
        this.imagen_muestra = imagen_muestra;
        this.persona = persona;
    }

}
