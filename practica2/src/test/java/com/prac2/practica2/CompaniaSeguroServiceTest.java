package com.prac2.practica2;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.library.entity.prac2user.CompaniaSeguro;
import com.prac2.practica2.dto.CompaniaSeguroDto;
import com.prac2.practica2.impl.CompaniaSeguroService;

@SpringBootTest
class CompaniaSeguroServiceTest {
	
	@Autowired
	CompaniaSeguroService companiaSeguroService;
	
	@Test
	void buscar() {
		List<CompaniaSeguro> companiaSeguros = companiaSeguroService.buscar();
		assertNotNull(companiaSeguros, "Los detalle de Compania-Seguro no están cargados");
	}
	
	@Test
	void guardar() {
		CompaniaSeguroDto companiaSeguroDto = new CompaniaSeguroDto();
		companiaSeguroDto.setId(0);
		CompaniaSeguro companiaSeguro = companiaSeguroService.guardar(companiaSeguroDto);
		assertNotNull(companiaSeguro, "No se está guardando el detalle");
	}
	
	@Test
	void eliminar() {
		try {
			companiaSeguroService.eliminar(0);
			assert(true);
		}
		catch (Exception ex) {
			fail("Dio error: " + ex.getMessage());
		}
	}

}
