package com.prac2.practica2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages="com.library.entity")
public class Practica2Application {

	public static void main(String[] args) {
		SpringApplication.run(Practica2Application.class, args);
	}

}
