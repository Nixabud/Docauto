package com.sysview.docauto.dao;

import java.util.List;

import com.sysview.docauto.model.Usuario;

public interface UsuarioDAO {
	
	public List<Usuario> getUsuarios();
	//public Usuario insertUsuario(Usuario user, String nombre, String appat, String apmat, String pswd, String correo);
	//public Usuario deleteUsuario(String user);
	Usuario insertUsuario(String user, String nombre, String appat, String apmat, String pswd, String correo);
	Usuario deleteUsuario(Usuario user);
}
