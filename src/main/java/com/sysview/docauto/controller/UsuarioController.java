package com.sysview.docauto.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sysview.docauto.dao.UsuarioDAO;
import com.sysview.docauto.model.Usuario;
import com.sysview.docauto.service.UsuarioService;

@Controller
@RequestMapping("/up")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;

	/*@RequestMapping(value="/usuariopropio.html/",
			   method=RequestMethod.GET,
			   headers="Accept=" + MediaType.APPLICATION_JSON_VALUE,
			   produces = MediaType.APPLICATION_JSON_VALUE)
	public String Usuario(/*@RequestBody Usuario usuario*//*){*/
		//Usuario user = usuarioService.insertUsuario(user, nombre, appat, apmat, pswd, correo);
		/*return "/usuariopropio.html/";  
	}*/
			 	 
	 @RequestMapping(value= "/getusr", method = RequestMethod.GET)
	    public String getUsuario(Model model) {
	          List<Usuario>  us = usuarioService.getUsuario();
	          model.addAttribute("UsuarioPropio",us);
	          /*model.addAttribute("USUARIOPROPIONOMBRE",us);
	          model.addAttribute("USUARIOPROPIOPATERNO",us);
	          model.addAttribute("USUARIOPROPIOMATERNO",us);
	          model.addAttribute("USUARIOPROPIOPASSWORD",us);
	          model.addAttribute("USUARIOPROPIOCORREO",us);*/
	          return "usuariopropio";
	    }
	
    @RequestMapping(value = "/insertUsuario", method = RequestMethod.POST)
    public String insertUsuario(@ModelAttribute("usuario") Usuario user,BindingResult result) {
           usuarioService.insertUsuario(user);
           //System.out.println("asdlkfjhasiekrhqwiophadnfj");
          return "usuariopropio";
    }
    
    
    @RequestMapping(value = "/deleteUsuario", method = RequestMethod.GET)
    public String deleteUsuario(Usuario user,BindingResult result) {
    	 usuarioService.deleteUsuario(user);
         System.out.println("Usuario Eliminado");
         return "usuariopropio";
    }
    
    /*@RequestMapping(value = "/deleteUsuario", method = RequestMethod.GET)
    public String deleteUsuario(Us model) {
    	 List<Usuario> delus = usuarioService.getUsuario();
    	 model.addAttribute("UsuarioPropio",delus);
         System.out.println("Usuario Eliminado");
         return "usuariopropio";
    }*/
    
    /*@RequestMapping(value = "/updateUsuario", method = RequestMethod.GET)
    public ModelAndView updateuserpage(@ModelAttribute String usuario){
    	ModelAndView modelandview= new ModelAndView("formulario de edicion");
    	Usuario usr = usuarioService.getusuario(usuario);
    	modelandview.addObject("usuario",usr);
    	System.out.println("Usuario obtenido");
        return modelandview;
    }*/
    
    
    @RequestMapping(value = "/updateUsuario", method = RequestMethod.POST)
    public String updateUsuario(@ModelAttribute("usuario") Usuario user) {
    	usuarioService.updateUsuario(user);
    	System.out.println("Usuario Actualizado");
        return "usuariopropio";
    }
    
    
    /*
    @RequestMapping(value = "/updateUsuario", method = RequestMethod.POST)
    public String updateUsuario(@ModelAttribute("usuario") Usuario user,BindingResult result) {
    	//List<Usuario>  upuser = usuarioService.updateUsuario(upuser);
    	usuarioService.updateUsuario(user);
    	System.out.println("Usuario Actualizado");
        return "usuariopropio";
    }*/
     

}