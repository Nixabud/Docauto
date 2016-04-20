package com.sysview.docauto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sysview.docauto.model.Usuario;
import com.sysview.docauto.service.UsuarioService;

@Controller
@RequestMapping("/usuariopropio")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String usuariopropio(Model model){
		List<Usuario> user=usuarioService.getUsuariouser();
		List<Usuario> username=usuarioService.getUsuarionombre();
		List<Usuario> userpat=usuarioService.getUsuarioappat();
		List<Usuario> usermat=usuarioService.getUsuarioapmat();
		List<Usuario> userpass=usuarioService.getUsuariopassword();
		List<Usuario> usermail=usuarioService.getUsuariocorreo();
		model.addAttribute("usuario", user);
		model.addAttribute("nombre", username);
		model.addAttribute("apellido paterno", userpat);
		model.addAttribute("apellido materno", usermat);
		model.addAttribute("password", userpass);
		model.addAttribute("correo", usermail);
		return "usuariopropio";
	}

}