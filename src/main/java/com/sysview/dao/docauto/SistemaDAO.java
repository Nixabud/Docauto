package com.sysview.dao.docauto;

import java.util.List;

import com.sysview.model.docauto.Sistema;

public interface SistemaDAO {
    
    void init();
    
    Sistema getSistemaById(String sistemaId);
    
    List<Sistema> getSistemas();
    
    List<Sistema> findbyPlataforma();

}
