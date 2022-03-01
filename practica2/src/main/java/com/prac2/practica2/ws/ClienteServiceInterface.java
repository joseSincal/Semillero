package com.prac2.practica2.ws;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prac2.practica2.dto.ClienteDto;
import com.prac2.practica2.entity.Cliente;

@RestController
@RequestMapping(path = "/cliente")
@CrossOrigin
public interface ClienteServiceInterface {
	
	@GetMapping(path = "/buscar")
	public List<Cliente> buscar();
	
	@GetMapping(path = "/buscar/Pageable/{pagina}/{cantidad}")
	public Page<Cliente> buscarPaginable(@PathVariable int pagina, @PathVariable int cantidad);
	
	@GetMapping(path = "/buscar/por/apellidos/Pageable/{apellido}")
	public List<Cliente> buscar(@PathVariable String apellido);
	
	@GetMapping(path = "/buscar/por/apellidos/Pageable/{apellido}/{pagina}/{cantidad}")
	public Page<Cliente> buscarPaginable(@PathVariable String apellido, @PathVariable int pagina, @PathVariable int cantidad);
	
	@PostMapping(path = "/guardar")
	public ResponseEntity<Cliente> guardar(@RequestBody ClienteDto clienteDto);
	
	@DeleteMapping(path = "/eliminar/{dni}")
	public void eliminar(@PathVariable int dni);
	
	@PostMapping(path = "/guardar2")
	public ResponseEntity<Integer> guardarCliente(@RequestBody ClienteDto clienteDto);
	
	@PutMapping(path = "/cambiar/nombre/{dniCl}/{nombre}")
	public void cambiarNombreCliente(@PathVariable Integer dniCl, @PathVariable String nombre);
	
	@DeleteMapping(path = "/eliminar2/{dniCl}")
	public void eliminarCliente(@PathVariable Integer dniCl);

	@GetMapping(path = "/buscar/todos")
	public List<Map<String, Object>> buscarClientes();
	
	@GetMapping(path = "/buscar/{dniCl}")
	public List<Map<String, Object>> buscarCliente(@PathVariable Integer dniCl);
	
	@GetMapping(path = "/buscar/Pageable/query/{pagina}/{cantidad}")
	public Page<Cliente> buscarPaginableQuery(@PathVariable int pagina, @PathVariable int cantidad);
	
}
