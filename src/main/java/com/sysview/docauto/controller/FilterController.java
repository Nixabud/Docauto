package com.sysview.docauto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sysview.docauto.model.Filter;
import com.sysview.docauto.service.FilterService;

@RestController
public class FilterController {
	
	@Autowired
	private FilterService filterService;
	
	@RequestMapping("filterBy/plataforma/{plataformaId}") 
	public Filter filterByPlataforma(@PathVariable String plataformaId) {
	    return filterService.filterByPlataforma(plataformaId);
	}
	
	@RequestMapping("filterBy/sistema/{sistemaId}") 
	public Filter filterBySistema(@PathVariable String sistemaId) {
	    return filterService.filterBySistema(sistemaId);
	}
	
	@RequestMapping("filterBy/clase/{claseId}") 
	public Filter filterByClase(@PathVariable String claseId) {
	    return filterService.filterByClase(claseId);
	}
	
	@RequestMapping("filterBy/biblioteca/{bibliotecaId}") 
	public Filter filterByBiblioteca(@PathVariable String bibliotecaId) {
	    return filterService.filterByBiblioteca(bibliotecaId);
	}
}
