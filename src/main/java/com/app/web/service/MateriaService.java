package com.app.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.web.model.Materia;
import com.app.web.repository.r.MateriaRepository;

@Service 
public class MateriaService {
@Autowired
private MateriaRepository materiarepository;


	
public List<Materia>buscar(){
	return materiarepository.findAll();
}
public Materia insertar(Materia materia) {
	return materiarepository.save(materia);
}
public Materia actualizar (Materia materia) {
	return materiarepository.save(materia);
}
public void eliminar(int id) {
	materiarepository.deleteById(id);
}
}
