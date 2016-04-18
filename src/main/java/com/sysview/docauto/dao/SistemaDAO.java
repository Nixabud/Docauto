package com.sysview.docauto.dao;

import java.util.List;

import com.sysview.docauto.model.Sistema;

public interface SistemaDAO {
    
    void init();
    
    Sistema getSistemaById(String sistemaId);
    
    List<Sistema> filterByPlataforma(String sistemaId);
    
    List<Sistema> filterByBiblioteca(String bibliotecaId);
    
    List<Sistema> filterByClase(String claseId);
	
}
