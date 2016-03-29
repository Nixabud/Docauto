package com.sysview.docauto.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import com.sysview.docauto.model.Plataforma;

public interface PlataformaService {
	Plataforma getPlataformabyId();
	List<Plataforma> getListP();
}
