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
	      
	      log.debug("plataforma: {}", componente.getPlataformaID());
	      log.debug("sistema: {}", componente.getSistemaID());
	      log.debug("biblioteca: {}", componente.getBibliotecaId());
	      log.debug("clase: {}", componente.getClaseId());
	      
	      String sql = "SELECT PLATAFORMAID,";
	      sql += " SISTEMAID,";
	      sql += " BIBLIOTECAID,";
	      sql += " CLASEID,";
	      sql += " COMPONENTE";
          sql += " PRODUCTOID,";
          sql += " FORMATOID,";
          sql += " DOCTO";
	      sql += " FROM CONSULTA";
	      sql += " WHERE COMPONENTE != 'NULL'";
	      
	      List<String> params = new ArrayList<String>();
	      
	      if(!StringUtils.isEmpty(componente.getPlataformaID())) {
	          sql += " AND PLATAFORMAID = ?";
	          params.add(componente.getPlataformaID());
	      }
	      
	      if(!StringUtils.isEmpty(componente.getSistemaID())) {
	          sql += " AND SISTEMAID = ?";
	          params.add(componente.getSistemaID());
	      }
	      
	      if(!StringUtils.isEmpty(componente.getBibliotecaId())) {
	          sql += " AND BIBLIOTECAID = ?";
	          params.add(componente.getBibliotecaId());
	      }
	      
	      if(!StringUtils.isEmpty(componente.getClaseId())) {
	          sql += " AND CLASEID = ?";
	          params.add(componente.getClaseId());
	      }
	      
	      List<Componente> componentes = jdbcTemplate.query(
	          sql,
	          StringUtils.toStringArray(params),
	          new RowMapper<Componente>() {
	              public Componente mapRow(ResultSet rs, int rowNum) throws SQLException {
	                  Componente componente = new Componente();
	                  Blob blob = rs.getBlob("DOCTO");
                      componente.setDocto(blob.getBytes(1, (int) blob.length()));
                      componente.setPlataformaID(rs.getString("PLATAFORMAID"));
                      componente.setSistemaID(rs.getString("SISTEMAID"));
                      componente.setClaseId(rs.getString("CLASEID"));
                      componente.setBibliotecaId(rs.getString("BIBLIOTECAID"));
                      componente.setComponente(rs.getString("COMPONENTE"));
                      componente.setProductoId(rs.getString("PRODUCTOID"));
                      componente.setFormatoId(rs.getString("FORMATOID"));
                      return componente;
                  }
              });
          log.debug("componente: {}", componentes.toString());
          return componentes;
    } 
}
