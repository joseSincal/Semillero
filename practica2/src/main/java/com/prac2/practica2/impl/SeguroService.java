package com.prac2.practica2.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.library.entity.prac2user.Seguro;
import com.prac2.practica2.dto.SeguroDto;
import com.prac2.practica2.repository.SeguroRepository;
import com.prac2.practica2.ws.SeguroInterface;

@Component
public class SeguroService implements SeguroInterface {
	
	@Autowired
	SeguroRepository seguroRepository;
	
	@Override
	public List<Seguro> buscar() {
		return seguroRepository.findAll();
	}
	
	@Override
	public Seguro guardar(@RequestBody SeguroDto seguroDto) {
		Seguro seguro = convertirSerguroDtoASeguro(seguroDto);
		return seguroRepository.save(seguro);
	}

	@Override
	public void eliminar(@PathVariable int poliza) {
		Optional<Seguro> seguro = seguroRepository.findById(poliza);
		if(seguro.isPresent()) {
			seguroRepository.delete(seguro.get());
		}
	}	
	
	private Seguro convertirSerguroDtoASeguro(SeguroDto seguroDto) {
		Seguro seguro = new Seguro();
		seguro.setNumeroPoliza(seguroDto.getNumeroPoliza());
		seguro.setRamo(seguroDto.getRamo());
		seguro.setFechaInicio(seguroDto.getFechaInicio());
		seguro.setFechaVencimiento(seguroDto.getFechaVencimiento());
		seguro.setCondicionParticular(seguroDto.getCondicionParticular());
		seguro.setObservacion(seguroDto.getObservacion());
		seguro.setDniCl(seguroDto.getDniCl());
		return seguro;
	}
}
