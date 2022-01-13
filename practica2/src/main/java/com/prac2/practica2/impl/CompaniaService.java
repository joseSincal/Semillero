package com.prac2.practica2.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.prac2.practica2.dto.CompaniaDto;
import com.prac2.practica2.entity.Compania;
import com.prac2.practica2.repository.CompaniaRepository;
import com.prac2.practica2.ws.CompaniaInterface;

@Component
public class CompaniaService implements CompaniaInterface {

	@Autowired
	CompaniaRepository companiaRepository;
	
	@Override
	public List<Compania> buscar() {
		return companiaRepository.findAll();
	}
	
	@Override
	public Compania guardar(@RequestBody CompaniaDto companiaDto) {
		Compania compania = convertirCompaniaDtoACompania(companiaDto);
		return companiaRepository.save(compania);
	}
	
	@Override
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
