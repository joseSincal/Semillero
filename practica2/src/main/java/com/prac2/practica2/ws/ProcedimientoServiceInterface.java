package com.prac2.practica2.ws;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prac2.practica2.dto.ProcedimientoDto;

@RestController
@RequestMapping("/procedimiento")
@CrossOrigin
public interface ProcedimientoServiceInterface {

	@DeleteMapping(path = "/eliminar/siniestro/{id}")
	public int eliminarSiniestro(@PathVariable int id);
	
	@PutMapping(path = "/cambiar/siniestro/{id}/indemnizacion/{indemnizacion}")
	public ProcedimientoDto cambiarIndemnizacion(@PathVariable int id, @PathVariable int indemnizacion);
	
}
