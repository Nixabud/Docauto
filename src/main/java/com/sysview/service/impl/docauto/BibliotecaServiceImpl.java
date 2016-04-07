package com.sysview.service.impl.docauto;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sysview.dao.docauto.BibliotecaDAO;
import com.sysview.model.docauto.Biblioteca;
import com.sysview.service.docauto.BibliotecaService;

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
	public Biblioteca getBibliotecabyId(String bibliotecaId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Biblioteca> findByClase(String bibliotecaId) {
		// TODO Auto-generated method stub
		return null;
	}
}
