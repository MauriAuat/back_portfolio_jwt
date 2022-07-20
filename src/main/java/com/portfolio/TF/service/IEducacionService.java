package com.portfolio.TF.service;

import com.portfolio.TF.entity.Educacion;
import java.util.List;

public interface IEducacionService {

    public List<Educacion> mostrarEducacion();

    public void crearEducacion(Educacion educacion);

    public void borrarEducacion(int id);

    public Educacion buscarEducacion(int id);

    public void modificarEducacion(Educacion educacion);
}
