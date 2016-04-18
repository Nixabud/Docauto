package com.sysview.docauto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sysview.docauto.service.PlataformaService;

@Controller
public class LoginController {
    
    @Autowired
    private PlataformaService plataformaService;
    
    @RequestMapping("/login")
    public String login() {
//        plataformaService.initialize();
        return "login";
    }
}
