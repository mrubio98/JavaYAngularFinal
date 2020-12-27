package com.example.demo.models;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

@Entity
public class TipoPropiedades {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@NotEmpty
	@Length(max=50)
	private String nombre;
	
	@OneToMany(mappedBy="tipoPropiedad")
	Set<Propiedad> propiedades;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Set<Propiedad> getPropiedades() {
		return propiedades;
	}
	public void setPropiedades(Set<Propiedad> propiedades) {
		this.propiedades = propiedades;
	}
}
