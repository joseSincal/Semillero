package com.prac2.practica2.impl;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.library.entity.prac2user.Cliente;
import com.prac2.practica2.dto.ClienteDto;
import com.prac2.practica2.repository.ClienteRepository;
import com.prac2.practica2.service.CatalogoService;
import com.prac2.practica2.ws.ClienteServiceInterface;

@Component
public class ClienteService implements ClienteServiceInterface {
	
	@Autowired
	ClienteRepository clienteRepository;
	
	@Autowired
	CatalogoService catalogoService;
	
	@Override
	public List<Cliente> buscar() {
		return clienteRepository.findAll();
	}
	
	@Override
	public List<Cliente> buscar(@PathVariable String apellido) {
		return clienteRepository.findByApellido1OrApellido2(apellido, apellido);
	}
	
	@Override
	public Cliente guardar(@RequestBody ClienteDto clienteDto) {
		Cliente cliente = convertirClienteDtoACliente(clienteDto);
		return clienteRepository.save(cliente);
	}

	@Override
	public void eliminar(@PathVariable int dni) {
		Optional<Cliente> cliente = clienteRepository.findById(dni);
		if(cliente.isPresent()) {
			clienteRepository.delete(cliente.get());
		}
	}
	
	private Cliente convertirClienteDtoACliente(ClienteDto clienteDto) {
		Cliente cliente = new Cliente();
		cliente.setDniCl(clienteDto.getDniCl());
		cliente.setNombreCl(clienteDto.getNombreCl());
		cliente.setApellido1(clienteDto.getApellido1());
		cliente.setApellido2(clienteDto.getApellido2());
		cliente.setClaseVia(clienteDto.getClaseVia());
		cliente.setNombreVia(clienteDto.getNombreVia());
		cliente.setNumeroVia(clienteDto.getNumeroVia());
		cliente.setCodPostal(clienteDto.getCodPostal());
		cliente.setCiudad(clienteDto.getCiudad());
		cliente.setTelefono(clienteDto.getTelefono());
		cliente.setObservacion(clienteDto.getObservacion());
		return cliente;
	}

	@Override
	public void guardarCliente(ClienteDto clienteDto) {
		catalogoService.guardarCliente(clienteDto);
	}

	@Override
	public void cambiarNombreCliente(Integer dniCl, String nombre) {
		catalogoService.cambiarNombreCliente(dniCl, nombre);
	}

	@Override
	public void eliminarCliente(Integer dniCl) {
		catalogoService.eliminarCliente(dniCl);
	}
	
	@Override
	public List<Map<String, Object>> buscarClientes() {
		return catalogoService.buscarClientes();
	}

	@Override
	public List<Map<String, Object>> buscarCliente(Integer dniCl) {
		return catalogoService.buscarCliente(dniCl);
	}

}
