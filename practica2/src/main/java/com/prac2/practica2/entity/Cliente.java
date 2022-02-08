package com.prac2.practica2.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "CLIENTE")
@Data
public class Cliente implements Serializable {

	private static final long serialVersionUID = -734125466730897367L;
	
	@SequenceGenerator(
			sequenceName = "cliente_seq",
			allocationSize = 1,
			name = "CLI_SEQ"
	)
	@Id
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "CLI_SEQ"
	)
	@Column(name = "DNI_CL")
	private Integer dniCl;
	
	@Column(name = "NOMBRE_CL")
	private String nombreCl;
	
	@Column(name = "APELLIDO_1")
	private String apellido1;
	
	@Column(name = "APELLIDO_2")
	private String apellido2;
	
	@Column(name = "CLASE_VIA")
	private String claseVia;
	
	@Column(name = "NOMBRE_VIA")
	private String nombreVia;
	
	@Column(name = "NUMERO_VIA")
	private Integer numeroVia;
	
	@Column(name = "COD_POSTAL")
	private Integer codPostal;
	
	@Column(name = "CIUDAD")
	private String ciudad;
	
	@Column(name = "TELEFONO")
	private Integer telefono;
	
	@Column(name = "OBSERVACION")
	private String observacion;
	
	@OneToMany(mappedBy = "dniCl")
	private List<Seguro> seguroList;

}
