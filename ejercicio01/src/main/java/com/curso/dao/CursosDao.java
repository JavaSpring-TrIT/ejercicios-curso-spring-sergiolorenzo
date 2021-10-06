package com.curso.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.curso.model.Curso;

public interface CursosDao extends JpaRepository<Curso, Integer> {

	@Query("Select c from Curso c Where c.precio >=?1 AND c.precio <=?2")
	List<Curso> cursosPorPrecio(double precioMinimo, double precioMaximo);
}
