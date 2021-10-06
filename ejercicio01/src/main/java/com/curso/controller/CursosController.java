package com.curso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.curso.model.Curso;
import com.curso.service.CursosService;

@RestController
public class CursosController {

	@Autowired
	CursosService cursosService;
	
	@PostMapping(value="curso", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> altaCurso (@RequestBody Curso curso) {
		return cursosService.altaCurso(curso);
	}
	
	@DeleteMapping(value="curso/{codCurso}", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> eliminacionCurso (@PathVariable int codCurso) {
		return cursosService.eliminarCurso(codCurso);
	}
	
	@GetMapping(value="curso/{codCurso}/{duracion}")
	public void actualizacionDuracion (@PathVariable int codCurso, @PathVariable int duracion) {
		cursosService.actualizarDuracion(codCurso, duracion);
	}
	
	@GetMapping(value="curso/{codCurso}", produces=MediaType.APPLICATION_JSON_VALUE)
	public Curso buscarCurso (@PathVariable int codCurso) {
		return cursosService.buscarCurso(codCurso);
	}

	@GetMapping(value="cursos/{precioMinimo}/{precioMaximo}", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> cursosPorPrecio (@PathVariable double precioMinimo, @PathVariable double precioMaximo) {
		return cursosService.cursosPorPrecio(precioMinimo, precioMaximo);
	}	
}
