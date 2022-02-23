package com.prac2.practica2.impl;

import java.util.List;
import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.prac2.practica2.dto.CompaniaDto;
import com.prac2.practica2.entity.Compania;
import com.prac2.practica2.repository.CompaniaRepository;
import com.prac2.practica2.ws.CompaniaInterface;

@Component
public class CompaniaService implements CompaniaInterface {

	@Autowired
	CompaniaRepository companiaRepository;
	
	private static final Log LOG = LogFactory.getLog(CompaniaService.class);
	
	@Override
	public List<Compania> buscar() {
		return companiaRepository.findAll();
	}
	
	@Override
	public ResponseEntity<Compania> guardar(CompaniaDto companiaDto) {
		Compania compania = convertirCompaniaDtoACompania(companiaDto);
		try {
			return ResponseEntity.ok().body(companiaRepository.save(compania));
		} catch (Exception ex) {
			LOG.error("HUBO UN ERROR DE PERSISTENCIA DE DATOS: " + ex);
			return ResponseEntity.internalServerError().body(null);
		}
	}
	
	@Override
	public void eliminar(String nombre) {
		Optional<Compania> compania = companiaRepository.findById(nombre);
		if(compania.isPresent()) {
			companiaRepository.delete(compania.get());
		}
	}
	
	private Compania convertirCompaniaDtoACompania(CompaniaDto companiaDto) {
		ModelMapper mp = new ModelMapper();
		return mp.map(companiaDto, Compania.class);
	}

}
