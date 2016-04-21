package com.sysview.docauto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sysview.docauto.model.Componente;
import com.sysview.docauto.service.ComponenteService;

@RestController
@RequestMapping("/componentes")
public class ComponenteController {
	
	@Autowired ComponenteService componenteService;
	
	@RequestMapping(value = "/",
		method = RequestMethod.POST,
		headers = "Accept=" + MediaType.APPLICATION_JSON_VALUE,
		consumes = MediaType.APPLICATION_JSON_VALUE,
		produces = MediaType.APPLICATION_JSON_VALUE)
	 public ResponseEntity<List<Componente>> componentesel(@RequestBody Componente componente){
		List<Componente> componentes = componenteService.filterByComponente(componente);
		return new ResponseEntity<List<Componente>>(componentes, HttpStatus.OK);
	}

}
