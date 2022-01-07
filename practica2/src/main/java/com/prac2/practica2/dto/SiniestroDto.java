package com.prac2.practica2.dto;

import java.io.Serializable;

public class SiniestroDto implements Serializable {

	private static final long serialVersionUID = 6941910196829579798L;
	
	private Integer idSiniestro;
	private String fechaSiniestro;
	private String causa;
	private String aceptado;
	private Double indemnizacion;
	private Integer numeroPoliza;
	
	public Integer getIdSiniestro() {
		return idSiniestro;
	}
	public void setIdSiniestro(Integer idSiniestro) {
		this.idSiniestro = idSiniestro;
	}
	public String getFechaSiniestro() {
		return fechaSiniestro;
	}
	public void setFechaSiniestro(String fechaSiniestro) {
		this.fechaSiniestro = fechaSiniestro;
	}
	public String getCausa() {
		return causa;
	}
	public void setCausa(String causa) {
		this.causa = causa;
	}
	public String getAceptado() {
		return aceptado;
	}
	public void setAceptado(String aceptado) {
		this.aceptado = aceptado;
	}
	public Double getIndemnizacion() {
		return indemnizacion;
	}
	public void setIndemnizacion(Double indemnizacion) {
		this.indemnizacion = indemnizacion;
	}
	public Integer getNumeroPoliza() {
		return numeroPoliza;
	}
	public void setNumeroPoliza(Integer numeroPoliza) {
		this.numeroPoliza = numeroPoliza;
	}

}
