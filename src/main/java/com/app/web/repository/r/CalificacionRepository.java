package com.app.web.repository.r;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.web.model.Calificacion;
@Repository
public interface CalificacionRepository extends JpaRepository <Calificacion,Integer> {


}
