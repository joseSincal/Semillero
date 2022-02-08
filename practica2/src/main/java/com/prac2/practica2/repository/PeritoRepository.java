package com.prac2.practica2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prac2.practica2.entity.Perito;

@Repository("peritoRepository")
public interface PeritoRepository extends JpaRepository<Perito, Integer> {
	
	List<Perito> findByApellidoPerito1OrApellidoPerito2AndCiudad(String apellidoPerito1, String apellidoPerito2, String ciudad);
	List<Perito> findByApellidoPerito1Containing(String apellidoPerito1);
	List<Perito> findByNombrePeritoStartingWith(String nombrePerito);
	List<Perito> findByNumeroViaOrderByNombrePeritoDesc(Integer numeroVia);

}
