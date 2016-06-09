package com.sysview.docauto.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sysview.docauto.dao.UsuarioDAO;
import com.sysview.docauto.model.Usuario;
import com.sysview.docauto.service.UsuarioService;

@Service("usuarioService")
public class UsuarioServiceImpl implements UsuarioService{
	
	@Autowired
	private UsuarioDAO usuarioDao;

	@Override
	public List<Usuario> getUsuario() {
		// TODO Auto-generated method stub
		return usuarioDao.getUsuario();
	}
		
	@Override
	public void insertUsuario(Usuario user) {
		usuarioDao.insertUsuario(user);
		
	}
	
	@Override
	public void updateUsuario(Usuario user) {
		// TODO Auto-generated method stub
		//Usuario updateuser = new Usuario();
		//updateuser.getUsuario();
		usuarioDao.updateUsuario(user);
		
	}
	@Override
	public void deleteUsuario(Usuario user) {
		usuarioDao.deleteUsuario(user);
		
	}
	
	/*
	@Override
	public Usuario getusuario(String user){
		return usuarioDao.getuser(user);
	}*/
	
	
}
