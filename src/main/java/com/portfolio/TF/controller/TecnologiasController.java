package com.portfolio.TF.controller;

import com.portfolio.TF.entity.Tecnologias;
import com.portfolio.TF.service.TecnologiaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tecno")
@CrossOrigin(origins = "https://portfolio-web-3d440.web.app")
public class TecnologiasController {
    
    @Autowired
    private TecnologiaService tecnoService;
    
    @GetMapping("/{id}")
    @ResponseBody
    public Tecnologias verTecnologia(@PathVariable int id) {
        return tecnoService.buscarTecnologia(id);
    }
    
    @GetMapping("/mostrar-lista")
    @ResponseBody
    public List<Tecnologias> verTecnologias() {
        return tecnoService.mostrarTecnologias();
    }
 
    @PreAuthorize("hasRole('ADMIN')")   
    @PostMapping("/nueva")
    public void agregarTecnologia(@RequestBody Tecnologias tecno) {
        tecnoService.crearTecnologia(tecno);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/borrar/{id}")
    public void borrarTecnologia(@PathVariable int id) {
        tecnoService.borrarTecnologia(id);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/editar")
    public void editarTecnologia(@RequestBody Tecnologias tecno) {
        Tecnologias nva = tecnoService.buscarTecnologia(tecno.getId_tecno());
        if (nva != null) {
            nva.setNombre_tecno(tecno.getNombre_tecno());
            nva.setNivel(tecno.getNivel());
            tecnoService.modificarTecnologia(nva);
        }
    }
}
