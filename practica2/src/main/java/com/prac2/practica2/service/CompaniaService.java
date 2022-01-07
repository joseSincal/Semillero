package com.prac2.practica2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prac2.practica2.dto.CompaniaDto;
import com.prac2.practica2.entity.Compania;
import com.prac2.practica2.repository.CompaniaRepository;

@RestController
@RequestMapping(path = "/compania")
@CrossOrigin
public class CompaniaService {

	@Autowired
	CompaniaRepository companiaRepository;
	
	@GetMapping(path = "/buscar")
	public List<Compania> buscar() {
		return companiaRepository.findAll();
	}
	
	@PostMapping(path = "/guardar")
	public Compania guardar(@RequestBody CompaniaDto companiaDto) {
		Compania compania = convertirCompaniaDtoACompania(companiaDto);
		return companiaRepository.save(compania);
	}
	
	@DeleteMapping(path = "/eliminar/{nombre}")
	public void eliminar(@PathVariable String nombre) {
		Optional<Compania> compania = companiaRepository.findById(nombre);
		if(compania.isPresent()) {
			companiaRepository.delete(compania.get());
		}
	}
	
	private Compania convertirCompaniaDtoACompania(CompaniaDto companiaDto) {
		Compania compania = new Compania();
		compania.setNombreCompania(companiaDto.getNombreCompania());
		compania.setClaseVia(companiaDto.getClaseVia());
		compania.setNumeroVia(companiaDto.getNumeroVia());
		compania.setCodPostal(companiaDto.getCodPostal());
		compania.setTelefonoContratacion(companiaDto.getTelefonoContratacion());
		compania.setTelefonoSiniestro(companiaDto.getTelefonoSiniestro());
		compania.setNota(companiaDto.getNota());
		return compania;
	}

	
}
