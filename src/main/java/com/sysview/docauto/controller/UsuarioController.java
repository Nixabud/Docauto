package com.sysview.docauto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UsuarioController {
	
	@RequestMapping("/usuariopropio")
	public String usuariopropio(){
		return "usuariopropio";
	}

}