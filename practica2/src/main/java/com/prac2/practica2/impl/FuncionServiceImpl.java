package com.prac2.practica2.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.prac2.practica2.dto.SeguroDto;
import com.prac2.practica2.service.FuncionService;
import com.prac2.practica2.ws.FuncionServiceInterface;

@Component
public class FuncionServiceImpl implements FuncionServiceInterface {
	
	@Autowired
	FuncionService funcionService;

	@Override
	public int crearPoliza(SeguroDto seguroDto) {
		return funcionService.crearPoliza(seguroDto);
	}

}
