package com.portfolio.TF.controller;

import com.portfolio.TF.entity.Tecnologias;
import com.portfolio.TF.service.TecnologiaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tecno")
@CrossOrigin(origins = "http://localhost:4200")
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
    
    @PostMapping("/nueva")
    public void agregarTecnologia(@RequestBody Tecnologias tecno) {
        tecnoService.crearTecnologia(tecno);
    }
    
    @DeleteMapping("/borrar/{id}")
    public void borrarTecnologia(@PathVariable int id) {
        tecnoService.borrarTecnologia(id);
    }
    
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
