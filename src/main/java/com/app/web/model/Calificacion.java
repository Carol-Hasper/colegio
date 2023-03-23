package com.app.web.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity 
@Table(name="calificacion")
public class Calificacion {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private Double nota;
	@ManyToOne
    @JoinColumn(name = "profesorid")
	private Profesor profesor;
	@ManyToOne
    @JoinColumn(name = "materiaid")
	private Materia materia;
	@ManyToOne
    @JoinColumn(name = "alumnoid")
	private Alumno alumno;
	
	
	public Calificacion() {
		super();
	}
		
public Calificacion(int id, Double nota, Profesor profesor, Materia materia, Alumno alumno) {
		super();
		this.id = id;
		this.nota = nota;
		this.profesor = profesor;
		this.materia = materia;
		this.alumno = alumno;
	}


	public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public Double getNota() {
	return nota;
}

public void setNota(Double nota) {
	this.nota = nota;
}

public Profesor getProfesor() {
	return profesor;
}

public void setProfesor(Profesor profesor) {
	this.profesor = profesor;
}

public Materia getMateria() {
	return materia;
}

public void setMateria(Materia materia) {
	this.materia = materia;
}

public Alumno getAlumno() {
	return alumno;
}

public void setAlumno(Alumno alumno) {
	this.alumno = alumno;
}

	@Override
	public String toString() {
		return "Calificacion [id=" + id + ", nota=" + nota + ", profesor=" + profesor + ", materia=" + materia
				+ ", alumno=" + alumno + "]";
	}}