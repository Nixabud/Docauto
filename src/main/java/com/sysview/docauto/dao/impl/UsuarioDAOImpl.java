package com.sysview.docauto.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.sysview.docauto.dao.UsuarioDAO;
import com.sysview.docauto.model.Sistema;
import com.sysview.docauto.model.Usuario;

@Component("usuarioDao")
public class UsuarioDAOImpl implements UsuarioDAO{
	
	private static final Logger log = LoggerFactory.getLogger(UsuarioDAOImpl.class);
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Usuario> getUsuarios() {
		log.debug("consultando Usuarios...");
        
        List<Usuario> user= jdbcTemplate.query(
        "select * from USUARIOPROPIO",
        new RowMapper<Usuario>() {
            public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {
                Usuario user = new Usuario(rs.getString(1));
                return user;
            }
        });
        log.debug("usuarios: {}", user.toString());
        return user;
	}

	@Override
	public Usuario insertUsuario(String user, String nombre, String appat, String apmat, String pswd, String correo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario deleteUsuario(Usuario user) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
