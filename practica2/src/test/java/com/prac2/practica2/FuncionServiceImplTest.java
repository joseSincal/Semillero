package com.prac2.practica2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.prac2.practica2.dto.SeguroDto;
import com.prac2.practica2.impl.FuncionServiceImpl;
import com.prac2.practica2.impl.SeguroService;

@SpringBootTest
class FuncionServiceImplTest {
	
	@Autowired
	FuncionServiceImpl funcionServiceImpl;
	
	@Autowired
	SeguroService seguroService;
	
	@Test
	void crearPoliza() {
		seguroService.eliminar(0);
		SeguroDto seguroDto = new SeguroDto();
		
		seguroDto.setNumeroPoliza(0);
		int numeroPoliza = funcionServiceImpl.crearPoliza(seguroDto);
		assertEquals(0, numeroPoliza, "No se está insertando");
	}

}
