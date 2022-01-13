package com.prac2.practica2.ws;

import java.util.List;

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

@RestController
@RequestMapping(path = "/seguro")
@CrossOrigin
public interface SeguroInterface {
	
	@GetMapping(path = "/buscar")
	public List<Seguro> buscar();
	
	@PostMapping(path = "/guardar")
	public Seguro guardar(@RequestBody SeguroDto seguroDto);
	
	@DeleteMapping(path = "/eliminar/{poliza}")
	public void eliminar(@PathVariable int poliza);

}
