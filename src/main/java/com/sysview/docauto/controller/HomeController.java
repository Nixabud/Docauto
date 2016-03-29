package com.sysview.docauto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sysview.service.PlataformaService;

@Controller
@RequestMapping("/")
public class HomeController {
   
	@Autowired 
	@Qualifier("plataformaService")
	private PlataformaService plataformaService;
    @RequestMapping(method=RequestMethod.GET)
    public String home() {
    	plataformaService.getListP();
        return "busqueda";
    }
}

