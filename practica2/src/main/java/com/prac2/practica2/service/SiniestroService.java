package com.prac2.practica2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prac2.practica2.entity.Perito;
import com.prac2.practica2.entity.Siniestro;
import com.prac2.practica2.repository.PeritoRepository;
import com.prac2.practica2.repository.SiniestroRepository;

@RestController
@RequestMapping(path = "/siniestro")
@CrossOrigin
public class SiniestroService {

	@Autowired
	SiniestroRepository siniestroRepository;
	
	@Autowired
	PeritoRepository peritoRepository;
	
	@GetMapping(path = "/buscar")
	public List<Siniestro> buscar() {
		return siniestroRepository.findAll();
	}
	
	@GetMapping(path = "/buscar/por/aceptado/{estado}")
	public List<Siniestro> buscarAceptado(@PathVariable String estado) {
		return siniestroRepository.findByAceptadoLike(estado);
	}
	
	@GetMapping(path = "/buscar/por/indemnizacion/{cantidad}")
	public List<Siniestro> buscarIndemnizacion(@PathVariable Double cantidad) {
		return siniestroRepository.findByIndemnizacionLessThanEqual(cantidad);
	}
	
	@GetMapping(path = "/buscar/por/indemnizacion/entre/{cantidad1}/{cantidad2}")
	public List<Siniestro> buscarIndemnizacion(@PathVariable Double cantidad1, @PathVariable Double cantidad2) {
		return siniestroRepository.findByIndemnizacionBetween(cantidad1, cantidad2);
	}
	
	@GetMapping(path = "/buscar/por/poliza/{poliza}")
	public List<Siniestro> buscarPoliza(@PathVariable Integer poliza) {
		return siniestroRepository.findByNumeroPolizaOrderByIndemnizacionAsc(poliza);
	}
	
	@GetMapping(path = "/buscar/por/fecha/{fecha}/aceptado/{estado}")
	public List<Siniestro> buscarPoliza(@PathVariable String fecha, @PathVariable String estado) {
		return siniestroRepository.findByFechaSiniestroLikeAndAceptadoEquals(fecha.replace("-", "/"), estado);
	}
	
	@PostMapping(path = "/guardar")
	public Siniestro guardar(@RequestBody Siniestro siniestro) {
		return siniestroRepository.save(siniestro);
	}
	
	@DeleteMapping(path = "/eliminar/{id}")
	public void eliminar(@PathVariable int id) {
		Optional<Siniestro> siniestro = siniestroRepository.findById(id);
		if(siniestro.isPresent()) {
			siniestroRepository.delete(siniestro.get());
		}
	}
	
	@PutMapping(path = "/guardar/{id}/agregarPerito/{dni}")
	public String agregarPerito(@PathVariable int id, @PathVariable int dni) {
		Optional<Perito> perito = peritoRepository.findById(dni);
		Optional<Siniestro> siniestro = siniestroRepository.findById(id);
		
		if(perito.isPresent() && siniestro.isPresent()) {
			siniestro.get().setPerito(perito.get());
			siniestroRepository.save(siniestro.get());
			return "Perito agregado correctamente";
		}
		
		return "No se pudo realizar la operación";
	}
}
