package com.prestamo.service;

import java.util.List;

import com.prestamo.entity.Pais;

public interface PaisService {

	public List<Pais> findAll();
	
	public Pais insertaPais(Pais pais);
	
}
