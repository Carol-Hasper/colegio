package com.app.web.repository.r;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.web.model.Alumno;
@Repository
public interface AlumnoRepository extends JpaRepository <Alumno,Integer> {

}
