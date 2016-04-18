package com.sysview.docauto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sysview.docauto.model.Filter;
import com.sysview.docauto.model.Sistema;
import com.sysview.docauto.service.BibliotecaService;
import com.sysview.docauto.service.ClaseService;
import com.sysview.docauto.service.PlataformaService;
import com.sysview.docauto.service.SistemaService;

@RestController
public class FilterController {
	

	@Autowired
	private SistemaService sistemaService;
	@Autowired
	private PlataformaService plataformaService;
	@Autowired
	private ClaseService claseService;
	@Autowired
	private BibliotecaService bibliotecaService;
	 
	 
	@RequestMapping("filterBy/plataforma/{plataformaId}") 
	public Filter filterByPlataforma(@PathVariable String plataformaId) {
	return plataformaService.filterByPlataforma(plataformaId);
	}
	
	@RequestMapping("filterBy/sistema/{sistemaId}") 
	public Filter filterBySistema(@PathVariable String sistemaId) {
	return sistemaService.filterBySistema(sistemaId);
	}
	
	@RequestMapping("filterBy/clase/{claseId}") 
	public Filter filterByClase(@PathVariable String claseId) {
	return claseService.filterByClase(claseId);
	}
	
	@RequestMapping("filterBy/biblioteca/{bibliotecaId}") 
	public Filter filterByBiblioteca(@PathVariable String bibliotecaId) {
	return bibliotecaService.filterByBiblioteca(bibliotecaId);
	}
}
