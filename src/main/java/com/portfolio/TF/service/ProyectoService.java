package com.portfolio.TF.service;

import com.portfolio.TF.entity.Proyectos;
import com.portfolio.TF.repository.ProyectosRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProyectoService implements IProyectoService {

    @Autowired
    public ProyectosRepository proRepo;

    @Override
    public List<Proyectos> mostrarProyectos() {
        return proRepo.findAll();
    }

    @Override
    public void crearProyecto(Proyectos proyecto) {
        proRepo.save(proyecto);
    }

    @Override
    public void borrarProyecto(int id) {
        proRepo.deleteById(id);
    }

    @Override
    public Proyectos buscarProyecto(int id) {
        return proRepo.findById(id).orElse(null);
    }

    @Override
    public void modificarProyecto(Proyectos proyecto) {
        proRepo.save(proyecto);
    }
}
