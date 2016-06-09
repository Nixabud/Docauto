package com.sysview.docauto.dao;

import java.util.List;

import com.sysview.docauto.model.Componente;

public interface ComponenteDAO {
	
	List<Componente> findcomponente(Componente componente);
	List<Componente> resultcomp();
	
}
