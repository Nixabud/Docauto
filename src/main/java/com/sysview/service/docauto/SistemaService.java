package com.sysview.service.docauto;

import java.util.List;

import com.sysview.model.docauto.Sistema;

public interface SistemaService {

    
    void initialize();
    
    Sistema getSistemaById(String sistemaId);
    
    List<Sistema> getSistemas();
    List<Sistema> findByPlataforma(String plataformaId);
}
