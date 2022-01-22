package com.prac2.practica2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.library.entity.prac2user.Seguro;

@Repository("seguroRepository")
public interface SeguroRepository extends JpaRepository<Seguro, Integer> {

}
