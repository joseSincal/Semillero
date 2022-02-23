package com.prac2.practica2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.prac2.practica2.dto.ClienteDto;
import com.prac2.practica2.entity.Cliente;
import com.prac2.practica2.impl.ClienteService;

@SpringBootTest
class ClienteServiceTest {

	@Autowired
	ClienteService clienteService;
	
	@Test
	void buscar() {
		List<Cliente> clientes = clienteService.buscar();
		assertNotNull(clientes, "Los clientes no están cargados");
	}
	
	@Test
	void buscar2() {
		List<Cliente> clientes = clienteService.buscar("Ejcalón");
		int size = clientes.size();
		assertEquals(0, size, "Validación apellido test encontrado");
	}
	
	@Test
	void guardar() {
		ClienteDto clienteDto = new ClienteDto();
		clienteDto.setNombreCl("test");
		clienteDto.setApellido1("test");
		clienteDto.setTelefono(0);
		Cliente cliente = clienteService.guardar(clienteDto).getBody();
		assertNotNull(cliente, "El cliente no se guardó");
		clienteService.eliminarCliente(cliente.getDniCl());
	}
	
	@Test
	void eliminar() {
		try {
			clienteService.eliminar(0);
			assert(true);
		}
		catch (Exception ex) {
			fail("Dio error: " + ex.getMessage());
		}
	}
	
	@Test
	void guardarCliente() {
		try {
			ClienteDto cliente = new ClienteDto();
			cliente.setDniCl(0);
			clienteService.guardarCliente(cliente);
			assert(true);
			clienteService.eliminarCliente(cliente.getDniCl());
		}
		catch (Exception ex) {
			fail("Dio error: " + ex.getMessage());
		}
	}
	
	@Test
	void cambiarNombreCliente() {
		try {
			clienteService.cambiarNombreCliente(5, "test");
			assert(true);
		}
		catch (Exception ex) {
			fail("Dio error: " + ex.getMessage());
		}
	}
	
	@Test
	void eliminarCliente() {
		try {
			clienteService.eliminarCliente(0);
			assert(true);
		}
		catch (Exception ex) {
			fail("Dio error: " + ex.getMessage());
		}
	}
	
	@Test
	void buscarClientes() {
		List<Map<String, Object>> clientes = clienteService.buscarClientes();
		assertNotNull(clientes, "Los clientes no están cargados");
	}
	
	@Test
	void buscarCliente() {
		List<Map<String, Object>> clientes = clienteService.buscarCliente(1);
		int size = clientes.size();
		assertEquals(1, size, "Validación apellido test encontrado");
	}

}
