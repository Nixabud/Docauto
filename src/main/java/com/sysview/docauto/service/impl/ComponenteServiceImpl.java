package com.sysview.docauto.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sysview.docauto.dao.ComponenteDAO;
import com.sysview.docauto.model.Componente;
import com.sysview.docauto.service.ComponenteService;


@Service ("componenteService")
public class ComponenteServiceImpl implements ComponenteService{

	@Autowired 
	private ComponenteDAO componenteDao;
	@Override
	public List<Componente> filterByComponente(Componente componente) {
	    return componenteDao.findcomponente(componente);
	}

}
