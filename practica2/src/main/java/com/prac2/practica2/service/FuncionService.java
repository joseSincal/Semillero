package com.prac2.practica2.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Service;

import com.prac2.practica2.dto.SeguroDto;

@Service
public class FuncionService {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public int crearPoliza(SeguroDto seguroDto) {
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate);
		simpleJdbcCall.withCatalogName("pkg_semillero_functions")
			.withFunctionName("creaPoliza_function");
		
		SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
				.addValue("s_numero_poliza", seguroDto.getNumeroPoliza())
				.addValue("s_ramo", seguroDto.getRamo())
				.addValue("s_fecha_inicio", seguroDto.getFechaInicio())
				.addValue("s_fecha_vencimiento", seguroDto.getFechaVencimiento())
				.addValue("s_condicion_particular", seguroDto.getCondicionParticular())
				.addValue("s_observacion", seguroDto.getObservacion())
				.addValue("s_dni_cl", seguroDto.getDniCl());
		
		return simpleJdbcCall.executeFunction(BigDecimal.class, sqlParameterSource).intValue();
	}

}
