package com.app.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.web.model.Profesor;
import com.app.web.repository.r.ProfesorRepository;

@Service
public class ProfesorService {

	@Autowired
	private ProfesorRepository profesorrepository;
	
	public List<Profesor>buscar(){
		return profesorrepository.findAll();
	}
	public Profesor insertar(Profesor profe) {
		return profesorrepository.save(profe);
	}
	public Profesor actualizar (Profesor profe) {
		return profesorrepository.save(profe);
	}
	public void eliminar(int id) {
		profesorrepository.deleteById(id);
	}
}
