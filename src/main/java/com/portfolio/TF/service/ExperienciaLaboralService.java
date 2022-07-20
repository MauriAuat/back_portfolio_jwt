package com.portfolio.TF.service;

import com.portfolio.TF.entity.ExperienciaLaboral;
import com.portfolio.TF.repository.ExperienciaLaboralRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExperienciaLaboralService implements IExperienciaLaboralService {

    @Autowired
    public ExperienciaLaboralRepository expLab;

    @Override
    public List<ExperienciaLaboral> mostrarExperienciaLaboral() {
        return expLab.findAll();
    }

    @Override
    public void crearExperienciaLaboral(ExperienciaLaboral exp_laboral) {
        expLab.save(exp_laboral);
    }

    @Override
    public void borrarExperienciaLaboral(int id) {
        expLab.deleteById(id);
    }

    @Override
    public ExperienciaLaboral buscarExperienciaLaboral(int id) {
        return expLab.findById(id).orElse(null);
    }

    @Override
    public void modificarExperienciaLaboral(ExperienciaLaboral exp_laboral) {
        expLab.save(exp_laboral);
    }
}
