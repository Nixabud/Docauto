package com.sysview.service.docauto;

import java.util.List;

import com.sysview.model.docauto.Clase;

public interface ClaseService {

	void initialize();
	
	Clase getClasebyId(String claseId);
	
	List<Clase> getClase();
	
	List<Clase> findBySistema(String claseId);
}
