package com.prac2.practica2.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class CompaniaDto implements Serializable {

	private static final long serialVersionUID = -5839972257835868694L;
	
	private String nombreCompania;
	private String claseVia;
	private Integer numeroVia;
	private Integer codPostal;
	private Integer telefonoContratacion;
	private Integer telefonoSiniestro;
	private String nota;

}
