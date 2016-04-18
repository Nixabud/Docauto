package com.sysview.docauto.dao;

import java.util.List;

import com.sysview.docauto.model.Biblioteca;

public interface BibliotecaDAO {
		    
	List<Biblioteca> getBibliotecas();
	
	List<Biblioteca> filterByPlataforma(String sistemaId);
	
	List<Biblioteca> filterBySistema(String plataformaId);
	
	List<Biblioteca> filterByClase(String claseId);
	
}
