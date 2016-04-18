package com.sysview.docauto.service;

import java.util.List;

import com.sysview.docauto.model.Componente;

import com.sysview.docauto.model.Filter;

public interface ComponenteService {
		
		List<Componente> filterByComponente(Componente componente);
		
	}