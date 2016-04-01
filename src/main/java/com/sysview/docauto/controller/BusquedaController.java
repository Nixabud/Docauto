package com.sysview.docauto.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sysview.docauto.dao.impl.PlataformaDAOImpl;
import com.sysview.docauto.model.Plataforma;
import com.sysview.docauto.service.PlataformaService;

@Controller
public class BusquedaController {
	
	private static final Logger log = LoggerFactory.getLogger(BusquedaController.class);
 
    @Autowired
    private PlataformaService plataformaService;
    
    @RequestMapping(value="/busqueda",method=RequestMethod.GET)
    public String home(Model model) {
        List<Plataforma> plataformas = plataformaService.getListP();
        model.addAttribute("plataformas", plataformas);
        model.addAttribute("name", "asldhaskdh");
        model.addAttribute("plataforma", plataformas.get(0));
        log.debug("plataformas: {}", plataformas);
        return "busqueda";
    }
}
