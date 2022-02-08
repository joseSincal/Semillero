package com.prac2.practica2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.prac2.practica2.dto.SiniestroDto;
import com.prac2.practica2.entity.Siniestro;
import com.prac2.practica2.impl.SiniestroService;

@SpringBootTest
class SiniestroServiceTest {
	
	@Autowired
	SiniestroService siniestroService;
	
	@Test
	void buscar() {
		List<Siniestro> siniestros = siniestroService.buscar();
		assertNotNull(siniestros, "Los siniestros no están cargados");
	}
	
	@Test
	void buscarAceptado() {
		List<Siniestro> siniestros = siniestroService.buscarAceptado("no");
		assertNotNull(siniestros, "No hay indemnizaciones rechazadas");
	}
	
	@Test
	void buscarIndemnizacion() {
		List<Siniestro> siniestros = siniestroService.buscarIndemnizacion(5.0);
		int size = siniestros.size();
		assertEquals(0, size, "Hay siniestros con menor indemnizacion");
	}
	
	@Test
	void buscarIndemnizacion2() {
		List<Siniestro> siniestros = siniestroService.buscarIndemnizacion(5.0, 10.0);
		int size = siniestros.size();
		assertEquals(1, size, "Hay mas siniestros dentro de ese rango de indemnizaciones");
	}
	
	@Test
	void buscarPoliza() {
		List<Siniestro> siniestros = siniestroService.buscarPoliza(500);
		int size = siniestros.size();
		assertEquals(0, size, "Si existe una poliza con ese parámetro");
	}
	
	@Test
	void buscarPoliza2() {
		List<Siniestro> siniestros = siniestroService.buscarPoliza("11/21/2021", "no");
		int size = siniestros.size();
		assertEquals(0, size, "Si existe una poliza con esos parámetros");
	}
	
	@Test
	void guardar() {
		SiniestroDto siniestroDto = new SiniestroDto();
		siniestroDto.setIdSiniestro(0);
		Siniestro siniestro = siniestroService.guardar(siniestroDto);
		assertNotNull(siniestro, "El siniestro no se guardó");
	}
	
	@Test
	void agregarPerito() {
		try {
			siniestroService.agregarPerito(0, 0);
			assert(true);
		}
		catch (Exception ex) {
			fail("Dio error: " + ex.getMessage());
		}
	}
	
	@Test
	void eliminar() {
		try {
			siniestroService.eliminar(0);
			assert(true);
		}
		catch (Exception ex) {
			fail("Dio error: " + ex.getMessage());
		}
	}

}
