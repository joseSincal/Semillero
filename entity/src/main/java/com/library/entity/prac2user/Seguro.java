package com.library.entity.prac2user;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "SEGURO")
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

	public Integer getNumeroPoliza() {
		return numeroPoliza;
	}

	public void setNumeroPoliza(Integer numeroPoliza) {
		this.numeroPoliza = numeroPoliza;
	}

	public String getRamo() {
		return ramo;
	}

	public void setRamo(String ramo) {
		this.ramo = ramo;
	}

	public String getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(String fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public String getCondicionParticular() {
		return condicionParticular;
	}

	public void setCondicionParticular(String condicionParticular) {
		this.condicionParticular = condicionParticular;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public Integer getDniCl() {
		return dniCl;
	}

	public void setDniCl(Integer dniCl) {
		this.dniCl = dniCl;
	}

	public List<Compania> getCompanias() {
		return companias;
	}

	public void setCompanias(List<Compania> companias) {
		this.companias = companias;
	}

}
