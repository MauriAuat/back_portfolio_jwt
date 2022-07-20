package com.portfolio.TF.controller;

import com.portfolio.TF.entity.Educacion;
import com.portfolio.TF.service.EducacionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/edu")
@CrossOrigin(origins = "http://localhost:4200")
public class EducacionController {

    @Autowired
    private EducacionService eduService;

    @GetMapping("/{id}")
    @ResponseBody
    public Educacion verEducacion(@PathVariable int id) {
        return eduService.buscarEducacion(id);
    }

    @GetMapping("/mostrar-lista")
    @ResponseBody
    public List<Educacion> verEducaciones() {
        return eduService.mostrarEducacion();
    }

    @PostMapping("/nueva")
    public void agregarEducacion(@RequestBody Educacion edu) {
        eduService.crearEducacion(edu);
    }

    @DeleteMapping("/borrar/{id}")
    public void borrarEducacion(@PathVariable int id) {
        eduService.borrarEducacion(id);
    }

    @PutMapping("/editar")
    public void editarEducacion(@RequestBody Educacion edu) {
        Educacion nva = eduService.buscarEducacion(edu.getId_edu());
        if (nva != null) {
            nva.setNombre_inst(edu.getNombre_inst());
            nva.setLogo_inst(edu.getLogo_inst());
            nva.setTitulo(edu.getTitulo());
            nva.setFecha_ingreso(edu.getFecha_ingreso());
            nva.setFecha_egreso(edu.getFecha_egreso());
            eduService.modificarEducacion(nva);
        }
    }

}
