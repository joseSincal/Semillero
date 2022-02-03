package com.prac2.practica2.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class CompaniaSeguroDto implements Serializable {

	private static final long serialVersionUID = -928980876996383296L;
	
	private Integer id;
	private Integer numeroPoliza;
	private String nombreCompania;
	
}
