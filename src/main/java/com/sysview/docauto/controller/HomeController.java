package com.sysview.docauto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sysview.docauto.model.Biblioteca;
import com.sysview.docauto.model.Clase;
import com.sysview.docauto.model.Plataforma;
import com.sysview.docauto.model.Sistema;
import com.sysview.docauto.service.BibliotecaService;
import com.sysview.docauto.service.ClaseService;
import com.sysview.docauto.service.PlataformaService;
import com.sysview.docauto.service.SistemaService;

@Controller
@RequestMapping("/")
public class HomeController {
    
    @Autowired
    private PlataformaService plataformaService;
    @Autowired
    private SistemaService sistemaService;
    @Autowired
    private ClaseService claseService;
    @Autowired
    private BibliotecaService bibliotecaService;
    
    @RequestMapping(method=RequestMethod.GET)
    public String home(Model model) {
        List<Plataforma> plataformas = plataformaService.getPlataformas();
        List<Sistema> sistemas = sistemaService.getSistemas();
        List<Clase> clases = claseService.getClase();
        List<Biblioteca> bibliotecas = bibliotecaService.getBibliotecas();
        model.addAttribute("plataformas", plataformas);
        model.addAttribute("sistemas", sistemas);
        model.addAttribute("clases", clases);
        model.addAttribute("bibliotecas", bibliotecas);
        return "index";
    }
        
}