package com.sysview.dao.docauto;

import java.util.List;

import com.sysview.model.docauto.Plataforma;

public interface PlataformaDAO {
    
    void init();
    
    Plataforma getPlataformaById(String plataformaId);
    
    List<Plataforma> getPlataformas();    
    
    List<Plataforma> findBySistema();
    
}