package com.prac2.practica2.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class PeritoDto implements Serializable {

	private static final long serialVersionUID = 5841769559807637287L;
	
	private Integer dniPerito;
	private String nombrePerito;
	private String apellidoPerito1;
	private String apellidoPerito2;
	private Integer telefonoContacto;
	private Integer telefonoOficina;
	private String claseVia;
	private String nombreVia;
	private Integer numeroVia;
	private Integer codPostal;
	private String ciudad;
	
}
