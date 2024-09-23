package com.prestamo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prestamo.entity.Catalogo;

public interface CatalogoRepository extends JpaRepository<Catalogo, Integer> {

}
