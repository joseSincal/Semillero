package com.prac2.practica2.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "COMPANIA_SEGURO")
@Data
public class CompaniaSeguro implements Serializable {

	private static final long serialVersionUID = -9106333635452866183L;
	
	@Id
	@Column(name = "ID")
	private Integer id;
	
	@Column(name = "NUMERO_POLIZA")
	private Integer numeroPoliza;
	
	@Column(name = "NOMBRE_COMPANIA")
	private String nombreCompania;

}
