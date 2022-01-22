package com.library.entity.prac2user;

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

@Entity
@Table(name = "COMPANIA")
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

	public String getNombreCompania() {
		return nombreCompania;
	}

	public void setNombreCompania(String nombreCompania) {
		this.nombreCompania = nombreCompania;
	}

	public String getClaseVia() {
		return claseVia;
	}

	public void setClaseVia(String claseVia) {
		this.claseVia = claseVia;
	}

	public Integer getNumeroVia() {
		return numeroVia;
	}

	public void setNumeroVia(Integer numeroVia) {
		this.numeroVia = numeroVia;
	}

	public Integer getCodPostal() {
		return codPostal;
	}

	public void setCodPostal(Integer codPostal) {
		this.codPostal = codPostal;
	}

	public Integer getTelefonoContratacion() {
		return telefonoContratacion;
	}

	public void setTelefonoContratacion(Integer telefonoContratacion) {
		this.telefonoContratacion = telefonoContratacion;
	}

	public Integer getTelefonoSiniestro() {
		return telefonoSiniestro;
	}

	public void setTelefonoSiniestro(Integer telefonoSiniestro) {
		this.telefonoSiniestro = telefonoSiniestro;
	}

	public String getNota() {
		return nota;
	}

	public void setNota(String nota) {
		this.nota = nota;
	}

	public List<Seguro> getSeguros() {
		return seguros;
	}

	public void setSeguros(List<Seguro> seguros) {
		this.seguros = seguros;
	}
	
}
