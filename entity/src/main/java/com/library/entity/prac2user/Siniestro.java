package com.library.entity.prac2user;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "SINIESTRO")
@Data
public class Siniestro implements Serializable {

	private static final long serialVersionUID = 9186095604245156748L;
	
	@Id
	@Column(name = "ID_SINIESTRO")
	private Integer idSiniestro;
	
	@Column(name = "FECHA_SINIESTRO")
	private String fechaSiniestro;
	
	@Column(name = "CAUSA")
	private String causa;
	
	@Column(name = "ACEPTADO")
	private String aceptado;
	
	@Column(name = "INDEMNIZACION")
	private Double indemnizacion;
	
	@Column(name = "NUMERO_POLIZA")
	private Integer numeroPoliza;
	
	@ManyToOne
	@JoinColumn(name = "DNI_PERITO")
	private Perito perito;

}
