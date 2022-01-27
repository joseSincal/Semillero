package com.prac2.practica2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.prac2.practica2.dto.ProcedimientoDto;
import com.prac2.practica2.dto.SiniestroDto;
import com.prac2.practica2.impl.ProcedimientoServiceImpl;
import com.prac2.practica2.impl.SiniestroService;

@SpringBootTest
class ProcedimientoServiceImplTest {
	
	@Autowired
	ProcedimientoServiceImpl procedimientoServiceImpl;
	
	@Autowired
	SiniestroService siniestroService;
	
	@Test
	void eliminarSiniestro() {
		int siniestro = procedimientoServiceImpl.eliminarSiniestro(0);
		assertEquals(1, siniestro, "No se eliminó");
	}
	
	@Test
	void cambiarIndemnizacion() {
		SiniestroDto siniestroDto = new SiniestroDto();
		siniestroDto.setIdSiniestro(0);
		siniestroDto.setIndemnizacion(10.00);
		siniestroService.guardar(siniestroDto);
		
		ProcedimientoDto procedimientoDto = procedimientoServiceImpl.cambiarIndemnizacion(0, 1);
		
		assertNotNull(procedimientoDto, "Problemas con el cambio de indemnizacion");
		siniestroService.eliminar(0);
	}


}
