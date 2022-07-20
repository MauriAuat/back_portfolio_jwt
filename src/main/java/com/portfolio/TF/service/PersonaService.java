package com.portfolio.TF.service;

import com.portfolio.TF.entity.Persona;
import com.portfolio.TF.repository.PersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaService implements IPersonaService {

    @Autowired
    public PersonaRepository persoRepo;

    @Override
    public List<Persona> mostrarPersonas() {
        return persoRepo.findAll();
    }

    @Override
    public void crearPersona(Persona persona) {
        persoRepo.save(persona);
    }

    @Override
    public void borrarPersona(int id) {
        persoRepo.deleteById(id);
    }

    @Override
    public Persona buscarPersona(int id) {
        return persoRepo.findById(id).orElse(null);
    }

    @Override
    public void modificarPersona(Persona persona) {
        persoRepo.save(persona);
    }
}
