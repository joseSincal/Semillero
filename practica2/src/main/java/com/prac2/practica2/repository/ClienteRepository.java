package com.prac2.practica2.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.prac2.practica2.entity.Cliente;

@Repository("clienteRepository")
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
	
	List<Cliente> findByApellido1OrApellido2(String apellido1, String apellido2);

	Page<Cliente> findByApellido1OrApellido2(Pageable pageable, String apellido1, String apellido2);
	
	@Query(value = "SELECT * FROM CLIENTE",
			countQuery = "SELECT COUNT(1) FROM CLIENTE",
			nativeQuery = true)
	Page<Cliente> buscarPaginaCliente(Pageable pageable);
	
}
