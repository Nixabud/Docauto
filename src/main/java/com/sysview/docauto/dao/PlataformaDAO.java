package com.sysview.docauto.dao;

import java.util.List;

import com.sysview.docauto.model.Plataforma;

public interface PlataformaDAO {
    
    void init();
    
    List<Plataforma> getPlataformas();    
    
    Plataforma getPlataformaById(String plataformaId);
   
    List<Plataforma> filterByBiblioteca(String bibliotecaId);
    
    List<Plataforma> filterBySistemas(String plataformaId);
    
    List<Plataforma> filterByClase(String claseId);
 }