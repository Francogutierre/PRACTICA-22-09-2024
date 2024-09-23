package com.prestamo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prestamo.entity.Pais;
import com.prestamo.service.PaisService;

@RestController
@RequestMapping("/url/pais")
public class PaisController {

	@Autowired
    private PaisService paisService;


    @GetMapping("/lista")
    public List<Pais> getAllPaises() {
        return paisService.findAll();
    }
    
    @PostMapping("/inserta")
	public Pais insertaPais(@RequestBody Pais pais) {
		return paisService.insertaPais(pais);
	}
    
}
