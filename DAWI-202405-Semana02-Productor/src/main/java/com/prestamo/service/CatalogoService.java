package com.prestamo.service;

import java.util.List;

import com.prestamo.entity.Catalogo;

public interface CatalogoService {
	
	 public List<Catalogo> findAll();
	    
	 public Catalogo insertaCatalogo(Catalogo catalogo);

}
