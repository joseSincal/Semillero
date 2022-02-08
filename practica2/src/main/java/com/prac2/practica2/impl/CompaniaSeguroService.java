package com.prac2.practica2.impl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.prac2.practica2.dto.CompaniaSeguroDto;
import com.prac2.practica2.entity.CompaniaSeguro;
import com.prac2.practica2.repository.CompaniaSeguroRepository;
import com.prac2.practica2.ws.CompaniaSeguroInterface;

@Component
public class CompaniaSeguroService implements CompaniaSeguroInterface {

	@Autowired
	CompaniaSeguroRepository companiaSeguroRepository;
	
	@Override
	public List<CompaniaSeguro> buscar() {
		return companiaSeguroRepository.findAll();
	}
	
	@Override
	public CompaniaSeguro guardar(CompaniaSeguroDto companiaSeguroDto) {
		CompaniaSeguro companiaSeguro = convertirCompaniaSeguroDtoACompaniaSeguro(companiaSeguroDto);
		return companiaSeguroRepository.save(companiaSeguro);
	}

	@Override
	public void eliminar(int id) {
		Optional<CompaniaSeguro> companiaSeguro = companiaSeguroRepository.findById(id);
		if(companiaSeguro.isPresent()) {
			companiaSeguroRepository.delete(companiaSeguro.get());
		}
	}
	
	private CompaniaSeguro convertirCompaniaSeguroDtoACompaniaSeguro(CompaniaSeguroDto companiaSeguroDto) {
		ModelMapper mp = new ModelMapper();
		return mp.map(companiaSeguroDto, CompaniaSeguro.class);
	}
}
