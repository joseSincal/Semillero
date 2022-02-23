package com.prac2.practica2.ws;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prac2.practica2.dto.CompaniaSeguroDto;
import com.prac2.practica2.entity.CompaniaSeguro;

@RestController
@RequestMapping(path = "/companiaSeguro")
@CrossOrigin
public interface CompaniaSeguroInterface {
	
	@GetMapping(path = "/buscar")
	public List<CompaniaSeguro> buscar();
	
	@PostMapping(path = "/guardar")
	public ResponseEntity<CompaniaSeguro> guardar(@RequestBody CompaniaSeguroDto companiaSeguroDto);
	
	@DeleteMapping(path = "/eliminar/{id}")
	public void eliminar(@PathVariable int id);

}
