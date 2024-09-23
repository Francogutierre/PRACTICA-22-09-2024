package com.prestamo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prestamo.entity.Catalogo;
import com.prestamo.service.CatalogoService;

@RestController
@RequestMapping("/url/catalogo")
public class CatalogoController {

    @Autowired
    private CatalogoService catalogoService;

    @GetMapping("/lista")
    public List<Catalogo> getAllCatalogos() {
        return catalogoService.findAll();
    }
    
    @PostMapping("/inserta")
    public Catalogo insertaCatalogo(@RequestBody Catalogo catalogo) {
        return catalogoService.insertaCatalogo(catalogo);
    }
}
