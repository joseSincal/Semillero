package com.prac2.practica2.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.prac2.practica2.dto.PeritoDto;
import com.prac2.practica2.entity.Perito;
import com.prac2.practica2.repository.PeritoRepository;
import com.prac2.practica2.ws.PeritoInterface;

@Component
public class PeritoService implements PeritoInterface {
	
	@Autowired
	PeritoRepository peritoRepository;
	
	@Override
	public List<Perito> buscar() {
		return peritoRepository.findAll();
	}
	
	@Override
	public List<Perito> buscar(@PathVariable String apellido, @PathVariable String ciudad) {
		return peritoRepository.findByApellidoPerito1OrApellidoPerito2AndCiudad(apellido, apellido, ciudad);
	}
	
	@Override
	public List<Perito> buscar(@PathVariable String apellido) {
		return peritoRepository.findByApellidoPerito1Containing(apellido);
	}
	
	@Override
	public List<Perito> buscarInicialNombre(@PathVariable String inicial) {
		return peritoRepository.findByNombrePeritoStartingWith(inicial);
	}
	
	@Override
	public List<Perito> buscarNumeroVia(@PathVariable Integer numero) {
		return peritoRepository.findByNumeroViaOrderByNombrePeritoDesc(numero);
	}
	
	@Override
	public Perito guardar(@RequestBody PeritoDto peritoDto) {
		Perito perito = convertirPeritoDtoAPerito(peritoDto);
		return peritoRepository.save(perito);
	}

	@Override
	public void eliminar(@PathVariable int dni) {
		Optional<Perito> perito = peritoRepository.findById(dni);
		if(perito.isPresent()) {
			peritoRepository.delete(perito.get());
		}
	}
	
	private Perito convertirPeritoDtoAPerito(PeritoDto peritoDto) {
		Perito perito = new Perito();
		perito.setDniPerito(peritoDto.getDniPerito());
		perito.setNombrePerito(peritoDto.getNombrePerito());
		perito.setApellidoPerito1(peritoDto.getApellidoPerito1());
		perito.setApellidoPerito2(peritoDto.getApellidoPerito2());
		perito.setTelefonoContacto(peritoDto.getTelefonoContacto());
		perito.setTelefonoOficina(peritoDto.getTelefonoOficina());
		perito.setClaseVia(peritoDto.getClaseVia());
		perito.setNombreVia(peritoDto.getNombreVia());
		perito.setNumeroVia(peritoDto.getNumeroVia());
		perito.setCodPostal(peritoDto.getCodPostal());
		perito.setCiudad(peritoDto.getCiudad());
		return perito;
	}
	
}