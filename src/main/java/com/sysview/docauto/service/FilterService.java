package com.sysview.docauto.service;

import java.util.List;

import com.sysview.docauto.model.Filter;

public interface FilterService {
	
	  void initialize();
	    
	    Filter filterByPlataforma(String plataformaId);
	    Filter filterBySistema(String sistemaId);
	    Filter filterByClase(String claseId);
	    Filter filterByBiblioteca(String bibliotecaId);

}
