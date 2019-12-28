package com.alejandro.springmysql.util.paginator;

public class PageItem {
	private int numero;
	public int getNumero() {
		return numero;
	}

	public boolean isActual() {
		return actual;
	}

	private boolean actual;
	
	public PageItem(int numero, boolean actual) {
		this.numero = numero;
		this.actual = actual;
	}
	
	

}
