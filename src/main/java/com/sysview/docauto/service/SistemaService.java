package com.sysview.docauto.service;

import java.util.List;

import com.sysview.docauto.model.Filter;
import com.sysview.docauto.model.Sistema;

public interface SistemaService {

    
    void initialize();
    
    Sistema getSistemaById(String sistemaId);
    
    List<Sistema> getSistemas();
    List<Sistema> findByPlataforma(String plataformaId);

	Filter filterBySistema(String sistemaId);
}
