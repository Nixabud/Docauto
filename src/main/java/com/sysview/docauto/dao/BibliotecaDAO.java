package com.sysview.docauto.dao;

import java.util.List;

import com.sysview.docauto.model.Biblioteca;
import com.sysview.docauto.model.Sistema;

public interface BibliotecaDAO {
	void init();
		    
	Biblioteca getBibliotecaById(String bibliotecaId);
		    
	List<Biblioteca> getBibliotecas();
	
	List<Biblioteca> filterByPlataforma(String sistemaId);
	
	List<Biblioteca> filterBySistema(String plataformaId);
	
	List<Biblioteca> filterByClase(String claseId);

	List<Sistema> filterByBiblioteca(String bibliotecaId);
	
}
