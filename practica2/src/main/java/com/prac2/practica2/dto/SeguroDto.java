package com.prac2.practica2.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class SeguroDto implements Serializable {

	private static final long serialVersionUID = 6419753653042645610L;
	
	private Integer numeroPoliza;
	private String ramo;
	private String fechaInicio;
	private String fechaVencimiento;
	private String condicionParticular;
	private String observacion;
	private Integer dniCl;

}
