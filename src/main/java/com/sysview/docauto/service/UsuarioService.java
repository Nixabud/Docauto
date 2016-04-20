package com.sysview.docauto.service;

import java.util.List;

import com.sysview.docauto.model.Usuario;

public interface UsuarioService {
	
	List<Usuario> getUsuariouser();
	List<Usuario> getUsuarionombre();
	List<Usuario> getUsuarioappat();
	List<Usuario> getUsuarioapmat();
	List<Usuario> getUsuariopassword();
	List<Usuario> getUsuariocorreo();

}
