package com.sysview.docauto.dao.impl;

import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.sysview.docauto.dao.ComponenteDAO;
import com.sysview.docauto.model.Componente;

@Component ("componenteDao")
public class ComponenteDaoImpl implements ComponenteDAO {
	  
	  private static final Logger log = LoggerFactory.getLogger(ComponenteDaoImpl.class);
	  
	  @Autowired
	  private JdbcTemplate jdbcTemplate;
	  
	  @Override
	  public List<Componente> findcomponente(Componente componente){
	      log.debug("consultando Componentes...");
	      
	      log.debug("plataforma: {}", componente.getPlataformaId());
	      log.debug("sistema: {}", componente.getSistemaId());
	      log.debug("biblioteca: {}", componente.getBibliotecaId());
	      log.debug("clase: {}", componente.getClaseId());
	      
	      StringBuilder sql = new StringBuilder();
	      sql.append("SELECT PLATAFORMAID, ");
	      sql.append("  SISTEMAID, ");
	      sql.append("  CLASEID, ");
	      sql.append("  BIBLIOTECAID, ");
	      sql.append("  COMPONENTE, ");
          sql.append("  PRODUCTOID, ");
          sql.append("  FORMATOID ");
	      sql.append("FROM CONSULTADETALLE ");
	      sql.append("WHERE 1=1 ");
	      
	      List<String> params = new ArrayList<String>();
	      
	      if(!StringUtils.isEmpty(componente.getPlataformaId())) {
	          sql.append(" AND PLATAFORMAID = ?");
	          params.add(componente.getPlataformaId());
	      }
	      
	      if(!StringUtils.isEmpty(componente.getSistemaId())) {
	          sql.append(" AND SISTEMAID = ?");
	          params.add(componente.getSistemaId());
	      }

	      if(!StringUtils.isEmpty(componente.getClaseId())) {
	          sql.append(" AND CLASEID = ?");
	          params.add(componente.getClaseId());
	      }
	      
	      if(!StringUtils.isEmpty(componente.getBibliotecaId())) {
	          sql.append(" AND BIBLIOTECAID = ?");
	          params.add(componente.getBibliotecaId());
	      }
	      
	      
	      List<Componente> componentes = jdbcTemplate.query(
	          sql.toString(),
	          StringUtils.toStringArray(params),
	          new ComponenteMapper());
          log.debug("componentes encontrados: {}", componentes.size());
          return componentes;
    }

	@Override
	public List<Componente> resultcomp() {
	    StringBuilder sql = new StringBuilder();
		sql.append("SELECT distinct COMPONENTE, ");
		sql.append("  PLATAFORMAID, ");
		sql.append("  SISTEMAID, ");
		sql.append("  CLASEID, ");
		sql.append("  BIBLIOTECAID, ");
		sql.append("  COMPONENTE ");
		sql.append("FROM CONSULTADETALLE ");
		sql.append("WHERE PLATAFORMAID = ? ");
		sql.append("AND SISTEMAID = ? ");
		sql.append("AND CLASEID = ? ");
		sql.append("AND BIBLIOTECAID = ? ");
		List <Componente> filcomp= jdbcTemplate.query(sql.toString(), new ComponenteMapper());
		return filcomp;
	}
	
    public byte[] getDocument() {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT DOCTO FROM CONSULTADETALLE WHERE COMPONENTE = ?");
        jdbcTemplate.query(sql.toString(), new RowMapper<byte[]>() {
            public byte[] mapRow(ResultSet rs, int rowNum) throws SQLException {
                Blob blob = rs.getBlob("DOCTO");
                return blob.getBytes(1, (int) blob.length());
            }
        });
        return null;
    }


    private static final class ComponenteMapper implements RowMapper<Componente> {
        
        public Componente mapRow(ResultSet rs, int rowNum) throws SQLException {
            Componente compo = new Componente();
        	compo.setPlataformaId(rs.getString("PLATAFORMAID"));
        	compo.setSistemaId(rs.getString("SISTEMAID"));
        	compo.setClaseId(rs.getString("CLASEID"));
            compo.setBibliotecaId(rs.getString("BIBLIOTECAID"));
        	compo.setComponente(rs.getString("COMPONENTE"));
        	compo.setProductoId(rs.getString("PRODUCTOID"));
            compo.setFormatoId(rs.getString("FORMATOID"));
        	return compo;
        }
    }

}

