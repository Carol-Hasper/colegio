package com.app.web.repository.r;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.web.model.Materia;

@Repository
public interface MateriaRepository extends JpaRepository<Materia , Integer> {

}
