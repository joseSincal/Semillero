package com.prac2.practica2.dto;

import java.io.Serializable;

public class ProcedimientoDto implements Serializable {

	private static final long serialVersionUID = 610421058446860943L;
	
	private Integer nuevaIndemnizacion;
	private Integer antiguaIndemizacion;
	
	public Integer getNuevaIndemnizacion() {
		return nuevaIndemnizacion;
	}
	
	public void setNuevaIndemnizacion(Integer nuevaIndemnizacion) {
		this.nuevaIndemnizacion = nuevaIndemnizacion;
	}
	
	public Integer getAntiguaIndemizacion() {
		return antiguaIndemizacion;
	}
	
	public void setAntiguaIndemizacion(Integer antiguaIndemizacion) {
		this.antiguaIndemizacion = antiguaIndemizacion;
	}

}
