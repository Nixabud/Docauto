package com.sysview.service.docauto;

import java.util.List;

import com.sysview.model.docauto.Biblioteca;

public interface BibliotecaService {
	
	void initialize();
	
	Biblioteca getBibliotecabyId(String bibliotecaId);
	
	List<Biblioteca> getBibliotecas();
	
	List<Biblioteca> findByClase(String bibliotecaId);
}
