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

import com.sysview.dao.docauto.BibliotecaDAO;
import com.sysview.model.docauto.Biblioteca;

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
    
    public List<Biblioteca> findByClase() {
        log.debug("consultando bibliotecas segun la clase...");
        
        List<Biblioteca> bibliotecas = jdbcTemplate.query(
        "select BIBLIOTECAID from Consulta where CLASEID = ?",
        new RowMapper<Biblioteca>() {
            public Biblioteca mapRow(ResultSet rs, int rowNum) throws SQLException {
                Biblioteca bibliotecapc = new Biblioteca(rs.getString(1));
                return bibliotecapc;
            }
        });
        log.debug("clases: {}", bibliotecas.toString());
        return bibliotecas;
    }
}
