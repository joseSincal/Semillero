package com.prac2.practica2.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class ProcedimientoDto implements Serializable {

	private static final long serialVersionUID = 610421058446860943L;
	
	private Integer nuevaIndemnizacion;
	private Integer antiguaIndemizacion;
	
}
