package com.sysview.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.sysview.dao.PlataformaDAO;
import com.sysview.model.Plataforma;

@Component ("plataformaDAO")
public class PlataformaDAOImpl implements PlataformaDAO{
	
	  private static final Logger log = LoggerFactory.getLogger(PlataformaDAOImpl.class);
	
	@Autowired JdbcTemplate jdbcTemplate;
	@Override
	public Plataforma getPlataformabyId() {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public List<Plataforma> getListP() {
		
		log.debug("consultando plataformas...");
        
        List<Plataforma> plataformas = jdbcTemplate.query(
        "select * from plataforma",
        new RowMapper<Plataforma>() {
            public Plataforma mapRow(ResultSet rs, int rowNum) throws SQLException {
                Plataforma plataforma = new Plataforma(rs.getString(1));
                return plataforma;
            }
        });
        log.debug("plataformas: {}", plataformas);
        return plataformas;
	}

}
