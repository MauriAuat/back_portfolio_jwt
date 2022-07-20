package com.portfolio.TF.service;

import com.portfolio.TF.entity.Tecnologias;
import java.util.List;

public interface ITecnologiaService {

    public List<Tecnologias> mostrarTecnologias();

    public void crearTecnologia(Tecnologias tecnologia);

    public void borrarTecnologia(int id);

    public Tecnologias buscarTecnologia(int id);

    public void modificarTecnologia(Tecnologias tecnologia);
}
