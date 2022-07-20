package com.portfolio.TF.service;

import com.portfolio.TF.entity.Tecnologias;
import com.portfolio.TF.repository.TecnologiasRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TecnologiaService implements ITecnologiaService {

    @Autowired
    public TecnologiasRepository tecnoRepo;

    @Override
    public List<Tecnologias> mostrarTecnologias() {
        return tecnoRepo.findAll();
    }

    @Override
    public void crearTecnologia(Tecnologias tecnologia) {
        tecnoRepo.save(tecnologia);
    }

    @Override
    public void borrarTecnologia(int id) {
        tecnoRepo.deleteById(id);
    }

    @Override
    public Tecnologias buscarTecnologia(int id) {
        return tecnoRepo.findById(id).orElse(null);
    }

    @Override
    public void modificarTecnologia(Tecnologias tecnologia) {
        tecnoRepo.save(tecnologia);
    }
}
