package com.sysview.controller.docauto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sysview.model.docauto.Biblioteca;
import com.sysview.model.docauto.Clase;
import com.sysview.model.docauto.Plataforma;
import com.sysview.model.docauto.Sistema;
import com.sysview.service.docauto.BibliotecaService;
import com.sysview.service.docauto.ClaseService;
import com.sysview.service.docauto.PlataformaService;
import com.sysview.service.docauto.SistemaService;

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