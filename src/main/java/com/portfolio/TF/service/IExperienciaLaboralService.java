package com.portfolio.TF.service;

import com.portfolio.TF.entity.ExperienciaLaboral;
import java.util.List;

public interface IExperienciaLaboralService {

    public List<ExperienciaLaboral> mostrarExperienciaLaboral();

    public void crearExperienciaLaboral(ExperienciaLaboral exp_laboral);

    public void borrarExperienciaLaboral(int id);

    public ExperienciaLaboral buscarExperienciaLaboral(int id);

    public void modificarExperienciaLaboral(ExperienciaLaboral exp_laboral);
}
