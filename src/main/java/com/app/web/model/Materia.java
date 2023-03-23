package com.app.web.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name="materia")
public class Materia {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String nombre;
	
	
	
	public Materia() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Materia(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	@Override
	public String toString() {
		return "Materia [id=" + id + ", nombre=" + nombre + "]";
	}
	
	
}
