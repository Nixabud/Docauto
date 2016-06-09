package com.sysview.docauto.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.sysview.docauto.dao.UsuarioDAO;
import com.sysview.docauto.model.Usuario;

@Component("usuarioDao")
public class UsuarioDAOImpl implements UsuarioDAO{
	
	private static final Logger log = LoggerFactory.getLogger(UsuarioDAOImpl.class);
	DataSource dataSource;
	
	public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Usuario> getUsuario() {
		log.debug("Consultando Usuarios...");
	
        List<Usuario> user= jdbcTemplate.query(
        "select * from USUARIOPROPIO",
        new RowMapper<Usuario>() {
            public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {
            	Usuario user = new Usuario();
            	user.setUsuario(rs.getString("USUARIOPROPIO"));
            	user.setNombreusr(rs.getString("USUARIOPROPIONOMBRE"));
            	user.setApellidopat(rs.getString("USUARIOPROPIOPATERNO"));
            	user.setApellidomat(rs.getString("USUARIOPROPIOMATERNO"));
                user.setPassword(rs.getString("USUARIOPROPIOPASSWORD"));
                user.setCorreo(rs.getString("USUARIOPROPIOCORREO"));
                return user;
            }
        });
        log.debug("usuario: {}", user.toString());
        return user;
	}

	
		public void insertUsuario(Usuario user) {	//, String nombre, String appat, String apmat, String pswd, String correo
		log.debug("Creando Usuario...");
		String sql="insert into USUARIOPROPIO values(?,?,?,?,?,?)";
		jdbcTemplate.update(sql, new Object[] {user.getUsuario(),user.getNombreusr(),user.getApellidopat(),user.getApellidomat(),
				user.getPassword(),user.getCorreo()});        
	}

	
		
	@Override
	public void updateUsuario(Usuario user) {
		String sql="UPDATE USUARIOPROPIO set USUARIOPROPIONOMBRE = ?, USUARIOPROPIOPATERNO = ?, "
				+ "USUARIOPROPIOMATERNO = ?, USUARIOPROPIOPASSWORD = ?, USUARIOPROPIOCORREO = ? where USUARIOPROPIO=?";
						
		jdbcTemplate.update(sql, new Object[]{user.getNombreusr(), user.getApellidopat(), 
				user.getApellidomat(),user.getPassword(),user.getCorreo(),user.getUsuario()});		
	}  
		
		

	@Override
	public void deleteUsuario(Usuario user) {
		String sql="delete from USUARIOPROPIO where USUARIOPROPIO=?";
		jdbcTemplate.update(sql, user.getUsuario());		
	}

	/*
	@Override
	public Usuario getuser(String usuario) {
		Usuario gusuario = new Usuario();
		return gusuario;
	}


	@Override
	public Usuario getuser(suario usuario) {
		// TODO Auto-generated method stub
		return null;
	}*/


	/*public Usuario get(Usuario user) {
		String sql= "select * from USUARIOPROPIO where USUARIOPROPIO=?";
		return jdbcTemplate.query(sql,new ResultSetExtractor<Usuario>(){
        
			//@Override
            public Usuario extractuser(ResultSet rs) throws SQLException,
            DataAccessException{
				if(rs.next()){
	            	Usuario miuser = new Usuario();
	            	miuser.setUsuario(rs.getString("USUARIOPROPIO"));
	            	miuser.setNombreusr(rs.getString("USUARIOPROPIONOMBRE"));
	            	miuser.setApellidopat(rs.getString("USUARIOPROPIOPATERNO"));
	            	miuser.setApellidomat(rs.getString("USUARIOPROPIOMATERNO"));
	                miuser.setPassword(rs.getString("USUARIOPROPIOPASSWORD"));
	                miuser.setCorreo(rs.getString("USUARIOPROPIOCORREO"));
	                return miuser;
				}
		return null;
	}

			@Override
			public Usuario extractData(ResultSet rs) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				return null;
			}
		});
	}*/
}