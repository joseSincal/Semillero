package com.prac2.practica2.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.prac2.practica2.dto.SeguroDto;
import com.prac2.practica2.service.FuncionService;
import com.prac2.practica2.ws.FuncionServiceInterface;

@Component
public class FuncionServiceImpl implements FuncionServiceInterface {
	
	@Autowired
	FuncionService funcionService;
	
	private static final Log LOG = LogFactory.getLog(FuncionServiceImpl.class);

	@Override
	public ResponseEntity<Integer> crearPoliza(SeguroDto seguroDto) {
		try {
			return ResponseEntity.ok().body(funcionService.crearPoliza(seguroDto));
		} catch(Exception ex) {
			LOG.error("HUBO UN ERROR DE PERSISTENCIA DE DATOS: " + ex);
			return ResponseEntity.internalServerError().body(null);
		}
	}

}
