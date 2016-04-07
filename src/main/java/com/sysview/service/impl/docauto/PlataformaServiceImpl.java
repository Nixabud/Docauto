package com.sysview.service.impl.docauto;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sysview.dao.docauto.PlataformaDAO;
import com.sysview.model.docauto.Plataforma;
import com.sysview.service.docauto.PlataformaService;

@Service("plataformaService")
public class PlataformaServiceImpl implements PlataformaService {
    
    private static final Logger log = LoggerFactory.getLogger(PlataformaServiceImpl.class);
    
    @Autowired
    private PlataformaDAO plataformaDao;
    
    public void initialize() {
        plataformaDao.init();
    }
    
    public Plataforma getPlataformaById(String plataformaId) {
        return null;
    }
    
    public List<Plataforma> getPlataformas() {
        return plataformaDao.getPlataformas();
    }

	@Override
	public List<Plataforma> findBySistema() {
		// TODO Auto-generated method stub
		return plataformaDao.findBySistema();
	}        
}
