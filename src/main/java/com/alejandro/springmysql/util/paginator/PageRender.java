package com.alejandro.springmysql.util.paginator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;

public class PageRender<T> {
	private String url;
	private Page<T>page;
	private int totalPags;
	private int elemPorPag;
	private int pagActual;
	private List<PageItem> paginas;
	
	public PageRender(String url, Page<T> page) {
		this.url = url;
		this.page = page;
		this.paginas = new ArrayList<PageItem>();
		
		elemPorPag = page.getSize();
		totalPags = page.getTotalPages();
		pagActual = page.getNumber() +1;
		
		
		int desde,hasta;
		
		//Entra en este if si el nº de páginas es menor que el nº elementos por página
		//y empieza desde la página 1 hasta el total de páginas ( muestra el paginador completo)
		if(totalPags < elemPorPag) {
			desde = 1;
			hasta = totalPags;
			
		}
		//Si hay muchas páginas de registros, navegamos por rango
		else {
			if(pagActual <= totalPags/2) {
				desde = 1;
				hasta = elemPorPag;
				
			}
			//Página final
			else if(pagActual >= totalPags - elemPorPag) {
				desde = totalPags - elemPorPag + 1;
				hasta = elemPorPag;
			}
			//En el medio
			else {
				desde = pagActual - elemPorPag/2;
				hasta = elemPorPag;
			}
		}
		
		for(int i=0;i<hasta;i++) {
			paginas.add(new PageItem(desde+i, pagActual == desde+i));
		}
		
	}

	public String getUrl() {
		return url;
	}

	public int getTotalPags() {
		return totalPags;
	}

	public int getPagActual() {
		return pagActual;
	}

	public List<PageItem> getPaginas() {
		return paginas;
	}
	
	public boolean isFirst() {
		return page.isFirst();
	}
	public boolean isLast() {
		return page.isLast();
	}
	public boolean isHasNext() {
		return page.hasNext();
	}
	public boolean isHasPrevious() {
		return page.hasPrevious();
	}
	
	
	
	
	

	
	
	
	
	
	
	

}
