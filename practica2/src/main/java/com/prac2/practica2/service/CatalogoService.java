package com.prac2.practica2.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Service;

import com.prac2.practica2.dto.ClienteDto;

@Service
public class CatalogoService {
	
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	private static final String DNICL = "dniCl";
	
	public int guardarCliente(ClienteDto clienteDto) {
		String query = "insert into CLIENTE(DNI_CL, NOMBRE_CL, APELLIDO_1, APELLIDO_2, CLASE_VIA, NOMBRE_VIA,"
				+ "NUMERO_VIA, COD_POSTAL, CIUDAD, TELEFONO, OBSERVACION) values(:dniCl, :nombreCl, :apellido1, :apellido2,"
				+ ":claseVia, :nombreVia, :numeroVia, :codPostal, :ciudad, :telefono, :observacion)";
		SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
				.addValue(DNICL, clienteDto.getDniCl()).addValue("nombreCl", clienteDto.getNombreCl())
				.addValue("apellido1", clienteDto.getApellido1()).addValue("apellido2", clienteDto.getApellido2())
				.addValue("claseVia", clienteDto.getClaseVia()).addValue("nombreVia", clienteDto.getNombreVia())
				.addValue("numeroVia", clienteDto.getNumeroVia()).addValue("codPostal", clienteDto.getCodPostal())
				.addValue("ciudad", clienteDto.getCiudad()).addValue("telefono", clienteDto.getTelefono())
				.addValue("observacion", clienteDto.getObservacion());
		return namedParameterJdbcTemplate.update(query, sqlParameterSource);
	}
	
	public void cambiarNombreCliente(Integer dniCl, String nombre) {
		String query = "update CLIENTE set NOMBRE_CL = :nombre where DNI_CL = :dniCl";
		SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
				.addValue(DNICL, dniCl)
				.addValue("nombre", nombre);
		namedParameterJdbcTemplate.update(query, sqlParameterSource);
	}
	
	public void eliminarCliente(Integer dniCl) {
		String query = "delete from CLIENTE where DNI_CL = :dniCl";
		SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
				.addValue(DNICL, dniCl);
		namedParameterJdbcTemplate.update(query, sqlParameterSource);
	}
	
	public List<Map<String, Object>> buscarClientes() {
		String query = "select DNI_CL, NOMBRE_CL, APELLIDO_1, APELLIDO_2 from CLIENTE";
		SqlParameterSource sqlParameterSource = new MapSqlParameterSource();
		return namedParameterJdbcTemplate.queryForList(query, sqlParameterSource);
	}
	
	public List<Map<String, Object>> buscarCliente(Integer dniCl) {
		String query = "select DNI_CL, NOMBRE_CL, APELLIDO_1, APELLIDO_2 from CLIENTE where DNI_CL = :dniCl";
		SqlParameterSource sqlParameterSource = new MapSqlParameterSource().addValue(DNICL, dniCl);
		return namedParameterJdbcTemplate.queryForList(query, sqlParameterSource);
	}
	
	
	

}
