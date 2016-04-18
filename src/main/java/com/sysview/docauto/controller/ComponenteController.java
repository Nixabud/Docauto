package com.sysview.docauto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sysview.docauto.model.Componente;
import com.sysview.docauto.model.Filter;
import com.sysview.docauto.service.ComponenteService;

@RestController
@RequestMapping("/componentes")
public class ComponenteController {
	
	@Autowired ComponenteService componenteService;
	
	@RequestMapping(value="/componentes", method=RequestMethod.POST)
	 public List<Componente> componentesel(@RequestBody Filter filter){
		return componenteService.filterByComponente(filter);		
	}

}
