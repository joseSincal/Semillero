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

import com.prac2.practica2.entity.Cliente;
import com.prac2.practica2.repository.ClienteRepository;

@RestController
@RequestMapping(path = "/cliente")
@CrossOrigin
public class ClienteService {
	
	@Autowired
	ClienteRepository clienteRepository;
	
	@GetMapping(path = "/buscar")
	public List<Cliente> buscar() {
		return clienteRepository.findAll();
	}
	
	@GetMapping(path = "/buscar/por/apellidos/{apellido}")
	public List<Cliente> buscar(@PathVariable String apellido) {
		return clienteRepository.findByApellido1OrApellido2(apellido, apellido);
	}
	
	@PostMapping(path = "/guardar")
	public Cliente guardar(@RequestBody Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	@DeleteMapping(path = "/eliminar/{dni}")
	public void eliminar(@PathVariable int dni) {
		Optional<Cliente> cliente = clienteRepository.findById(dni);
		if(cliente.isPresent()) {
			clienteRepository.delete(cliente.get());
		}
	}

}
