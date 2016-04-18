package com.sysview.docauto.service;

import com.sysview.docauto.model.Filter;

public interface FilterService {
    
    Filter filterByPlataforma(String plataformaId);
    Filter filterBySistema(String sistemaId);
    Filter filterByClase(String claseId);
    Filter filterByBiblioteca(String bibliotecaId);

}
