package com.app.web.coneccionHib;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.app.web.model.Alumno;
import com.app.web.model.Calificacion;
import com.app.web.model.Materia;
import com.app.web.model.Profesor;



public class ConeccionHiernate {
	 public static Session tomarConexion() {
	        SessionFactory sf = new Configuration()
	                .configure("hibernate.xml")
	                .addAnnotatedClass(Alumno.class)
	                .addAnnotatedClass(Calificacion.class)
	                .addAnnotatedClass(Materia.class)
	                .addAnnotatedClass(Profesor.class)
	                .buildSessionFactory();
	        return sf.getCurrentSession();
	    }

}
