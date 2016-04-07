package com.sysview.model.docauto;

public class Biblioteca {
	
	private String BibliotecaId;
	
	public Biblioteca(String bibliotecaId){
		this.BibliotecaId=bibliotecaId;
	}

	public String getBibliotecaId() {
		return BibliotecaId;
	}

	public void setBibliotecaId(String bibliotecaId) {
		BibliotecaId = bibliotecaId;
	}

}
