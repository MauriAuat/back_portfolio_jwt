package com.portfolio.TF.service;

import com.portfolio.TF.entity.Proyectos;
import java.util.List;

public interface IProyectoService {

    public List<Proyectos> mostrarProyectos();

    public void crearProyecto(Proyectos proyecto);

    public void borrarProyecto(int id);

    public Proyectos buscarProyecto(int id);

    public void modificarProyecto(Proyectos proyecto);
}
