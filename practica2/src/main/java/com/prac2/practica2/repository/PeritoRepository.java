package com.prac2.practica2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.prac2.practica2.dto.PeritoSiniestroCantidadDto;
import com.prac2.practica2.entity.Perito;

@Repository("peritoRepository")
public interface PeritoRepository extends JpaRepository<Perito, Integer> {
	
	List<Perito> findByApellidoPerito1OrApellidoPerito2AndCiudad(String apellidoPerito1, String apellidoPerito2, String ciudad);
	List<Perito> findByApellidoPerito1Containing(String apellidoPerito1);
	List<Perito> findByNombrePeritoStartingWith(String nombrePerito);
	List<Perito> findByNumeroViaOrderByNombrePeritoDesc(Integer numeroVia);
	
	@Query(value = "SELECT * FROM PERITO WHERE ciudad LIKE %:ciudad% ORDER BY nombre_perito DESC",
			nativeQuery = true)
	List<Perito> buscarPorCiudad(String ciudad);
	
	@Query("SELECT new com.prac2.practica2.dto.PeritoSiniestroCantidadDto(p.dniPerito, p.nombrePerito, count(1) as cantidad)"
			+ " FROM Perito p, Siniestro s"
			+ " WHERE p = s.perito"
			+ " GROUP BY p.dniPerito, p.nombrePerito"
			+ " ORDER BY cantidad DESC, p.nombrePerito ASC")
	List<PeritoSiniestroCantidadDto> buscarSiniestrosAtendidos();

}
