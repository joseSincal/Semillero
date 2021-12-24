package com.prac2.practica2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prac2.practica2.entity.Perito;
import com.prac2.practica2.repository.PeritoRepository;

@RestController
@RequestMapping(path = "/perito") 
public class PeritoService {
	
	@Autowired
	PeritoRepository peritoRepository;
	
	@GetMapping(path = "/buscar")
	public List<Perito> buscar() {
		return peritoRepository.findAll();
	}
	
	@GetMapping(path = "/buscar/por/apellidos/{apellido}/y/ciudad/{ciudad}")
	public List<Perito> buscar(@PathVariable String apellido, @PathVariable String ciudad) {
		return peritoRepository.findByApellidoPerito1OrApellidoPerito2AndCiudad(apellido, apellido, ciudad);
	}
	
	@GetMapping(path = "/buscar/por/apellido1/contiene/{apellido}")
	public List<Perito> buscar(@PathVariable String apellido) {
		return peritoRepository.findByApellidoPerito1Containing(apellido);
	}
	
	@GetMapping(path = "/buscar/por/nombre/comienza/con/{inicial}")
	public List<Perito> buscarInicialNombre(@PathVariable String inicial) {
		return peritoRepository.findByNombrePeritoStartingWith(inicial);
	}
	
	@GetMapping(path = "/buscar/por/numeroVia/{numero}")
	public List<Perito> buscarNumeroVia(@PathVariable Integer numero) {
		return peritoRepository.findByNumeroViaOrderByNombrePeritoDesc(numero);
	}
	
	@PostMapping(path = "/guardar")
	public Perito guardar(@RequestBody Perito perito) {
		return peritoRepository.save(perito);
	}
	
	@DeleteMapping(path = "/eliminar/{dni}")
	public void eliminar(@PathVariable int dni) {
		Optional<Perito> perito = peritoRepository.findById(dni);
		if(perito.isPresent()) {
			peritoRepository.delete(perito.get());
		}
	}
	
}
