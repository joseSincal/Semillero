package com.prac2.practica2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PeritoSiniestroCantidadDto {

	private Integer dniPerito;
	private String nombrePerito;
	private Long cantidadSiniestro;
	
}
