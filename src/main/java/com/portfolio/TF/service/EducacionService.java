package com.portfolio.TF.service;

import com.portfolio.TF.entity.Educacion;
import com.portfolio.TF.repository.EducacionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EducacionService implements IEducacionService {

    @Autowired
    public EducacionRepository eduRepo;

    @Override
    public List<Educacion> mostrarEducacion() {
        return eduRepo.findAll();
    }

    @Override
    public void crearEducacion(Educacion educacion) {
        eduRepo.save(educacion);
    }

    @Override
    public void borrarEducacion(int id) {
        eduRepo.deleteById(id);
    }

    @Override
    public Educacion buscarEducacion(int id) {
        return eduRepo.findById(id).orElse(null);
    }

    @Override
    public void modificarEducacion(Educacion educacion) {
        eduRepo.save(educacion);
    }
}
