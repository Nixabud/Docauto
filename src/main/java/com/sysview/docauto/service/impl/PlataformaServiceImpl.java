package com.sysview.docauto.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sysview.docauto.dao.BibliotecaDAO;
import com.sysview.docauto.dao.ClaseDAO;
import com.sysview.docauto.dao.PlataformaDAO;
import com.sysview.docauto.dao.SistemaDAO;
import com.sysview.docauto.model.Filter;
import com.sysview.docauto.model.Plataforma;
import com.sysview.docauto.service.PlataformaService;

@Service("plataformaService")
public class PlataformaServiceImpl implements PlataformaService {
    
    private static final Logger log = LoggerFactory.getLogger(PlataformaServiceImpl.class);
    
    @Autowired
    private PlataformaDAO plataformaDao;
    @Autowired
    private SistemaDAO sistemaDao;
    @Autowired
    private ClaseDAO claseDao;
    @Autowired
    private BibliotecaDAO bibliotecaDao;
    
    public void initialize() {
        plataformaDao.init();
    }
    @Override
    public Filter filterByPlataforma(String plataformaId){
    	   
        Filter filter = new Filter();
        filter.setSistemas(sistemaDao.filterByPlataforma(plataformaId)); 
        filter.setBibliotecas(bibliotecaDao.filterByPlataforma(plataformaId)); 
        filter.setClases(claseDao.filterByPlataforma(plataformaId)); 
        return filter;
    }
	@Override
	public Plataforma getPlataformaById(String plataformaId) {
		return plataformaDao.getPlataformaById(plataformaId);
	}
	@Override
	public List<Plataforma> getPlataformas() {
		return plataformaDao.getPlataformas();
	}
	@Override
	public List<Plataforma> findBySistema(String sistemaId) {
		return plataformaDao.filterBySistemas(sistemaId);
	}
	@Override
	public List<Plataforma> filterByBiblioteca(String bibliotecId) {
		// TODO Auto-generated method stub
		return plataformaDao.filterByBiblioteca(bibliotecId);
	}        
}
