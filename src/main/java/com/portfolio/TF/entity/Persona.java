package com.portfolio.TF.entity;

import java.util.List;
import javax.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_pers;
    @Basic
    private String nombre;
    private String apellido;
    private String titulo;
    private String resumen;
    private String foto;
    private String bannerPersonal;
    private String redSocial1;
    private String redSocial2;

    @OneToMany(mappedBy = "persona", cascade = {CascadeType.ALL})
    private List<Domicilio> doms;

    @OneToMany(mappedBy = "persona", cascade = {CascadeType.ALL})
    private List<Educacion> edus;

    @OneToMany(mappedBy = "persona", cascade = {CascadeType.ALL})
    private List<ExperienciaLaboral> exp_laboral;

    @OneToMany(mappedBy = "persona", cascade = {CascadeType.ALL})
    private List<Proyectos> proyectos;

    @OneToMany(mappedBy = "persona", cascade = {CascadeType.ALL})
    private List<Tecnologias> tecnologias;

    public Persona() {
    }

    public Persona(int id,
            String nombre,
            String apellido,
            String titulo,
            String resumen,
            String foto,
            String bannerPersonal,
            String redSocial1,
            String redSocial2) {
        this.id_pers = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.titulo = titulo;
        this.resumen = resumen;
        this.foto = foto;
        this.bannerPersonal = bannerPersonal;
        this.redSocial1 = redSocial1;
        this.redSocial2 = redSocial2;
    }

}
