package com.sysview.dao.docauto;

import java.util.List;

import com.sysview.model.docauto.Clase;

public interface ClaseDAO {

	void init();
    
    Clase getClaseById(String claseId);
    
    List<Clase> getClases();
    
    List<Clase> findBySistema();
}