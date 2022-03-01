package com.prac2.practica2.impl;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.prac2.practica2.dto.ClienteDto;
import com.prac2.practica2.entity.Cliente;
import com.prac2.practica2.repository.ClienteRepository;
import com.prac2.practica2.service.CatalogoService;
import com.prac2.practica2.ws.ClienteServiceInterface;

@Component
public class ClienteService implements ClienteServiceInterface {
	
	@Autowired
	ClienteRepository clienteRepository;
	
	@Autowired
	CatalogoService catalogoService;
	
	private static final Log LOG = LogFactory.getLog(ClienteService.class);
	
	@Override
	public List<Cliente> buscar() {
		return clienteRepository.findAll();
	}
	
	@Override
	public List<Cliente> buscar(String apellido) {
		return clienteRepository.findByApellido1OrApellido2(apellido, apellido);
	}
	
	@Override
	public ResponseEntity<Cliente> guardar(ClienteDto clienteDto) {
		Cliente cliente = convertirClienteDtoACliente(clienteDto);
		try {
			return ResponseEntity.ok().body(clienteRepository.save(cliente));
		} catch(Exception ex) {
			LOG.error("HUBO UN ERROR EN PERSISTENCIA DE DATOS: "+ ex);
			return ResponseEntity.internalServerError().body(null);
		}
	}

	@Override
	public void eliminar(int dni) {
		Optional<Cliente> cliente = clienteRepository.findById(dni);
		if(cliente.isPresent()) {
			clienteRepository.delete(cliente.get());
		}
	}
	
	private Cliente convertirClienteDtoACliente(ClienteDto clienteDto) {
		ModelMapper mp = new ModelMapper();
		return mp.map(clienteDto, Cliente.class);
	}

	@Override
	public ResponseEntity<Integer> guardarCliente(ClienteDto clienteDto) {
		try {
			return ResponseEntity.ok().body(catalogoService.guardarCliente(clienteDto));
		} catch(Exception ex) {
			LOG.error("HUBO UN ERROR DE PERSISTENCIA DE DATOS: " + ex);
			return ResponseEntity.internalServerError().body(null);
		}
		
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

	@Override
	public Page<Cliente> buscarPaginable(int pagina, int cantidad) {
		Pageable pageable = PageRequest.of(pagina, cantidad);
		return clienteRepository.findAll(pageable);
	}

	@Override
	public Page<Cliente> buscarPaginable(String apellido, int pagina, int cantidad) {
		Pageable pageable = PageRequest.of(pagina, cantidad);
		return clienteRepository.findByApellido1OrApellido2(pageable, apellido, apellido);
	}

	@Override
	public Page<Cliente> buscarPaginableQuery(int pagina, int cantidad) {
		Pageable pageable = PageRequest.of(pagina, cantidad);
		return clienteRepository.buscarPaginaCliente(pageable);
	}

}
