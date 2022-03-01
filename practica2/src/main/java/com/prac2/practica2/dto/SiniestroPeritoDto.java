package com.prac2.practica2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SiniestroPeritoDto {

	private String fechaSiniestro;
	private String causa;
	private Double indemnizacion;
	private Integer dniPerito;
	private String nombrePerito;
}
