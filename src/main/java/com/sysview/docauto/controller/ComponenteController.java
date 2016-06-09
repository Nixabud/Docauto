package com.sysview.docauto.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sysview.docauto.model.Componente;
import com.sysview.docauto.model.Usuario;
import com.sysview.docauto.service.ComponenteService;

@RestController
@RequestMapping("/cmps")
public class ComponenteController {
    
    private static final Logger log = LoggerFactory.getLogger(ComponenteController.class);
	
	@Autowired ComponenteService componenteService;
	
	@RequestMapping(value = "/comcon",
		method = RequestMethod.POST,
		headers = "Accept=" + MediaType.APPLICATION_JSON_VALUE,
		consumes = MediaType.APPLICATION_JSON_VALUE,
		produces = MediaType.APPLICATION_JSON_VALUE)
	 public ResponseEntity<List<Componente>> componentesel(@RequestBody Componente componente){
		List<Componente> componentes = componenteService.filterByComponente(componente);
		  log.debug("plataforma: {}", componente.getPlataformaID());
	      log.debug("sistema: {}", componente.getSistemaID());
	      log.debug("biblioteca: {}", componente.getBibliotecaId());
	      log.debug("clase: {}", componente.getClaseId());
		return new ResponseEntity<List<Componente>>(componentes, HttpStatus.OK);
	}
	
	@RequestMapping(value="/filtro", method = RequestMethod.GET)
	public String cmpfiltro(Model model) {
		List <Componente> lcmp= componenteService.cmpfiltro();
		model.addAttribute("Componente",lcmp);
		return "index";
	}
}
