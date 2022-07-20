package com.portfolio.TF.controller;

import com.portfolio.TF.entity.Domicilio;
import com.portfolio.TF.service.DomicilioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/dom")
@CrossOrigin(origins = "http://localhost:4200")
public class DomicilioController {
    
    @Autowired
    private DomicilioService domiService;
    
    @GetMapping("/{id}")
    @ResponseBody
    public Domicilio verDomocilio(@PathVariable int id) {
        return domiService.buscarDomicilio(id);
    }
    
    @GetMapping("/mostrar-lista")
    @ResponseBody
    public List<Domicilio> verDomicilios() {
        return domiService.mostrarDomicilios();
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/nuevo")
    public void agregarDomicilio(@RequestBody Domicilio domi) {
        domiService.crearDomicilio(domi);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/borrar/{id}")
    public void borrarDomicilio(@PathVariable int id) {
        domiService.borrarDomicilio(id);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/editar")
    public void editarDomicilio(@RequestBody Domicilio domi) {
        Domicilio nvo = domiService.buscarDomicilio(domi.getId());
        if (nvo != null) {
            nvo.setDireccion(domi.getDireccion());
            domiService.modificarDomicilio(nvo);
        }
    }
    
}
