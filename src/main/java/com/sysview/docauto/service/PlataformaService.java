package com.sysview.docauto.service;

import java.util.List;

import com.sysview.docauto.model.Clase;
import com.sysview.docauto.model.Filter;
import com.sysview.docauto.model.Plataforma;

public interface PlataformaService {
    void initialize();
    
    Plataforma getPlataformaById(String plataformaId);
    
    List<Plataforma> getPlataformas();
    
    List<Plataforma> findBySistema(String sistemaId);
	
	List<Plataforma> filterByBiblioteca(String bibliotecId);

	Filter filterByPlataforma(String plataformaId);
   
}