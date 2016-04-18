package com.sysview.docauto.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sysview.docauto.dao.BibliotecaDAO;
import com.sysview.docauto.model.Biblioteca;
import com.sysview.docauto.model.Filter;
import com.sysview.docauto.service.BibliotecaService;

@Service("bibliotecaService")
public class BibliotecaServiceImpl implements BibliotecaService{

private static final Logger log = LoggerFactory.getLogger(BibliotecaServiceImpl.class);
    
    @Autowired
    private BibliotecaDAO bibliotecaDao;
    
    public void initialize() {
        bibliotecaDao.init();
    }
    
    public Biblioteca getBibliotecaById(String bibliotecaId) {
        return null;
    }
    
    public List<Biblioteca> getBibliotecas() {
        return bibliotecaDao.getBibliotecas();
    }

	@Override
	public List<Biblioteca> findByClase(String claseId) {
		// TODO Auto-generated method stub
		return bibliotecaDao.filterByClase(claseId);
	}

	@Override
	public Filter filterByBiblioteca(String bibliotecaId) {
		// TODO Auto-generated method stub
		return null;
	}
}
