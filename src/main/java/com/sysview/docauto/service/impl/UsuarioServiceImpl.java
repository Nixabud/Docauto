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
	public List<Usuario> getUsuariouser() {

		return usuarioDao.getUsuarios();
	}

	@Override
	public List<Usuario> getUsuarionombre() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Usuario> getUsuarioappat() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Usuario> getUsuarioapmat() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Usuario> getUsuariopassword() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Usuario> getUsuariocorreo() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
