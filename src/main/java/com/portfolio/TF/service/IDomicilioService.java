package com.portfolio.TF.service;

import com.portfolio.TF.entity.Domicilio;
import java.util.List;

public interface IDomicilioService {

    public List<Domicilio> mostrarDomicilios();

    public void crearDomicilio(Domicilio domicilio);

    public void borrarDomicilio(int id);

    public Domicilio buscarDomicilio(int id);

    public void modificarDomicilio(Domicilio domicilio);
}
