package com.sysview.docauto.service;

import java.util.List;

import com.sysview.docauto.model.Componente;

public interface ComponenteService {
		
	List<Componente> filterByComponente(Componente componente);

	List<Componente> cmpfiltro();
	
	byte[] getDocument();
		
}