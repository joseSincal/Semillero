package com.prac2.practica2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prac2.practica2.entity.Cliente;

@Repository("clienteRepository")
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
	
	List<Cliente> findByApellido1OrApellido2(String apellido1, String apellido2);

}
