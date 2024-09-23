package com.prestamo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prestamo.entity.Pais;
import com.prestamo.kafka.service.PaisEventService;
import com.prestamo.repository.PaisRepository;

@Service
public class PaisServiceImpl implements PaisService {

	@Autowired
	private PaisRepository paisRepository;
	
	@Autowired
	private PaisEventService paisEventService;
	
	@Override
	public List<Pais> findAll() {
		return paisRepository.findAll();
	}

	@Override
	public Pais insertaPais(Pais pais) {
		paisEventService.publish(pais);//Publica el evento en kafka
		return paisRepository.save(pais);//Registra en la base de datos
	}

}
