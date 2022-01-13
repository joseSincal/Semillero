package com.prac2.practica2.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

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
	public CompaniaSeguro guardar(@RequestBody CompaniaSeguroDto companiaSeguroDto) {
		CompaniaSeguro companiaSeguro = convertirCompaniaSeguroDtoACompaniaSeguro(companiaSeguroDto);
		return companiaSeguroRepository.save(companiaSeguro);
	}

	@Override
	public void eliminar(@PathVariable int id) {
		Optional<CompaniaSeguro> companiaSeguro = companiaSeguroRepository.findById(id);
		if(companiaSeguro.isPresent()) {
			companiaSeguroRepository.delete(companiaSeguro.get());
		}
	}
	
	private CompaniaSeguro convertirCompaniaSeguroDtoACompaniaSeguro(CompaniaSeguroDto companiaSeguroDto) {
		CompaniaSeguro companiaSeguro = new CompaniaSeguro();
		companiaSeguro.setId(companiaSeguroDto.getId());
		companiaSeguro.setNumeroPoliza(companiaSeguroDto.getNumeroPoliza());
		companiaSeguro.setNombreCompania(companiaSeguroDto.getNombreCompania());
		return companiaSeguro;
	}
}
