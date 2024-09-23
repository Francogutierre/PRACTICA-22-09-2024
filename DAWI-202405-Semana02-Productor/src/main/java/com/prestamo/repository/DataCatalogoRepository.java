package com.prestamo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.prestamo.entity.DataCatalogo;

public interface DataCatalogoRepository  extends JpaRepository<DataCatalogo, Integer>{
	
	@Query("Select d from DataCatalogo d where d.catalogo.idCatalogo = ?1")
	public List<DataCatalogo> listaPorCatalogo(int idCatalogo);
	
}
