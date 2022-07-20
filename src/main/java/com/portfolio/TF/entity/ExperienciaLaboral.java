package com.portfolio.TF.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
public class ExperienciaLaboral {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_exp;
    @Basic
    private String cargo;
    private String empresa;
    private String logo_Empresa;
    private LocalDate fecha_inicio;
    private LocalDate fecha_fin;
    private String descripcion;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pers")
    @JsonBackReference
    private Persona persona;

    public ExperienciaLaboral() {
    }

    public ExperienciaLaboral(int id_exp, String cargo, String empresa, String logo_Empresa, String fecha_inicio, String fecha_fin, String descripcion, Persona persona) {
        this.id_exp = id_exp;
        this.cargo = cargo;
        this.empresa = empresa;
        this.logo_Empresa = logo_Empresa;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate fecha_in = LocalDate.parse(fecha_inicio, formatter);
        LocalDate fecha_fn = LocalDate.parse(fecha_fin, formatter);
        this.fecha_inicio = fecha_in;
        this.fecha_fin = fecha_fn;
        this.descripcion = descripcion;
        this.persona = persona;
    }

}
