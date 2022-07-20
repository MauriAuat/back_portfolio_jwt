package com.portfolio.TF.service;

import com.portfolio.TF.entity.Persona;
import java.util.List;

public interface IPersonaService {

    public List<Persona> mostrarPersonas();

    public void crearPersona(Persona persona);

    public void borrarPersona(int id);

    public Persona buscarPersona(int id);

    public void modificarPersona(Persona persona);
}
