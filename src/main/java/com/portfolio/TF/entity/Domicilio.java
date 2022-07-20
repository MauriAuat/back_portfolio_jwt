package com.portfolio.TF.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
public class Domicilio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Basic
    private String direccion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pers")
    @JsonBackReference
    private Persona persona;

    public Domicilio() {
    }

    public Domicilio(int id, String direccion, Persona persona) {
        this.id = id;
        this.direccion = direccion;
        this.persona = persona;
    }

}
