/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.TF.controller;

import com.portfolio.TF.entity.Persona;
import com.portfolio.TF.service.PersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/persona")
@CrossOrigin(origins = "https://portfolio-web-3d440.web.app")
public class PersonaController {

    @Autowired
    private PersonaService persoService;

    @GetMapping("/{id}")
    @ResponseBody
    public Persona verPersona(@PathVariable int id) {
        return persoService.buscarPersona(id);
    }

    @GetMapping("/mostrar-lista")
    @ResponseBody
    public List<Persona> verPersonas() {
        return persoService.mostrarPersonas();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/nueva")
    public void agregarPersona(@RequestBody Persona perso) {
        persoService.crearPersona(perso);
    }


    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/borrar/{id}")
    public void borrarPersona(@PathVariable int id) {
        persoService.borrarPersona(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/editar")
    public void editarPersona(@RequestBody Persona perso) {
        Persona nva = persoService.buscarPersona(perso.getId_pers());
        
        if(perso.getNombre()!=null){
            nva.setNombre(perso.getNombre());
        }          
        if(perso.getApellido()!=null){
            nva.setApellido(perso.getApellido());
        }
        if(perso.getTitulo()!=null){
            nva.setTitulo(perso.getTitulo());
        }
        if(perso.getResumen()!=null){
            nva.setResumen(perso.getResumen());
        }
        if(perso.getFoto()!=null){
            nva.setFoto(perso.getFoto());
        }
        if(perso.getBannerPersonal()!=null){
            nva.setBannerPersonal(perso.getBannerPersonal());
        }
        if(perso.getRedSocial1()!=null){
                    nva.setRedSocial1(perso.getRedSocial1());
                }
         if(perso.getRedSocial2()!=null){
                    nva.setRedSocial2(perso.getRedSocial2());
                }
            persoService.modificarPersona(nva);
        
    }
}
