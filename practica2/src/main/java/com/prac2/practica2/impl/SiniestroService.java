package com.prac2.practica2.impl;


import java.util.List;
import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.prac2.practica2.dto.SiniestroDto;
import com.prac2.practica2.dto.SiniestroPeritoDto;
import com.prac2.practica2.entity.Perito;
import com.prac2.practica2.entity.Siniestro;
import com.prac2.practica2.repository.PeritoRepository;
import com.prac2.practica2.repository.SiniestroRepository;
import com.prac2.practica2.ws.SiniestroInterface;

@Component
public class SiniestroService implements SiniestroInterface {

	@Autowired
	SiniestroRepository siniestroRepository;

	@Autowired
	PeritoRepository peritoRepository;
	
	private static final Log LOG = LogFactory.getLog(SiniestroService.class);

	@Override
	public List<Siniestro> buscar() {
		return siniestroRepository.findAll();
	}

	@Override
	public List<Siniestro> buscarAceptado(String estado) {
		return siniestroRepository.findByAceptadoLike(estado);
	}

	@Override
	public List<Siniestro> buscarIndemnizacion(Double cantidad) {
		return siniestroRepository.findByIndemnizacionLessThanEqual(cantidad);
	}

	@Override
	public List<Siniestro> buscarIndemnizacion(Double cantidad1, Double cantidad2) {
		return siniestroRepository.findByIndemnizacionBetween(cantidad1, cantidad2);
	}

	@Override
	public List<Siniestro> buscarPoliza(Integer poliza) {
		return siniestroRepository.findByNumeroPolizaOrderByIndemnizacionAsc(poliza);
	}

	@Override
	public List<Siniestro> buscarPoliza(String fecha, String estado) {
		return siniestroRepository.findByFechaSiniestroLikeAndAceptadoEquals(fecha.replace("-", "/"), estado);
	}

	@Override
	public ResponseEntity<Siniestro> guardar(SiniestroDto siniestroDto) {
		Siniestro siniestro = convertirSiniestroDtoASiniestro(siniestroDto);
		try {
			return ResponseEntity.ok().body(siniestroRepository.save(siniestro));
		} catch(Exception ex) {
			LOG.error("HUBO UN ERROR DE PERSISTENIA DE DATOS: " + ex);
			return ResponseEntity.internalServerError().body(null);
		}
	}

	@Override
	public void eliminar(int id) {
		Optional<Siniestro> siniestro = siniestroRepository.findById(id);
		if (siniestro.isPresent()) {
			siniestroRepository.delete(siniestro.get());
		}
	}

	@Override
	public String agregarPerito(int id, int dni) {
		Optional<Perito> perito = peritoRepository.findById(dni);
		Optional<Siniestro> siniestro = siniestroRepository.findById(id);

		if (perito.isPresent() && siniestro.isPresent()) {
			siniestro.get().setPerito(perito.get());
			siniestroRepository.save(siniestro.get());
			return "Perito agregado correctamente";
		}

		return "No se pudo realizar la operación";
	}

	@Override
	public List<Siniestro> buscarIndermizacionDespues(Double indemnizacion) {
		return siniestroRepository.findByIndemnizacionAfter(indemnizacion);
	}

	private Siniestro convertirSiniestroDtoASiniestro(SiniestroDto siniestroDto) {
		ModelMapper mp = new ModelMapper();
		return mp.map(siniestroDto, Siniestro.class);
	}

	@Override
	public List<SiniestroPeritoDto> buscarPorCausa(String causa) {
		return siniestroRepository.buscarPorCausa(causa);
	}
}
