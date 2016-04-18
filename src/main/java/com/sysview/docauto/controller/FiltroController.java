package com.sysview.docauto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sysview.docauto.model.Biblioteca;
import com.sysview.docauto.model.Clase;
import com.sysview.docauto.model.Plataforma;
import com.sysview.docauto.model.Sistema;
import com.sysview.docauto.service.BibliotecaService;
import com.sysview.docauto.service.ClaseService;
import com.sysview.docauto.service.PlataformaService;
import com.sysview.docauto.service.SistemaService;


@RestController
@RequestMapping ("/filter")
public class FiltroController{
	
	 @Autowired
	 private SistemaService sistemaService;
	 @Autowired
	 private PlataformaService plataformaService;
	 @Autowired
	 private ClaseService claseService;
	 @Autowired
	 private BibliotecaService bibliotecaService;
	 
	 @RequestMapping(value="/sistemas/{plataformaId}", method=RequestMethod.GET)
	 public List<Sistema> platsel(@PathVariable("plataformaId") String plataformaId) { 
	  return sistemaService.findByPlataforma(plataformaId);
	 }
	 
	 @RequestMapping(value="/plataformas/{sistemaId}", method=RequestMethod.GET)
	 public List<Plataforma> sistsel(@PathVariable("sistemaId") String sistemaId){
		return plataformaService.findBySistema(sistemaId);		 
	 }
	 
	 @RequestMapping(value="/clases/{sistemaId}", method=RequestMethod.GET)
	 public List<Clase> clasesel(@PathVariable("sistemaId") String sistemaId){
		return claseService.findBySistemas(sistemaId);		 
	 }
	 
	 @RequestMapping(value="/bibliotecas/{claseId}", method=RequestMethod.GET)
	 public List<Biblioteca> bibsel(@PathVariable("claseId") String claseId){
		return bibliotecaService.findByClase(claseId);		 
	 }
}
