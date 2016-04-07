package com.sysview.dao.impl.docauto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.sysview.dao.docauto.SistemaDAO;
import com.sysview.model.docauto.Sistema;

@Component("sistemaDao")
public class SistemaDAOImpl implements SistemaDAO {
	  private static final Logger log = LoggerFactory.getLogger(SistemaDAOImpl.class);
	    
	    @Autowired
	    JdbcTemplate jdbcTemplate;
	    
	    public void init() {
	        log.debug("creando tabla sistema...");
	    }

	    public Sistema getSistemaById(String sistemaId) {
	        return null;
	    }
	    
	    public List<Sistema> getSistemas() {
	        log.debug("consultando Sistemas...");
	        
	        List<Sistema> sistemas = jdbcTemplate.query(
	        "select SistemaID from Sistema",
	        new RowMapper<Sistema>() {
	            public Sistema mapRow(ResultSet rs, int rowNum) throws SQLException {
	                Sistema sistema = new Sistema(rs.getString(1));
	                return sistema;
	            }
	        });
	        log.debug("sistemas: {}", sistemas.toString());
	        return sistemas;
	    }	
	    
	    public List<Sistema> findbyPlataforma() {
	        log.debug("consultando Sistemas en base a la plataforma...");
	        
	        List<Sistema> sistemaspp = jdbcTemplate.query(
	        "select sistemaid from sistema where plataformaid = ?",
	        new RowMapper<Sistema>() {
	            public Sistema mapRow(ResultSet rs, int rowNum) throws SQLException {
	                Sistema sistemap = new Sistema(rs.getString(1));
	                return sistemap;
	            }
	        });
	        log.debug("sistemas: {}", sistemaspp.toString());
	        return sistemaspp;
	    }

}
