package com.sysview.dao.docauto;

import java.util.List;

import com.sysview.model.docauto.Biblioteca;

public interface BibliotecaDAO {
	void init();
		    
	Biblioteca getBibliotecaById(String bibliotecaId);
		    
	List<Biblioteca> getBibliotecas();
	
	List<Biblioteca> findByClase();
	
}
