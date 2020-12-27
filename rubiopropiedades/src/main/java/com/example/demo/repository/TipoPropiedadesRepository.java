package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.models.TipoPropiedades;

public interface TipoPropiedadesRepository extends CrudRepository<TipoPropiedades, Integer>{

	Optional<TipoPropiedades> findByNombre(String nombre);
}
