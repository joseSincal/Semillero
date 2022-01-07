package com.prac2.practica2.dto;

import java.io.Serializable;

public class SeguroDto implements Serializable {

	private static final long serialVersionUID = 6419753653042645610L;
	
	private Integer numeroPoliza;
	private String ramo;
	private String fechaInicio;
	private String fechaVencimiento;
	private String condicionParticular;
	private String observacion;
	private Integer dniCl;
	
	public Integer getNumeroPoliza() {
		return numeroPoliza;
	}
	public void setNumeroPoliza(Integer numeroPoliza) {
		this.numeroPoliza = numeroPoliza;
	}
	public String getRamo() {
		return ramo;
	}
	public void setRamo(String ramo) {
		this.ramo = ramo;
	}
	public String getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public String getFechaVencimiento() {
		return fechaVencimiento;
	}
	public void setFechaVencimiento(String fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}
	public String getCondicionParticular() {
		return condicionParticular;
	}
	public void setCondicionParticular(String condicionParticular) {
		this.condicionParticular = condicionParticular;
	}
	public String getObservacion() {
		return observacion;
	}
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	public Integer getDniCl() {
		return dniCl;
	}
	public void setDniCl(Integer dniCl) {
		this.dniCl = dniCl;
	}

}
