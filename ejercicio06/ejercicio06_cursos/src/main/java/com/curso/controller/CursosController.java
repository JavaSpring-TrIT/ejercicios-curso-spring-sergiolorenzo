package com.curso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.curso.model.Curso;
import com.curso.service.CursosService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
public class CursosController {

	@Autowired
	CursosService cursosService;
	
	@ApiOperation(value = "Da de alta un curso")
	@PostMapping(value="curso", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> altaCurso (
			@ApiParam(value = "JSON con los datos del curso") @RequestBody Curso curso) {
		return cursosService.altaCurso(curso);
	}
	
	@ApiOperation(value = "Elimina un curso en base a su código")
	@DeleteMapping(value="curso/{codCurso}", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> eliminacionCurso (
			@ApiParam(value = "Código del curso a eliminar") @PathVariable int codCurso) {
		return cursosService.eliminarCurso(codCurso);
	}
	
	@ApiOperation(value = "Actualiza la duración de un curso")
	@GetMapping(value="curso/{codCurso}/{duracion}")
	public void actualizacionDuracion (
			@ApiParam(value = "Código del curso a actualizar") @PathVariable int codCurso, 
			@ApiParam(value = "Nueva duración del curso") @PathVariable int duracion) {
		cursosService.actualizarDuracion(codCurso, duracion);
	}
	
	@ApiOperation(value = "Busca un curso por su código")
	@GetMapping(value="curso/{codCurso}", produces=MediaType.APPLICATION_JSON_VALUE)
	public Curso buscarCurso (
			@ApiParam(value = "Código del curso a buscar") @PathVariable int codCurso) {
		return cursosService.buscarCurso(codCurso);
	}

	@ApiOperation(value = "Busca cursos en base a un rango de precios")
	@GetMapping(value="cursos/{precioMinimo}/{precioMaximo}", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> cursosPorPrecio (
			@ApiParam(value = "Límite inferior del precio para la búsqueda") @PathVariable double precioMinimo, 
			@ApiParam(value = "Límite superior del precio para la búsqueda") @PathVariable double precioMaximo) {
		return cursosService.cursosPorPrecio(precioMinimo, precioMaximo);
	}	
}
