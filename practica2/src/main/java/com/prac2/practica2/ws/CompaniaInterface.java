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

import com.library.entity.prac2user.Compania;
import com.prac2.practica2.dto.CompaniaDto;

@RestController
@RequestMapping(path = "/compania")
@CrossOrigin
public interface CompaniaInterface {
	
	@GetMapping(path = "/buscar")
	public List<Compania> buscar();
	
	@PostMapping(path = "/guardar")
	public Compania guardar(@RequestBody CompaniaDto companiaDto);
	
	@DeleteMapping(path = "/eliminar/{nombre}")
	public void eliminar(@PathVariable String nombre);

}
