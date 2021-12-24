package com.prac2.practica2.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "SINIESTRO") 
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
	
	public Integer getIdSiniestro() {
		return idSiniestro;
	}

	public void setIdSiniestro(Integer idSiniestro) {
		this.idSiniestro = idSiniestro;
	}

	public String getFechaSiniestro() {
		return fechaSiniestro;
	}

	public void setFechaSiniestro(String fechaSiniestro) {
		this.fechaSiniestro = fechaSiniestro;
	}

	public String getCausa() {
		return causa;
	}

	public void setCausa(String causa) {
		this.causa = causa;
	}

	public String getAceptado() {
		return aceptado;
	}

	public void setAceptado(String aceptado) {
		this.aceptado = aceptado;
	}

	public Double getIndemnizacion() {
		return indemnizacion;
	}

	public void setIndemnizacion(Double indemnizacion) {
		this.indemnizacion = indemnizacion;
	}

	public Integer getNumeroPoliza() {
		return numeroPoliza;
	}

	public void setNumeroPoliza(Integer numeroPoliza) {
		this.numeroPoliza = numeroPoliza;
	}

	public Perito getPerito() {
		return perito;
	}

	public void setPerito(Perito perito) {
		this.perito = perito;
	}

}
