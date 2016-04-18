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

import com.sysview.docauto.dao.BibliotecaDAO;
import com.sysview.docauto.model.Biblioteca;
import com.sysview.docauto.model.Filter;
import com.sysview.docauto.model.Sistema;

@Component("bibliotecaDao")
public class BibliotecaDAOImpl implements BibliotecaDAO {
    
    private static final Logger log = LoggerFactory.getLogger(BibliotecaDAOImpl.class);
    
    @Autowired
    JdbcTemplate jdbcTemplate;
    
    public void init() {
        log.debug("creando tabla biblioteca...");
    }

    public Biblioteca getBibliotecaById(String bibliotecaId) {
        return null;
    }
    
    public List<Biblioteca> getBibliotecas() {
        log.debug("consultando bibliotecas...");
        
        List<Biblioteca> bibliotecas = jdbcTemplate.query(
        "select BIBLIOTECAID from Biblioteca order by (BIBLIOTECAID)",
        new RowMapper<Biblioteca>() {
            public Biblioteca mapRow(ResultSet rs, int rowNum) throws SQLException {
                Biblioteca biblioteca = new Biblioteca(rs.getString(1));
                return biblioteca;
            }
        });
        log.debug("clases: {}", bibliotecas.toString());
        return bibliotecas;
    }
    
    public List<Biblioteca> findBySistema(String sistemaId) {
        log.debug("consultando bibliotecas segun el sistema...");
        
        List<Biblioteca> bibliotecas = jdbcTemplate.query(
        "select distinct BIBLIOTECAID from CONSULTA where SISTEMAID=?",
        new Object[]{sistemaId},
        new RowMapper<Biblioteca>() {
            public Biblioteca mapRow(ResultSet rs, int rowNum) throws SQLException {
                Biblioteca bibliotecaps = new Biblioteca(rs.getString(1));
                return bibliotecaps;
            }
        });
        log.debug("clases: {}", bibliotecas.toString());
        return bibliotecas;
    }
    
    public List<Biblioteca> findByPlataforma(String plataformaId) {
        log.debug("consultando bibliotecas segun la plataforma...");
        
        List<Biblioteca> bibliotecasp = jdbcTemplate.query(
        "select distinct BIBLIOTECAID from CONSULTA where PLATAFORMAID=?",
        new Object[]{plataformaId},
        new RowMapper<Biblioteca>() {
            public Biblioteca mapRow(ResultSet rs, int rowNum) throws SQLException {
                Biblioteca bibliotecapp = new Biblioteca(rs.getString(1));
                return bibliotecapp;
            }
        });
        log.debug("clases: {}", bibliotecasp.toString());
        return bibliotecasp;
    }
    
    public List<Biblioteca> findByClase(String claseId) {
        log.debug("consultando bibliotecas segun la clase...");
        
        List<Biblioteca> bibliotecas = jdbcTemplate.query(
        "select distinct BIBLIOTECAID from CONSULTA where CLASEID=?",
        new Object[]{claseId},
        new RowMapper<Biblioteca>() {
            public Biblioteca mapRow(ResultSet rs, int rowNum) throws SQLException {
                Biblioteca bibliotecapc = new Biblioteca(rs.getString(1));
                return bibliotecapc;
            }
        });
        log.debug("clases: {}", bibliotecas.toString());
        return bibliotecas;
    }

	@Override
	public List<Biblioteca> filterByClase(String claseId) {
		log.debug("consultando Plataformas en base a la clase...");
        
        List<Biblioteca> bibliotecafc = jdbcTemplate.query(
        "select distinct BIBLIOTECAID from CONSULTA where CLASEID=?",
        new Object[]{claseId},
        new RowMapper<Biblioteca>() {
            public Biblioteca mapRow(ResultSet rs, int rowNum) throws SQLException {
                Biblioteca bibliotecafbc = new Biblioteca(rs.getString(1));
                return bibliotecafbc;
            }
        });
        log.debug("sistemas: {}", bibliotecafc.toString());
        return bibliotecafc;
	}

	@Override
	public List<Biblioteca> filterByPlataforma(String plataformaId) {
log.debug("consultando Plataformas en base a la clase...");
        
        List<Biblioteca> bibliotecafc = jdbcTemplate.query(
        "select distinct BIBLIOTECAID from CONSULTA where PlataformaID=?",
        new Object[]{plataformaId},
        new RowMapper<Biblioteca>() {
            public Biblioteca mapRow(ResultSet rs, int rowNum) throws SQLException {
                Biblioteca bibliotecafbp = new Biblioteca(rs.getString(1));
                return bibliotecafbp;
            }
        });
        log.debug("sistemas: {}", bibliotecafc.toString());
        return bibliotecafc;
	}

	@Override
	public List<Biblioteca> filterBySistema(String sistemaId) {
		log.debug("consultando Plataformas en base al sistema...");
        
        List<Biblioteca> bibliotecafs = jdbcTemplate.query(
        "select distinct BIBLIOTECAID from CONSULTA where SISTEMAID=?",
        new Object[]{sistemaId},
        new RowMapper<Biblioteca>() {
            public Biblioteca mapRow(ResultSet rs, int rowNum) throws SQLException {
                Biblioteca bibliotecafbs = new Biblioteca(rs.getString(1));
                return bibliotecafbs;
            }
        });
        log.debug("sistemas: {}", bibliotecafs.toString());
        return bibliotecafs;
	}

	@Override
	public List<Sistema> filterByBiblioteca(String bibliotecaId) {
		// TODO Auto-generated method stub
		return null;
	}
  
}
