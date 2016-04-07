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

import com.sysview.dao.docauto.PlataformaDAO;
import com.sysview.model.docauto.Plataforma;
import com.sysview.model.docauto.Sistema;

@Component("plataformaDao")
public class PlataformaDAOImpl implements PlataformaDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    private static final Logger log = LoggerFactory.getLogger(PlataformaDAOImpl.class);
    
    public void init() {
        log.debug("creando tabla plataforma...");
    }

    public Plataforma getPlataformaById(String plataformaId) {
        return null;
    }
    
    public List<Plataforma> getPlataformas() {
        log.debug("consultando plataformas...");
        
        List<Plataforma> plataformas = jdbcTemplate.query(
        "select * from plataforma",
        new RowMapper<Plataforma>() {
            public Plataforma mapRow(ResultSet rs, int rowNum) throws SQLException {
                Plataforma plataforma = new Plataforma(rs.getString(1));
                return plataforma;
            }
        });
        log.debug("plataformas: {}", plataformas.toString());
        return plataformas;
    }
    
    
    public List<Plataforma> findBySistema() {	
    	
    	log.debug("consultando Plataformas en base al sistema...");
        
        List<Plataforma> plataformaps = jdbcTemplate.query(
        "select plataformaid from sistema where sistemaid = ?",
        new RowMapper<Plataforma>() {
            public Plataforma mapRow(ResultSet rs, int rowNum) throws SQLException {
                Plataforma plataformap = new Plataforma(rs.getString(1));
                return plataformap;
            }
        });
        log.debug("sistemas: {}", plataformaps.toString());
        return plataformaps;
    }
    
}

