package com.prac2.practica2.impl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
	public Seguro guardar(SeguroDto seguroDto) {
		Seguro seguro = convertirSerguroDtoASeguro(seguroDto);
		return seguroRepository.save(seguro);
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
