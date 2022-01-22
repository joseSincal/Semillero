package com.prac2.practica2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.library.entity.prac2user.Siniestro;

@Repository("siniestroRepository")
public interface SiniestroRepository extends JpaRepository<Siniestro, Integer> {
	
	List<Siniestro> findByAceptadoLike(String aceptado);
	List<Siniestro> findByIndemnizacionLessThanEqual(Double indemnizacion);
	List<Siniestro> findByIndemnizacionBetween(Double indemnizacion, Double indemnizacion2);
	List<Siniestro> findByNumeroPolizaOrderByIndemnizacionAsc(Integer numeroPoliza);
	List<Siniestro> findByFechaSiniestroLikeAndAceptadoEquals(String fechaSiniestro, String aceptado);

}
