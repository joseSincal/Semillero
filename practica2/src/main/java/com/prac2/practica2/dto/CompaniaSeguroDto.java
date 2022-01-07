package com.prac2.practica2.dto;

import java.io.Serializable;

public class CompaniaSeguroDto implements Serializable {

	private static final long serialVersionUID = -928980876996383296L;
	
	private Integer id;
	private Integer numeroPoliza;
	private String nombreCompania;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getNumeroPoliza() {
		return numeroPoliza;
	}
	public void setNumeroPoliza(Integer numeroPoliza) {
		this.numeroPoliza = numeroPoliza;
	}
	public String getNombreCompania() {
		return nombreCompania;
	}
	public void setNombreCompania(String nombreCompania) {
		this.nombreCompania = nombreCompania;
	}

}
