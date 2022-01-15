package com.prac2.practica2.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.prac2.practica2.dto.ProcedimientoDto;
import com.prac2.practica2.service.ProcedimientoService;
import com.prac2.practica2.ws.ProcedimientoServiceInterface;

@Component
public class ProcedimientoServiceImpl implements ProcedimientoServiceInterface {
	
	@Autowired
	ProcedimientoService procedimientoService;

	@Override
	public int eliminarSiniestro(int id) {
		return procedimientoService.eliminarSiniestro(id);
	}

	@Override
	public ProcedimientoDto cambiarIndemnizacion(int id, int indemnizacion) {
		return procedimientoService.cambiarIndemnizacion(id, indemnizacion);
	}

}
