package com.prac2.practica2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.library.entity.prac2user.CompaniaSeguro;

@Repository("companiaSeguroRepository")
public interface CompaniaSeguroRepository extends JpaRepository<CompaniaSeguro, Integer> {

}
