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

import com.sysview.dao.docauto.ClaseDAO;
import com.sysview.model.docauto.Clase;

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
    
    public List<Clase> findBySistema() {
        log.debug("consultando clases segun el sistema...");
        
        List<Clase> clases = jdbcTemplate.query(
        "select claseid from clase where sistemaid = ?",
        new RowMapper<Clase>() {
            public Clase mapRow(ResultSet rs, int rowNum) throws SQLException {
                Clase claseps = new Clase(rs.getString(1));
                return claseps;
            }
        });
        log.debug("clases: {}", clases.toString());
        return clases;
    }
}