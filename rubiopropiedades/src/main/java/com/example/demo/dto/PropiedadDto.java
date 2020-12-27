package com.example.demo.dto;

import com.example.demo.models.Propiedad;

public class PropiedadDto {
	
	private int id;
	private String titulo;
	private String descripcion;
	private String direccion;
	private String tipoPropiedad;
	private String tipoOperacion;
	private String unidadMonetaria;
	private int valor;
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
	public String getTipoPropiedad() {
		return tipoPropiedad;
	}
	public void setTipoPropiedad(String tipoPropiedad) {
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
	
	public PropiedadDto() {
		super();
		
	}
	public PropiedadDto( Propiedad propiedad) {
		super();
		
		this.id = propiedad.getId();
		this.titulo = propiedad.getTitulo();
		this.descripcion = propiedad.getDescripcion();
		this.direccion = propiedad.getDireccion();
		this.tipoPropiedad = propiedad.getTipoPropiedad().getNombre();
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
	
	public boolean check(int numeroCheck){
		Integer numero = numeroCheck;
		
		if(numero!=null && numero<0){
			return true;
		}
		else{
			return false;
		}
	}
}
