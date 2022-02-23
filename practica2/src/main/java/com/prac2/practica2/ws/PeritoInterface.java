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

import com.prac2.practica2.dto.PeritoDto;
import com.prac2.practica2.entity.Perito;

@RestController
@RequestMapping(path = "/perito")
@CrossOrigin
public interface PeritoInterface {
	
	@GetMapping(path = "/buscar")
	public List<Perito> buscar();
	
	@GetMapping(path = "/buscar/por/apellidos/{apellido}/y/ciudad/{ciudad}")
	public List<Perito> buscar(@PathVariable String apellido, @PathVariable String ciudad);
	
	@GetMapping(path = "/buscar/por/apellido1/contiene/{apellido}")
	public List<Perito> buscar(@PathVariable String apellido);
	
	@GetMapping(path = "/buscar/por/nombre/comienza/con/{inicial}")
	public List<Perito> buscarInicialNombre(@PathVariable String inicial);
	
	@GetMapping(path = "/buscar/por/numeroVia/{numero}")
	public List<Perito> buscarNumeroVia(@PathVariable Integer numero);
	
	@PostMapping(path = "/guardar")
	public ResponseEntity<Perito> guardar(@RequestBody PeritoDto peritoDto);
	
	@DeleteMapping(path = "/eliminar/{dni}")
	public void eliminar(@PathVariable int dni);

}
