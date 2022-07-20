package com.portfolio.TF.controller;

import com.portfolio.TF.entity.ExperienciaLaboral;
import com.portfolio.TF.service.ExperienciaLaboralService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/exp")
@CrossOrigin(origins = "http://localhost:4200")
public class ExperienciaLaboralController {

    @Autowired
    private ExperienciaLaboralService expService;

    @GetMapping("/{id}")
    @ResponseBody
    public ExperienciaLaboral verExpLaboral(@PathVariable int id) {
        return expService.buscarExperienciaLaboral(id);
    }

    @GetMapping("/mostrar-lista")
    @ResponseBody
    public List<ExperienciaLaboral> verExpLaborales() {
        return expService.mostrarExperienciaLaboral();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/nueva")
    public void agregarExpLaboral(@RequestBody ExperienciaLaboral expLab) {
        expService.crearExperienciaLaboral(expLab);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/borrar/{id}")
    public void borrarExpLaboral(@PathVariable int id) {
        expService.borrarExperienciaLaboral(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/editar")
    public void editarExpLaboral(@RequestBody ExperienciaLaboral expLab) {
        ExperienciaLaboral nva = expService.buscarExperienciaLaboral(expLab.getId_exp());
        if (nva != null) {
            nva.setCargo(expLab.getCargo());
            nva.setEmpresa(expLab.getEmpresa());
            nva.setLogo_Empresa(expLab.getLogo_Empresa());
            nva.setFecha_inicio(expLab.getFecha_inicio());
            nva.setFecha_fin(expLab.getFecha_fin());
            nva.setDescripcion(expLab.getDescripcion());
            nva.setPersona(expLab.getPersona());
            expService.modificarExperienciaLaboral(nva);
        }
    }

}
