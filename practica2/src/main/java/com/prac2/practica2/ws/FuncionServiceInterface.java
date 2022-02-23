package com.prac2.practica2.ws;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prac2.practica2.dto.SeguroDto;

@RestController
@RequestMapping(path = "/fnt")
@CrossOrigin
public interface FuncionServiceInterface {
	
	@PostMapping(path = "/crear/poliza")
	public ResponseEntity<Integer> crearPoliza(@RequestBody SeguroDto seguroDto);

}
