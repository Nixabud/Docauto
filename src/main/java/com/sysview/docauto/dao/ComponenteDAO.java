package com.sysview.docauto.dao;

import java.util.List;

import com.sysview.docauto.model.Componente;
import com.sysview.docauto.model.Filter;

public interface ComponenteDAO {
	
	List<Componente> findcomponente(Filter filter);
	
}
