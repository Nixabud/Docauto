package com.sysview.docauto.dao;

import java.util.List;

import com.sysview.docauto.model.Plataforma;

public interface PlataformaDAO {
    
    List<Plataforma> getPlataformas();
   
    List<Plataforma> filterByBiblioteca(String bibliotecaId);
    
    List<Plataforma> filterBySistemas(String plataformaId);
    
    List<Plataforma> filterByClase(String claseId);
 }