package com.prac2.practica2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prac2.practica2.entity.CompaniaSeguro;

@Repository("companiaSeguroRepository")
public interface CompaniaSeguroRepository extends JpaRepository<CompaniaSeguro, Integer> {

}
