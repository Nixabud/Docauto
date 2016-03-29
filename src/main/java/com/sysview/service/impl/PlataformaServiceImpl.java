package com.sysview.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sysview.dao.PlataformaDAO;
import com.sysview.model.Plataforma;
import com.sysview.service.PlataformaService;

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
