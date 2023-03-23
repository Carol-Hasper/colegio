package com.app.web.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.web.model.Calificacion;
import com.app.web.service.CalificacionService;

@RestController
@RequestMapping("calificacion/")
public class CalificacionController {
@Autowired
	private CalificacionService servicio;

@GetMapping("buscar")
List<Calificacion>buscar(){
	return servicio.buscar();
}
@PostMapping
public Calificacion insertar(@RequestBody Calificacion nota) {
	return servicio.insertar(nota);
}
@PutMapping("save")
public Calificacion actualizar(@RequestBody Calificacion nota) {
	return servicio.actualizar(nota);
}

@GetMapping
public void eliminar(int id) {
	servicio.eliminar(id);
}
@GetMapping("finById/{id}")
public Object finById(@PathVariable ("id") Integer id){
	
	Optional<Calificacion> calificacionById= servicio.finById(id);
		
	if(calificacionById.isEmpty()) {
		return "no encontrado";
	}else {
	}
	return calificacionById;
}		


@GetMapping("getPromedio/{idAlumno}/{idMateria}")
public String getPromedio(@PathVariable("idAlumno")Integer idAlumo,@PathVariable("idMateria")Integer idMateria) {
return servicio.getPromedio(idAlumo, idMateria);
}
@GetMapping("getnotaByAlumnoIdSql/{id}")
public List<String> getnotaByAlumnoIdSql(@PathVariable("id")String id){
	return servicio.getnotaByAlumnoIdSql(id);
}

}