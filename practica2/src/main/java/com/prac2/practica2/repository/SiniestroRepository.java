package com.prac2.practica2.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.prac2.practica2.dto.SiniestroPeritoDto;
import com.prac2.practica2.entity.Siniestro;

@Repository("siniestroRepository")
public interface SiniestroRepository extends JpaRepository<Siniestro, Integer> {

	List<Siniestro> findByAceptadoLike(String aceptado);

	List<Siniestro> findByIndemnizacionLessThanEqual(Double indemnizacion);

	List<Siniestro> findByIndemnizacionBetween(Double indemnizacion, Double indemnizacion2);

	List<Siniestro> findByNumeroPolizaOrderByIndemnizacionAsc(Integer numeroPoliza);

	List<Siniestro> findByFechaSiniestroLikeAndAceptadoEquals(String fechaSiniestro, String aceptado);

	List<Siniestro> findByIndemnizacionAfter(Double indemnizacion);
	
	@Query("SELECT new com.prac2.practica2.dto.SiniestroPeritoDto(s.fechaSiniestro,"
			+ " s.causa,"
			+ " s.indemnizacion,"
			+ " p.dniPerito,"
			+ " p.nombrePerito)"
			+ " FROM Siniestro s"
			+ " JOIN s.perito p"
			+ " WHERE s.causa LIKE %:causa%"
			+ " ORDER BY s.fechaSiniestro ASC, s.indemnizacion DESC")
	List<SiniestroPeritoDto> buscarPorCausa(String causa);

}
