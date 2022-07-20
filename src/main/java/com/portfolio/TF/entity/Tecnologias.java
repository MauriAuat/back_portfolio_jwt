package com.portfolio.TF.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
public class Tecnologias {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_tecno;
    @Basic
    private String nombre_tecno;
private int nivel;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pers")
    @JsonBackReference
    private Persona persona;

    public Tecnologias() {
    }

    public Tecnologias(int id_tecno, String nombre_tecno, Persona persona) {
        this.id_tecno = id_tecno;
        this.nombre_tecno = nombre_tecno;
        this.persona = persona;
    }

}
