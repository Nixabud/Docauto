package com.sysview.service.impl.docauto;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sysview.dao.docauto.ClaseDAO;
import com.sysview.model.docauto.Clase;
import com.sysview.service.docauto.ClaseService;

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
        return claseDao.getClases();
    }

	@Override
	public Clase getClasebyId(String claseId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Clase> findBySistema(String claseId) {
		// TODO Auto-generated method stub
		return null;
	}
}