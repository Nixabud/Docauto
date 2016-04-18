package com.sysview.docauto.dao;

import java.util.List;

import com.sysview.docauto.model.Clase;

public interface ClaseDAO {

	void init();
	
	List<Clase> getClase();
    
    Clase getClaseById(String claseId);
        
	List<Clase> filterByPlataforma(String sistemaId);
	
	List<Clase> filterBySistema(String plataformaId);
		
	List<Clase> filterByBiblioteca(String bibliotecaId);

}