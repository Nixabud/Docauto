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

import com.sysview.docauto.dao.ClaseDAO;
import com.sysview.docauto.model.Clase;
import com.sysview.docauto.model.Filter;

@Component("claseDao")
public class ClaseDAOImpl implements ClaseDAO {
    
    private static final Logger log = LoggerFactory.getLogger(ClaseDAOImpl.class);
    
    @Autowired
    JdbcTemplate jdbcTemplate;
    
    
    public void init() {
        log.debug("creando tabla clase...");
    }

    public Clase getClaseById(String claseId) {
        return null;
    }
    
    public List<Clase> getClases() {
        log.debug("consultando clases...");
        
        List<Clase> clases = jdbcTemplate.query(
        "select CLASEID from CLASE order by CLASEID",
        new RowMapper<Clase>() {
            public Clase mapRow(ResultSet rs, int rowNum) throws SQLException {
                Clase clase = new Clase(rs.getString(1));
                return clase;
            }
        });
        log.debug("clases: {}", clases.toString());
        return clases;
    }
    
    public List<Clase> findBySistemas(String sistemaId) {
        log.debug("consultando clases segun el sistema...");
        
        List<Clase> clases = jdbcTemplate.query(
        "select distinct CLASEID from CONSULTA where SISTEMAID=?",
        new Object[]{sistemaId},
        new RowMapper<Clase>() {
            public Clase mapRow(ResultSet rs, int rowNum) throws SQLException {
                Clase claseps = new Clase(rs.getString(1));
                return claseps;
            }
        });
        log.debug("clases: {}", clases.toString());
        return clases;
    }
    
    public List<Clase> findByPlataformas(String plataformaId) {
        log.debug("consultando clases segun la plataforma...");
        
        List<Clase> clasep = jdbcTemplate.query(
        "select distinct CLASEID from CONSULTA where PLATAFORMAID=?",
        new Object[]{plataformaId},
        new RowMapper<Clase>() {
            public Clase mapRow(ResultSet rs, int rowNum) throws SQLException {
                Clase clasepp = new Clase(rs.getString(1));
                return clasepp;
            }
        });
        log.debug("clases: {}", clasep.toString());
        return clasep;
    }
    
    public List<Clase> findByBibliotecas(String bibliotecaId) {
        log.debug("consultando clases segun la plataforma...");
        
        List<Clase> clasefb = jdbcTemplate.query(
        "select distinct CLASEID from CONSULTA where BIBLIOTECAID=?",
        new Object[]{bibliotecaId},
        new RowMapper<Clase>() {
            public Clase mapRow(ResultSet rs, int rowNum) throws SQLException {
                Clase clasepb = new Clase(rs.getString(1));
                return clasepb;
            }
        });
        log.debug("clases: {}", clasefb.toString());
        return clasefb;
    }

	@Override
	public List<Clase> filterBySistema(String sistemaId) {
		log.debug("consultando Plataformas en base al sistema...");
        
        List<Clase> clasefbs = jdbcTemplate.query(
        "select distinct CLASEID from CONSULTA where SISTEMAID=?",
        new Object[]{sistemaId},
        new RowMapper<Clase>() {
            public Clase mapRow(ResultSet rs, int rowNum) throws SQLException {
                Clase clasefs = new Clase(rs.getString(1));
                return clasefs;
            }
        });
        log.debug("sistemas: {}", clasefbs.toString());
        return clasefbs;
	}

	@Override
	public List<Clase> filterByPlataforma(String plataformaId) {
		log.debug("consultando Plataformas en base al sistema...");
        
        List<Clase> clasefbp = jdbcTemplate.query(
        "select distinct CLASEID from CONSULTA where SISTEMAID=?",
        new Object[]{plataformaId},
        new RowMapper<Clase>() {
            public Clase mapRow(ResultSet rs, int rowNum) throws SQLException {
                Clase clasefp = new Clase(rs.getString(1));
                return clasefp;
            }
        });
        log.debug("sistemas: {}", clasefbp.toString());
        return clasefbp;
	}

	@Override
	public List<Clase> filterByBiblioteca(String bibliotecaId) {
		log.debug("consultando Plataformas en base al sistema...");
        
        List<Clase> clasefbb = jdbcTemplate.query(
        "select distinct CLASEID from CONSULTA where SISTEMAID=?",
        new Object[]{bibliotecaId},
        new RowMapper<Clase>() {
            public Clase mapRow(ResultSet rs, int rowNum) throws SQLException {
                Clase clasefb = new Clase(rs.getString(1));
                return clasefb;
            }
        });
        log.debug("sistemas: {}", clasefbb.toString());
        return clasefbb;
	}

	@Override
	public List<Clase> getClase() {
		// TODO Auto-generated method stub
		return null;
	}

}