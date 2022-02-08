package com.prac2.practica2.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Table(name = "COMPANIA")
@Data
public class Compania implements Serializable {

	private static final long serialVersionUID = -8041927682973653377L;
	
	@Id
	@Column(name = "NOMBRE_COMPANIA")
	private String nombreCompania;
	
	@Column(name = "CLASE_VIA")
	private String claseVia;
	
	@Column(name = "NUMERO_VIA")
	private Integer numeroVia;
	
	@Column(name = "COD_POSTAL")
	private Integer codPostal;
	
	@Column(name = "TELEFONO_CONTRATACION")
	private Integer telefonoContratacion;
	
	@Column(name = "TELEFONO_SINIESTRO")
	private Integer telefonoSiniestro;
	
	@Column(name = "NOTA")
	private String nota;
	
	@ManyToMany
	@JoinTable(
			name = "COMPANIA_SEGURO",
			joinColumns = @JoinColumn(name = "NOMBRE_COMPANIA"),
			inverseJoinColumns = @JoinColumn(name = "NUMERO_POLIZA")
	)
	@JsonIgnore
	private List<Seguro> seguros;

}
