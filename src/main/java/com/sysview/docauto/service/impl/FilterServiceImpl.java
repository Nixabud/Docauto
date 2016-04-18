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
import com.sysview.docauto.service.FilterService;


@Service("filterService")
public class FilterServiceImpl implements FilterService {
	@Autowired PlataformaDAO plataformaDao;
	@Autowired SistemaDAO sistemaDao;
	@Autowired ClaseDAO claseDao;
	@Autowired BibliotecaDAO bibliotecaDao;
	
	private static final Logger log = LoggerFactory.getLogger(FilterServiceImpl.class);
	    
	@Override
	public Filter filterBySistema(String sistemaId){
		 
        Filter filter = new Filter();
        filter.setPlataformas(plataformaDao.filterBySistemas(sistemaId)); 
        filter.setBibliotecas(bibliotecaDao.filterBySistema(sistemaId)); 
        filter.setClases(claseDao.filterBySistema(sistemaId)); 
        return filter;
    }
	
	@Override
	public Filter filterByClase(String claseId){
		 
        Filter filter = new Filter();
        filter.setPlataformas(plataformaDao.filterByClase(claseId)); 
        filter.setSistemas(sistemaDao.filterByClase(claseId)); 
        filter.setBibliotecas(bibliotecaDao.filterByClase(claseId)); 
        return filter;
    }
	
	@Override
	public Filter filterByBiblioteca(String bibliotecaId){
		 
        Filter filter = new Filter();
        filter.setPlataformas(plataformaDao.filterByBiblioteca(bibliotecaId)); 
        filter.setSistemas(sistemaDao.filterByBiblioteca(bibliotecaId)); 
        filter.setClases(claseDao.filterByBiblioteca(bibliotecaId));
        return filter;
    }
	
	@Override
	public Filter filterByPlataforma(String plataformaId){
	    Filter filter = new Filter();
	    filter.setBibliotecas(bibliotecaDao.filterByPlataforma(plataformaId)); 
	    filter.setSistemas(sistemaDao.filterByPlataforma(plataformaId)); 
	    filter.setClases(claseDao.filterByPlataforma(plataformaId));
            return filter;
	}

	@Override
	public void initialize() {
		// TODO Auto-generated method stub
		
	}
}
