package com.app.web.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.web.model.Calificacion;
import com.app.web.repository.CalificacionesRepository;
import com.app.web.repository.r.CalificacionRepository;
@Service
public class CalificacionService {
	
	@Autowired
	private CalificacionesRepository calificacionesRepository;
@Autowired
	private CalificacionRepository calificacionrepository;
	public String guardar(Calificacion nota) {
		try {
			calificacionrepository.save(nota);
			return "Exito al guardar calificacion";
		}catch(Exception ex) {
			return ex.getMessage();
		}}
	public List<Calificacion>buscar(){
		return calificacionrepository.findAll();
		
	}
	public Calificacion insertar(Calificacion nota) {
		return calificacionrepository.save(nota);
	}
	public Calificacion actualizar (Calificacion nota) {
		return calificacionrepository.save(nota);
	}
	public Optional<Calificacion> finById(Integer id) {
		return calificacionrepository.findById(id);
	}
	public void eliminar(int id) {
		calificacionrepository.deleteById(id);
	}
	public String getPromedio(Integer idAlumno, Integer idMateria) {
		List<Calificacion>calificacion=calificacionrepository.findAll();
		Double tNotas=0.00;
		Double promedio=0.00;
		Double contador=0.00;
		for(Calificacion calificaciones:calificacion) {
			if(calificaciones.getAlumno().getId()==idAlumno && calificaciones.getMateria().getId()==idMateria) {
				tNotas=tNotas+calificaciones.getNota();
				contador+=1.00;
			}
		}
		promedio=tNotas/contador;
		return promedio.toString();
	}
	public List<String> getnotaByAlumnoIdSql(String id) {
		return calificacionesRepository.getnotaByAlumnoIdSQL(id);
	}
}
