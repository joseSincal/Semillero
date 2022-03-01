package com.prac2.practica2.impl;

import java.util.List;
import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.prac2.practica2.dto.PeritoDto;
import com.prac2.practica2.dto.PeritoSiniestroCantidadDto;
import com.prac2.practica2.entity.Perito;
import com.prac2.practica2.repository.PeritoRepository;
import com.prac2.practica2.ws.PeritoInterface;

@Component
public class PeritoService implements PeritoInterface {
	
	@Autowired
	PeritoRepository peritoRepository;
	
	private static final Log LOG = LogFactory.getLog(PeritoService.class);
	
	@Override
	public List<Perito> buscar() {
		return peritoRepository.findAll();
	}
	
	@Override
	public List<Perito> buscar(String apellido, String ciudad) {
		return peritoRepository.findByApellidoPerito1OrApellidoPerito2AndCiudad(apellido, apellido, ciudad);
	}
	
	@Override
	public List<Perito> buscar(String apellido) {
		return peritoRepository.findByApellidoPerito1Containing(apellido);
	}
	
	@Override
	public List<Perito> buscarInicialNombre(String inicial) {
		return peritoRepository.findByNombrePeritoStartingWith(inicial);
	}
	
	@Override
	public List<Perito> buscarNumeroVia(Integer numero) {
		return peritoRepository.findByNumeroViaOrderByNombrePeritoDesc(numero);
	}
	
	@Override
	public ResponseEntity<Perito> guardar(PeritoDto peritoDto) {
		Perito perito = convertirPeritoDtoAPerito(peritoDto);
		try {
			return ResponseEntity.ok().body(peritoRepository.save(perito));
		} catch(Exception ex) {
			LOG.error("HUBO UN ERROR DE PERSISTENCIA DE DATOS: " + ex);
			return ResponseEntity.internalServerError().body(null);
		}
	}

	@Override
	public void eliminar(int dni) {
		Optional<Perito> perito = peritoRepository.findById(dni);
		if(perito.isPresent()) {
			peritoRepository.delete(perito.get());
		}
	}
	
	private Perito convertirPeritoDtoAPerito(PeritoDto peritoDto) {
		ModelMapper mp = new ModelMapper();
		return mp.map(peritoDto, Perito.class);
	}

	@Override
	public List<Perito> obtenerPorCiudad(String ciudad) {
		return peritoRepository.buscarPorCiudad(ciudad);
	}

	@Override
	public List<PeritoSiniestroCantidadDto> buscarSiniestrosAtendidos() {
		return peritoRepository.buscarSiniestrosAtendidos();
	}
	
}
