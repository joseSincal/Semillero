package com.prac2.practica2.dto;

import java.io.Serializable;

public class CompaniaDto implements Serializable {

	private static final long serialVersionUID = -5839972257835868694L;
	
	private String nombreCompania;
	private String claseVia;
	private Integer numeroVia;
	private Integer codPostal;
	private Integer telefonoContratacion;
	private Integer telefonoSiniestro;
	private String nota;
	
	public String getNombreCompania() {
		return nombreCompania;
	}
	public void setNombreCompania(String nombreCompania) {
		this.nombreCompania = nombreCompania;
	}
	public String getClaseVia() {
		return claseVia;
	}
	public void setClaseVia(String claseVia) {
		this.claseVia = claseVia;
	}
	public Integer getNumeroVia() {
		return numeroVia;
	}
	public void setNumeroVia(Integer numeroVia) {
		this.numeroVia = numeroVia;
	}
	public Integer getCodPostal() {
		return codPostal;
	}
	public void setCodPostal(Integer codPostal) {
		this.codPostal = codPostal;
	}
	public Integer getTelefonoContratacion() {
		return telefonoContratacion;
	}
	public void setTelefonoContratacion(Integer telefonoContratacion) {
		this.telefonoContratacion = telefonoContratacion;
	}
	public Integer getTelefonoSiniestro() {
		return telefonoSiniestro;
	}
	public void setTelefonoSiniestro(Integer telefonoSiniestro) {
		this.telefonoSiniestro = telefonoSiniestro;
	}
	public String getNota() {
		return nota;
	}
	public void setNota(String nota) {
		this.nota = nota;
	}

}
