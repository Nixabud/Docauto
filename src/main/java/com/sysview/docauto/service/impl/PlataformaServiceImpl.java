package com.sysview.docauto.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sysview.docauto.dao.PlataformaDAO;
import com.sysview.docauto.model.Plataforma;
import com.sysview.docauto.service.PlataformaService;

@Service("plataformaService")
public class PlataformaServiceImpl implements PlataformaService{

	@Autowired private PlataformaDAO plataformaDAO;
	@Override
	public Plataforma getPlataformabyId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Plataforma> getListP() {
		// TODO Auto-generated method stub
		return plataformaDAO.getListP();
	}

}
