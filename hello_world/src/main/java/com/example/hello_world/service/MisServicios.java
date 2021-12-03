package com.example.hello_world.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/miServicio")
public class MisServicios {
	
	@GetMapping(path="/helloWorld/{nombre}")
	public String helloWorld(@PathVariable("nombre") String nombre) {
		return "Hello " + nombre + ", have a nice day.";
	}
}
