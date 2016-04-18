package com.sysview.docauto.service;

import java.util.List;

import com.sysview.docauto.model.Clase;
import com.sysview.docauto.model.Filter;

public interface ClaseService {

	void initialize();
	
	Clase getClasebyId(String claseId);
	
	List<Clase> getClase();
	
	List<Clase> findBySistemas(String sistemaId);
	
	List<Clase> filterByBiblioteca(String bibliotecId);

	List<Clase> filterByPlataforma(String plataformaId);
	
	Filter filterByClase(String claseId);

	List<Clase> filterBySistemas(String sistemaId);


}
