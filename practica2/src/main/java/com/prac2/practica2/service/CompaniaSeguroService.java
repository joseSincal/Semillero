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

import com.prac2.practica2.entity.CompaniaSeguro;
import com.prac2.practica2.repository.CompaniaSeguroRepository;

@RestController
@RequestMapping(path = "/companiaSeguro")
public class CompaniaSeguroService {

	@Autowired
	CompaniaSeguroRepository companiaSeguroRepository;
	
	@GetMapping(path = "/buscar")
	public List<CompaniaSeguro> buscar() {
		return companiaSeguroRepository.findAll();
	}
	
	@PostMapping(path = "/guardar")
	public CompaniaSeguro guardar(@RequestBody CompaniaSeguro companiaSeguro) {
		return companiaSeguroRepository.save(companiaSeguro);
	}
	
	@DeleteMapping(path = "/eliminar/{id}")
	public void eliminar(@PathVariable int id) {
		Optional<CompaniaSeguro> companiaSeguro = companiaSeguroRepository.findById(id);
		if(companiaSeguro.isPresent()) {
			companiaSeguroRepository.delete(companiaSeguro.get());
		}
	}
}
