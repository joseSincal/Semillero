package com.prac2.practica2.impl;

import java.util.List;
import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.prac2.practica2.dto.SeguroDto;
import com.prac2.practica2.entity.Seguro;
import com.prac2.practica2.repository.SeguroRepository;
import com.prac2.practica2.ws.SeguroInterface;

@Component
public class SeguroService implements SeguroInterface {
	
	@Autowired
	SeguroRepository seguroRepository;
	
	private static final Log LOG = LogFactory.getLog(SeguroService.class);
	
	@Override
	public List<Seguro> buscar() {
		return seguroRepository.findAll();
	}
	
	@Override
	public ResponseEntity<Seguro> guardar(SeguroDto seguroDto) {
		Seguro seguro = convertirSerguroDtoASeguro(seguroDto);
		try {
			return ResponseEntity.ok().body(seguroRepository.save(seguro));
		} catch(Exception ex) {
			LOG.error("HUBO UN ERROR EN PERSISTENCIA DE DATOS");
			return ResponseEntity.internalServerError().body(null);
		}
	}

	@Override
	public void eliminar(int poliza) {
		Optional<Seguro> seguro = seguroRepository.findById(poliza);
		if(seguro.isPresent()) {
			seguroRepository.delete(seguro.get());
		}
	}	
	
	private Seguro convertirSerguroDtoASeguro(SeguroDto seguroDto) {
		ModelMapper mp = new ModelMapper();
		return mp.map(seguroDto, Seguro.class);
	}
}
