package com.prac2.practica2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prac2.practica2.dto.SeguroDto;
import com.prac2.practica2.entity.Seguro;
import com.prac2.practica2.repository.SeguroRepository;

@RestController
@RequestMapping(path = "/seguro")
@CrossOrigin
public class SeguroService {
	
	@Autowired
	SeguroRepository seguroRepository;
	
	@GetMapping(path = "/buscar")
	public List<Seguro> buscar() {
		return seguroRepository.findAll();
	}
	
	@PostMapping(path = "/guardar")
	public Seguro guardar(@RequestBody SeguroDto seguroDto) {
		Seguro seguro = convertirSerguroDtoASeguro(seguroDto);
		return seguroRepository.save(seguro);
	}

	@DeleteMapping(path = "/eliminar/{poliza}")
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
