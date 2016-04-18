package com.sysview.docauto.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sysview.docauto.dao.ClaseDAO;
import com.sysview.docauto.dao.SistemaDAO;
import com.sysview.docauto.dao.impl.SistemaDAOImpl;
import com.sysview.docauto.model.Clase;
import com.sysview.docauto.model.Filter;
import com.sysview.docauto.service.ClaseService;

@Service("claseService")
public class ClaseServiceImpl implements ClaseService {
	
	private static final Logger log = LoggerFactory.getLogger(ClaseServiceImpl.class);
    
    @Autowired
    private ClaseDAO claseDao;
    
    public void initialize() {
        claseDao.init();
    }
    
    public Clase getClaseById(String claseId) {
        return null;
    }
    
    public List<Clase> getClase() {
        return claseDao.getClase();
    }

	@Override
	public Clase getClasebyId(String claseId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Clase> findBySistemas(String sistemaId) {
		return claseDao.filterBySistema(sistemaId);
	}

	@Override
	public List<Clase>filterByBiblioteca(String bibliotecaId) {
		return claseDao.filterByBiblioteca(bibliotecaId);
	}

	@Override
	public List<Clase> filterBySistemas(String sistemaId) {
		// TODO Auto-generated method stub
		return claseDao.filterBySistema(sistemaId);
	}

	@Override
	public List<Clase> filterByPlataforma(String plataformaId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Filter filterByClase(String claseId) {
		// TODO Auto-generated method stub
		return null;
	}

}