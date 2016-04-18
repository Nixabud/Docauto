package com.sysview.docauto.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sysview.docauto.dao.PlataformaDAO;
import com.sysview.docauto.dao.SistemaDAO;
import com.sysview.docauto.model.Filter;
import com.sysview.docauto.model.Plataforma;
import com.sysview.docauto.model.Sistema;
import com.sysview.docauto.service.SistemaService;

@Service("sistemaservice")
public class SistemaServiceImpl implements SistemaService{
	
	private static final Logger log = LoggerFactory.getLogger(SistemaServiceImpl.class);
    
    @Autowired
    private SistemaDAO sistemaDao;
    
    public void initialize() {
        sistemaDao.init();
    }
    
    public Sistema getSistemaById(String sistemaId) {
        return null;
    }
    
	public List<Sistema> findByPlataforma(String plataformaId) {
        return sistemaDao.filterByPlataforma(plataformaId);
    }

	@Override
	public List<Sistema> getSistemas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Filter filterBySistema(String sistemaId) {
		// TODO Auto-generated method stub
		return null;
	}

}
