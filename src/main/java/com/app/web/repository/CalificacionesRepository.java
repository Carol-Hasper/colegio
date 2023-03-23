package com.app.web.repository;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.app.web.coneccionHib.ConeccionHiernate;
import com.google.common.base.Functions;
import com.google.common.collect.Lists;
@Repository
public class CalificacionesRepository {
	@SuppressWarnings("unchecked")
	public List<String> getnotaByAlumnoIdSQL(String alumnoid) {
        try {
            Session miSesion = ConeccionHiernate.tomarConexion();
            miSesion.beginTransaction();
            Query<String> q = miSesion.createQuery("select nota from Calificacion where alumnoid="+alumnoid);
            List<String> nota= Lists.transform(q.list(), Functions.toStringFunction());
            miSesion.close();
            return nota;    
            
        } catch (HibernateException ex) {
        	ex.printStackTrace();
        	return null;
        }
    }
}
