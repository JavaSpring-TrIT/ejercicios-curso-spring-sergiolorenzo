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

import com.curso.model.Formacion;
import com.curso.service.FormacionService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
public class FormacionController {

	@Autowired
	FormacionService formacionService;
	
	@ApiOperation(value = "Da de alta una formación")
	@PostMapping(value="formacion", consumes=MediaType.APPLICATION_JSON_VALUE)
	public void altaCurso (@ApiParam(value = "JSON con los datos de la formación") @RequestBody Formacion formacion) {
		formacionService.altaFormacion(formacion);
	}
	
	@ApiOperation(value = "Busca todas las formaciones")
	@GetMapping(value="formaciones", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Formacion> buscarCursos () {
		return formacionService.buscarFormaciones();
	}
}
