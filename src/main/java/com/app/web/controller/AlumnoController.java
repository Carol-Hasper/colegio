package com.app.web.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.app.web.model.Alumno;
import com.app.web.service.AlumnoService;
import com.itextpdf.text.DocumentException;

@RestController
@RequestMapping("alumno")
public class AlumnoController {
	
	@Autowired
	private AlumnoService servicio;
	
	
	@GetMapping("obtengoTodo")
	public List<Alumno>obtener(){
		return servicio.buscar();
	}
	@PostMapping
	public Alumno insertar(@RequestBody Alumno alumno) {
		return servicio.insertar(alumno);
	}
	@PutMapping
	public Alumno actualizar(@RequestBody Alumno alumno) {
		return servicio.actualizar(alumno);
	}

	@GetMapping
	public void eliminar(int id) {
		servicio.eliminar(id);
	}
	@GetMapping("generarPdf")
	public byte[] generarPdf(HttpServletResponse response) throws IOException, DocumentException {
	return servicio.generarPdf(response);
	}}
	