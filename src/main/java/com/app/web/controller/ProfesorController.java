package com.app.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.web.model.Profesor;
import com.app.web.service.ProfesorService;

@RestController
@RequestMapping("profesor")
public class ProfesorController {

	
	@Autowired
	private ProfesorService service;
	
	@GetMapping("obtener")
	public List<Profesor>obtener(){
		return service.buscar();
	}
	@PostMapping
	public Profesor insertar(@RequestBody Profesor profe) {
		return service.insertar(profe);
	}
	@PutMapping
	public Profesor actualizar(@RequestBody Profesor profe) {
		return service.actualizar(profe);
	}
	
	@GetMapping
	public void eliminar(int id) {
		service.eliminar(id);
	}
}
