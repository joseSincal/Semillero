package com.prac2.practica2.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class SiniestroDto implements Serializable {

	private static final long serialVersionUID = 6941910196829579798L;
	
	private Integer idSiniestro;
	private String fechaSiniestro;
	private String causa;
	private String aceptado;
	private Double indemnizacion;
	private Integer numeroPoliza;

}
