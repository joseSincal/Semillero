package com.prac2.practica2;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.library.entity.prac2user.Compania;
import com.prac2.practica2.dto.CompaniaDto;
import com.prac2.practica2.impl.CompaniaService;

@SpringBootTest
class CompaniaServiceTest {
	
	@Autowired
	CompaniaService companiaService;
	
	@Test
	void buscar() {
		List<Compania> companias = companiaService.buscar();
		assertNotNull(companias, "Los detalle de Compania-Seguro no están cargados");
	}
	
	@Test
	void guardar() {
		CompaniaDto companiaDto = new CompaniaDto();
		companiaDto.setNombreCompania("test");
		Compania compania = companiaService.guardar(companiaDto);
		assertNotNull(compania, "No se está guardando la compania");
	}
	
	@Test
	void eliminar() {
		try {
			companiaService.eliminar("test");
			assert(true);
		}
		catch (Exception ex) {
			fail("Dio error: " + ex.getMessage());
		}
	}
	

}
