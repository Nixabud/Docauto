package com.sysview.service.docauto;

import java.util.List;

import com.sysview.model.docauto.Plataforma;

public interface PlataformaService {
    void initialize();
    
    Plataforma getPlataformaById(String plataformaId);
    
    List<Plataforma> getPlataformas();
    
    List<Plataforma> findBySistema();
   
}