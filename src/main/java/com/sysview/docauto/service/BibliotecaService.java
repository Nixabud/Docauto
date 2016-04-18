package com.sysview.docauto.service;

import java.util.List;

import com.sysview.docauto.model.Biblioteca;
import com.sysview.docauto.model.Filter;

public interface BibliotecaService {
	
	void initialize();
	
	List<Biblioteca> getBibliotecas();
	
	List<Biblioteca> findByClase(String claseId);
	
	Filter filterByBiblioteca(String bibliotecaId);

}
