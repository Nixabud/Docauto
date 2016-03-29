package com.sysview.docauto.dao;
import java.util.List;

import com.sysview.docauto.model.Plataforma;

public interface PlataformaDAO {
	
	Plataforma getPlataformabyId();
	List<Plataforma> getListP();

}
