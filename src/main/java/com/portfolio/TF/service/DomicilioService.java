package com.portfolio.TF.service;

import com.portfolio.TF.entity.Domicilio;
import com.portfolio.TF.repository.DomicilioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DomicilioService implements IDomicilioService {

    @Autowired
    public DomicilioRepository domiRepo;

    @Override
    public List<Domicilio> mostrarDomicilios() {
        return domiRepo.findAll();
    }

    @Override
    public void crearDomicilio(Domicilio domicilio) {
        domiRepo.save(domicilio);
    }

    @Override
    public void borrarDomicilio(int id) {
        domiRepo.deleteById(id);
    }

    @Override
    public Domicilio buscarDomicilio(int id) {
        return domiRepo.findById(id).orElse(null);
    }

    @Override
    public void modificarDomicilio(Domicilio domicilio) {
        domiRepo.save(domicilio);
    }
}
