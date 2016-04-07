package com.sysview.service.impl.docauto;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sysview.dao.docauto.PlataformaDAO;
import com.sysview.dao.docauto.SistemaDAO;
import com.sysview.model.docauto.Plataforma;
import com.sysview.model.docauto.Sistema;
import com.sysview.service.docauto.SistemaService;

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
    
    public List<Sistema> getSistemas() {
        return sistemaDao.getSistemas();
    }

	@Override
	public List<Sistema> findByPlataforma(String plataformaId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<Sistema> findbyPlataforma() {
        return sistemaDao.findbyPlataforma();
    }

}
