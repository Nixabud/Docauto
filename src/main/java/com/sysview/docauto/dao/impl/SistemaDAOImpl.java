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

import com.sysview.docauto.dao.SistemaDAO;
import com.sysview.docauto.model.Filter;
import com.sysview.docauto.model.Sistema;

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
	    
	    public List<Sistema> findByPlataforma(String plataformaId) {
	        log.debug("consultando Sistemas en base a la plataforma...");
	        
	        List<Sistema> sistemaspp = jdbcTemplate.query(
	        "select distinct SISTEMAID from consulta where PLATAFORMAID=?",
	        new Object[]{ plataformaId},
	        new RowMapper<Sistema>() {
	            public Sistema mapRow(ResultSet rs, int rowNum) throws SQLException {
	                Sistema sistemap = new Sistema(rs.getString(1));
	                return sistemap;
	            }
	        });
	        log.debug("sistemas: {}", sistemaspp.toString());
	        return sistemaspp;
	    }
	    
	    public List<Sistema> findByClase(String claseId) {
	        log.debug("consultando Sistemas en base a la plataforma...");
	        
	        List<Sistema> sistemaspc = jdbcTemplate.query(
	        "select distinct SISTEMAID from consulta where CLASEID=?",
	        new Object[]{ claseId},
	        new RowMapper<Sistema>() {
	            public Sistema mapRow(ResultSet rs, int rowNum) throws SQLException {
	                Sistema sistemac = new Sistema(rs.getString(1));
	                return sistemac;
	            }
	        });
	        log.debug("sistemas: {}", sistemaspc.toString());
	        return sistemaspc;
	    }
	    
	    public List<Sistema> findByBiblioteca(String bibliotecaId) {
	        log.debug("consultando Sistemas en base a la biblioteca...");
	        
	        List<Sistema> sistemaspb = jdbcTemplate.query(
	        "select distinct SISTEMAID from consulta where BIBLIOTECAID=?",
	        new Object[]{bibliotecaId},
	        new RowMapper<Sistema>() {
	            public Sistema mapRow(ResultSet rs, int rowNum) throws SQLException {
	                Sistema sistemab = new Sistema(rs.getString(1));
	                return sistemab;
	            }
	        });
	        log.debug("sistemas: {}", sistemaspb.toString());
	        return sistemaspb;
	    }

		@Override
		public List<Sistema> filterByPlataforma(String plataformaId) {
			log.debug("consultando Sistemas en base a la biblioteca...");
	        
	        List<Sistema> sistemasfb = jdbcTemplate.query(
	        "select distinct SISTEMAID from CONSULTA where PLATAFORMAID=?",
	        new Object[]{plataformaId},
	        new RowMapper<Sistema>() {
	            public Sistema mapRow(ResultSet rs, int rowNum) throws SQLException {
	                Sistema sistemaf = new Sistema(rs.getString(1));
	                return sistemaf;
	            }
	        });
	        log.debug("sistemas: {}", sistemasfb.toString());
	        return sistemasfb;
		}

		@Override
		public List<Sistema> filterByClase(String claseId) {
			log.debug("consultando Plataformas en base a la clase...");
	        
	        List<Sistema> sistemafc= jdbcTemplate.query(
	        "select distinct SISTEMAID from CONSULTA where CLASEID=?",
	        new Object[]{claseId},
	        new RowMapper<Sistema>() {
	            public Sistema mapRow(ResultSet rs, int rowNum) throws SQLException {
	                Sistema sistemafbc = new Sistema(rs.getString(1));
	                return sistemafbc;
	            }
	        });
	        log.debug("sistemas: {}", sistemafc.toString());
	        return sistemafc;
		}

		@Override
		public List<Sistema> filterByBiblioteca(String bibliotecaId) {
			log.debug("consultando Plataformas en base a la biblioteca...");
	        
	        List<Sistema> sistemafb = jdbcTemplate.query(
	        "select distinct SISTEMAID from CONSULTA where BIBLIOTECAID=?",
	        new Object[]{bibliotecaId},
	        new RowMapper<Sistema>() {
	            public Sistema mapRow(ResultSet rs, int rowNum) throws SQLException {
	                Sistema sistemafbb = new Sistema(rs.getString(1));
	                return sistemafbb;
	            }
	        });
	        log.debug("sistemas: {}", sistemafb.toString());
	        return sistemafb;
		}

}
