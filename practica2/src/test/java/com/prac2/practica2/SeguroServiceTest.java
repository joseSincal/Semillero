package com.prac2.practica2;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.prac2.practica2.dto.SeguroDto;
import com.prac2.practica2.entity.Seguro;
import com.prac2.practica2.impl.SeguroService;

@SpringBootTest
class SeguroServiceTest {

	@Autowired
	SeguroService seguroService;
	
	@Test
	void buscar() {
		List<Seguro> seguros = seguroService.buscar();
		assertNotNull(seguros, "Los seguros no están cargados");
	}
	
	@Test
	void guardar() {
		SeguroDto seguroDto = new SeguroDto();
		seguroDto.setNumeroPoliza(0);
		Seguro seguro = seguroService.guardar(seguroDto).getBody();
		assertNotNull(seguro, "El seguro no se guardó");
	}
	
	@Test
	void eliminar() {
		try {
			seguroService.eliminar(0);
			assert(true);
		}
		catch (Exception ex) {
			fail("Dio error: " + ex.getMessage());
		}
	}
	
}
