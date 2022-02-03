package com.prac2.practica2.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class ClienteDto implements Serializable {

	private static final long serialVersionUID = -5600905142391045509L;
	
	private Integer dniCl;
	private String nombreCl;
	private String apellido1;
	private String apellido2;
	private String claseVia;
	private String nombreVia;
	private Integer numeroVia;
	private Integer codPostal;
	private String ciudad;
	private Integer telefono;
	private String observacion;

}
