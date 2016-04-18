package com.sysview.docauto.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.sysview.docauto.dao.ComponenteDAO;
import com.sysview.docauto.model.Componente;
import com.sysview.docauto.model.Filter;
import com.sysview.docauto.model.Sistema;

@Component ("componenteDao")
public class ComponenteDaoImpl implements ComponenteDAO{
	  private static final Logger log = LoggerFactory.getLogger(SistemaDAOImpl.class);
	  @Autowired
	    JdbcTemplate jdbcTemplate;
	  
	  public List<Componente> findcomponente(Componente componente){
		  
		  log.debug("consultando Componentes...");
	        
	        List<Componente> componentes = jdbcTemplate.query(
	        "select * from CONSULTA",
	        new RowMapper<Componente>() {
	            public Componente mapRow(ResultSet rs, int rowNum) throws SQLException {
	                Componente componente = new Componente();
	                componente.setPlataformaID(rs.getString("PLATAFORMAID"));
	                componente.setSistemaID(rs.getString("SISTEMAID"));
	                componente.setClaseId(rs.getString("CLASEID"));
	                componente.setBibliotecaId(rs.getString("BIBLIOTECAID"));
	                componente.setComponenteId(rs.getString("COMPONENTE"));
	                
	                return componente;
	            }
	        });
	        log.debug("componente: {}", componentes.toString());
	        return componentes;
	    }

	@Override
	public List<Componente> findcomponente(Filter filter) {
		// TODO Auto-generated method stub
		return null;
	}	  
		  
}
