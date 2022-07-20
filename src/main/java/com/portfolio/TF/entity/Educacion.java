package com.portfolio.TF.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
public class Educacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_edu;
    @Basic
    private String nombre_inst;
    private String logo_inst;
    private String titulo;
    private LocalDate fecha_ingreso;
    private LocalDate fecha_egreso;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pers")
    @JsonBackReference
    private Persona persona;

    public Educacion() {
    }

    public Educacion(int id_edu, String nombre_inst, String logo_inst, String titulo, String fecha_ingreso, String fecha_egreso, Persona persona) {

        this.id_edu = id_edu;
        this.nombre_inst = nombre_inst;
        this.logo_inst = logo_inst;
        this.titulo = titulo;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate fecha_ing = LocalDate.parse(fecha_ingreso, formatter);
        LocalDate fecha_egr = LocalDate.parse(fecha_egreso, formatter);
        this.fecha_ingreso = fecha_ing;
        this.fecha_egreso = fecha_egr;
        this.persona = persona;
    }

}
