package com.prac2.practica2.service;

import java.sql.Types;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlInOutParameter;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Service;

import com.prac2.practica2.dto.ProcedimientoDto;

@Service
public class ProcedimientoService {
	
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	private static final String INDEM = "indem";

	public int eliminarSiniestro(int id) {
		String query = "begin "
				+ "eliminarSiniestro_Procedure(:id); "
				+ "end;";
		SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
				.addValue("id", id);
		return namedParameterJdbcTemplate.update(query, sqlParameterSource);
	}

	public ProcedimientoDto cambiarIndemnizacion(int id, int indemnizacion) {
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate);
		simpleJdbcCall.withProcedureName("cambiarIndemnizacion_Procedure")
			.withoutProcedureColumnMetaDataAccess().declareParameters(
					new SqlParameter("cod", Types.NUMERIC),
					new SqlInOutParameter(INDEM, Types.NUMERIC),
					new SqlOutParameter("antiguo", Types.NUMERIC)
				);
		
		SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
				.addValue("cod", id)
				.addValue(INDEM, indemnizacion);
		
		Map<String, Object> out = simpleJdbcCall.execute(sqlParameterSource);
		
		ProcedimientoDto procedimientoDto = new ProcedimientoDto();
		procedimientoDto.setNuevaIndemnizacion(Integer.parseInt(out.get(INDEM).toString()));
		procedimientoDto.setAntiguaIndemizacion(Integer.parseInt(out.get("antiguo").toString()));
		
		return procedimientoDto;
	}

}
