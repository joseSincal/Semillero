package com.prac2.practica2.ws;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prac2.practica2.dto.SiniestroDto;
import com.prac2.practica2.entity.Siniestro;

@RestController
@RequestMapping(path = "/siniestro")
@CrossOrigin
public interface SiniestroInterface {
	
	@GetMapping(path = "/buscar")
	public List<Siniestro> buscar();
	
	@GetMapping(path = "/buscar/por/aceptado/{estado}")
	public List<Siniestro> buscarAceptado(@PathVariable String estado);
	
	@GetMapping(path = "/buscar/por/indemnizacion/{cantidad}")
	public List<Siniestro> buscarIndemnizacion(@PathVariable Double cantidad);
	
	@GetMapping(path = "/buscar/por/indemnizacion/entre/{cantidad1}/{cantidad2}")
	public List<Siniestro> buscarIndemnizacion(@PathVariable Double cantidad1, @PathVariable Double cantidad2);
	
	@GetMapping(path = "/buscar/por/poliza/{poliza}")
	public List<Siniestro> buscarPoliza(@PathVariable Integer poliza);
	
	@GetMapping(path = "/buscar/por/fecha/{fecha}/aceptado/{estado}")
	public List<Siniestro> buscarPoliza(@PathVariable String fecha, @PathVariable String estado);
	
	@PostMapping(path = "/guardar")
	public Siniestro guardar(@RequestBody SiniestroDto siniestroDto);
	
	@DeleteMapping(path = "/eliminar/{id}")
	public void eliminar(@PathVariable int id);
	
	@PutMapping(path = "/guardar/{id}/agregarPerito/{dni}")
	public String agregarPerito(@PathVariable int id, @PathVariable int dni);

}
