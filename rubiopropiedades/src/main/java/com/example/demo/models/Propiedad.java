package com.example.demo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.example.demo.dto.PropiedadDto;

@Entity
public class Propiedad {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@NotEmpty
	@Length(max=50)
	private String titulo;
	@NotEmpty
	@Length(max=250)
	private String descripcion;
	@NotEmpty
	@Length(max=50)
	private String direccion;
	@ManyToOne()
	@JoinColumn(name="tipo_propiedad_id", nullable = false)
	private TipoPropiedades tipoPropiedad;
	@NotEmpty
	@Length(max=20)
	private String tipoOperacion;
	@NotEmpty
	@Length(max=5)
	private String unidadMonetaria;
	@NotNull
	private int valor;
	@NotNull
	private int supTotal;
	private int supCub;
	private int supSemi;
	private int supDes;
	private int ambientes;
	private int banos;
	private int toilettes;
	private int antiguedad;
	private int plantas;
	private boolean aptoCredito;
	private boolean aptoProfesional;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public TipoPropiedades getTipoPropiedad() {
		return tipoPropiedad;
	}
	public void setTipoPropiedad(TipoPropiedades tipoPropiedad) {
		this.tipoPropiedad = tipoPropiedad;
	}
	public String getTipoOperacion() {
		return tipoOperacion;
	}
	public void setTipoOperacion(String tipoOperacion) {
		this.tipoOperacion = tipoOperacion;
	}
	public String getUnidadMonetaria() {
		return unidadMonetaria;
	}
	public void setUnidadMonetaria(String unidadMonetaria) {
		this.unidadMonetaria = unidadMonetaria;
	}
	public int getValor() {
		return valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
	}
	public int getSupTotal() {
		return supTotal;
	}
	public void setSupTotal(int supTotal) {
		this.supTotal = supTotal;
	}
	public int getSupCub() {
		return supCub;
	}
	public void setSupCub(int supCub) {
		this.supCub = supCub;
	}
	public int getSupSemi() {
		return supSemi;
	}
	public void setSupSemi(int supSemi) {
		this.supSemi = supSemi;
	}
	public int getSupDes() {
		return supDes;
	}
	public void setSupDes(int supDes) {
		this.supDes = supDes;
	}
	public int getAmbientes() {
		return ambientes;
	}
	public void setAmbientes(int ambientes) {
		this.ambientes = ambientes;
	}
	public int getBanos() {
		return banos;
	}
	public void setBanos(int banos) {
		this.banos = banos;
	}
	public int getToilettes() {
		return toilettes;
	}
	public void setToilettes(int toilettes) {
		this.toilettes = toilettes;
	}
	public int getAntiguedad() {
		return antiguedad;
	}
	public void setAntiguedad(int antiguedad) {
		this.antiguedad = antiguedad;
	}
	public int getPlantas() {
		return plantas;
	}
	public void setPlantas(int plantas) {
		this.plantas = plantas;
	}
	public boolean isAptoCredito() {
		return aptoCredito;
	}
	public void setAptoCredito(boolean aptoCredito) {
		this.aptoCredito = aptoCredito;
	}
	public boolean isAptoProfesional() {
		return aptoProfesional;
	}
	public void setAptoProfesional(boolean aptoProfesional) {
		this.aptoProfesional = aptoProfesional;
	}
	public Propiedad() {
		super();
	}
	public Propiedad(PropiedadDto propiedad, TipoPropiedades tipo) {
		super();
		
		this.id = propiedad.getId();
		this.titulo = propiedad.getTitulo();
		this.descripcion = propiedad.getDescripcion();
		this.direccion = propiedad.getDireccion();
		this.tipoPropiedad = tipo;
		this.tipoOperacion = propiedad.getTipoOperacion();
		this.unidadMonetaria = propiedad.getUnidadMonetaria();
		this.valor = propiedad.getValor();
		this.supTotal = propiedad.getSupTotal();
		this.supCub = propiedad.getSupCub();
		this.supSemi = propiedad.getSupSemi();
		this.supDes = propiedad.getSupDes();
		this.ambientes = propiedad.getAmbientes();
		this.banos = propiedad.getBanos();
		this.toilettes = propiedad.getToilettes();
		this.antiguedad = propiedad.getAntiguedad();
		this.plantas = propiedad.getPlantas();
		this.aptoCredito = propiedad.isAptoCredito();
		this.aptoProfesional = propiedad.isAptoProfesional();
	}
}
