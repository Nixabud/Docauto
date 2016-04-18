package com.sysview.docauto.model;

import java.util.List;

public class Filter {
	
	private List<Plataforma> plataformas;
	private List<Sistema> sistemas;
	private List<Biblioteca> bibliotecas;
	private List<Clase> clases;
	
	public List<Plataforma> getPlataformas() {
		return plataformas;
	}
	public void setPlataformas(List<Plataforma>plataformas) {
		this.plataformas = plataformas;
	}
	public List<Sistema> getSistemas() {
		return sistemas;
	}
	public void setSistemas(List<Sistema>sistemas) {
		this.sistemas = sistemas;
	}
	public List<Biblioteca> getBibliotecas() {
		return bibliotecas;
	}
	public void setBibliotecas(List<Biblioteca> bibliotecas) {
		this.bibliotecas = bibliotecas;
	}
	public List<Clase> getClases() {
		return clases;
	}
	public void setClases(List<Clase> clases) {
		this.clases = clases;
	}
	
	

}
