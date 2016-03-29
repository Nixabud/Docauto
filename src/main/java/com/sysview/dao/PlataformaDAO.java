package com.sysview.dao;
import java.util.List;

import com.sysview.model.Plataforma;

public interface PlataformaDAO {
	
	Plataforma getPlataformabyId();
	List<Plataforma> getListP();

}
