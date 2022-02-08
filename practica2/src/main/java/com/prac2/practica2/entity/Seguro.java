package com.prac2.practica2.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "SEGURO")
@Data
public class Seguro implements Serializable {

	private static final long serialVersionUID = 2773905565503025116L;
	
	@Id
	@Column(name = "NUMERO_POLIZA")
	private Integer numeroPoliza;
	
	@Column(name = "RAMO")
	private String ramo;
	
	@Column(name = "FECHA_INICIO")
	private String fechaInicio;
	
	@Column(name = "FECHA_VENCIMIENTO")
	private String fechaVencimiento;
	
	@Column(name = "CONDICION_PARTICULAR")
	private String condicionParticular;
	
	@Column(name = "OBSERVACION")
	private String observacion;
	
	@Column(name = "DNI_CL")
	private Integer dniCl;
	
	@ManyToMany(mappedBy = "seguros")
	private List<Compania> companias;

}
