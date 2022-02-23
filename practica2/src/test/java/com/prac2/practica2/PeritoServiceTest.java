package com.prac2.practica2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.prac2.practica2.dto.PeritoDto;
import com.prac2.practica2.entity.Perito;
import com.prac2.practica2.impl.PeritoService;
import com.prac2.practica2.impl.SiniestroService;

@SpringBootTest
class PeritoServiceTest {
	
	@Autowired
	PeritoService peritoService;
	
	@Autowired
	SiniestroService siniestroService;
	
	@Test
	void buscar() {
		List<Perito> peritos = peritoService.buscar();
		assertNotNull(peritos, "Los clientes no están cargados");
	}
	
	@Test
	void buscar2() {
		List<Perito> peritos = peritoService.buscar("Sincal", "Barcelona");
		int size = peritos.size();
		assertEquals(0, size, "Si existen peritos con esos parámetros");
	}
	
	@Test
	void buscar3() {
		List<Perito> peritos = peritoService.buscar("y");
		assertNotNull(peritos, "No existen peritos que contengan ese parámetro en sus apellidos");
	}
	
	@Test
	void buscarInicialNombre() {
		List<Perito> peritos = peritoService.buscarInicialNombre("V");
		int size = peritos.size();
		assertEquals(1, size, "Validación nombreInicial test encontrado");
	}
	
	@Test
	void buscarNumeroVia() {
		List<Perito> peritos = peritoService.buscarNumeroVia(1);
		int size = peritos.size();
		assertEquals(0, size, "Validación buscarNumeroVia test encontrado");
	}
	
	@Test
	void guardar() {
		PeritoDto peritoDto = new PeritoDto();
		peritoDto.setDniPerito(0);
		Perito perito = peritoService.guardar(peritoDto).getBody();
		assertEquals(0, perito.getDniPerito());
	}
	
	@Test
	void eliminar() {
		try {
			siniestroService.eliminar(0);
			peritoService.eliminar(0);
			assert(true);
		}
		catch (Exception ex) {
			fail("Dio error: " + ex.getMessage());
		}
	}

}
