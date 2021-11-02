package com.curso.service;

import java.util.List;

import com.curso.model.Curso;

public interface CursosService {

	List<Curso> altaCurso(Curso curso);
	
	List<Curso> eliminarCurso(int codCurso);
	
	void actualizarDuracion(int codCurso, int duracion) ;
	
	Curso buscarCurso(int codCuso);
	
	List<Curso> cursosPorPrecio(double precioMinimo, double precioMaximo);
}
