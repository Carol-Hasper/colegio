package com.app.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.web.model.Materia;
import com.app.web.service.MateriaService;

@RestController
@RequestMapping("materia")
public class MateriaController {
@Autowired
	private  MateriaService servicio;

@GetMapping("obtengoTodos")
public List<Materia>obtener(){
	return servicio.buscar();
}
@PostMapping
public Materia insertar(@RequestBody Materia materia) {
	return servicio.insertar(materia);
}
@PutMapping
public Materia actualizar(@RequestBody Materia materia) {
	return servicio.actualizar(materia);
}

@GetMapping
public void eliminar(int id) {
	servicio.eliminar(id);
}
}
