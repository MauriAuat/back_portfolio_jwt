package com.portfolio.TF.controller;

import com.portfolio.TF.entity.Proyectos;
import com.portfolio.TF.service.ProyectoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/project")
@CrossOrigin(origins = "http://localhost:4200")

public class ProyectosController {

    @Autowired
    private ProyectoService proService;

    @GetMapping("/{id}")
    @ResponseBody
    public Proyectos verProyecto(@PathVariable int id) {
        return proService.buscarProyecto(id);
    }

    @GetMapping("/mostrar-lista")
    @ResponseBody
    public List<Proyectos> verProyectos() {
        return proService.mostrarProyectos();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/nuevo")
    public void agregarProyecto(@RequestBody Proyectos proyect) {

        proService.crearProyecto(proyect);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/borrar/{id}")
    public void borrarProyecto(@PathVariable int id) {
        proService.borrarProyecto(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/editar")
    public void editarProyecto(@RequestBody Proyectos proyect) {
        Proyectos nvo = proService.buscarProyecto(proyect.getId_proyecto());
        if (nvo != null) {
            nvo.setNombre_proyecto(proyect.getNombre_proyecto());
            nvo.setFecha_activo(proyect.getFecha_activo());
            nvo.setDescripcion(proyect.getDescripcion());
            nvo.setLink_proyecto(proyect.getLink_proyecto());
            nvo.setImagen_muestra(proyect.getImagen_muestra());
            //nvo.setPersona(proyect.getPersona());
            proService.modificarProyecto(nvo);
        }

    }

}
