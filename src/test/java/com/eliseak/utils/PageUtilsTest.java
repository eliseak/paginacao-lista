package com.eliseak.utils;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PageUtilsTest {

	private List<String> lista;
	
    @BeforeEach
    public void setUp() throws Exception {
    	lista = new ArrayList<String>();
    	
    	lista.add("A1");
    	lista.add("B2");
    	lista.add("C3");
    	lista.add("D4");
    	lista.add("E5");
    	lista.add("F6");
    	lista.add("G7");
    	lista.add("H8");
    }
	
	@Test
	public void devePaginarCorretamente() {
		
    	Integer paginas = 3;
    	assertEquals(paginas, PageUtils.getTotalPages(lista, 3));

    	paginas = 4;
    	assertEquals(paginas, PageUtils.getTotalPages(lista, 2));
    	
    	paginas = 2;
    	assertEquals(paginas, PageUtils.getTotalPages(lista, 7));
    	
    }
	
	@Test
	public void deveRetornarTodasAsPaginasComLimite3() {

    	System.out.println();
		System.out.println("Limite: 3");
		
		List<String> subLista = lista.subList(0, 3);
    	System.out.println("Lista 1 - 3:" + subLista.toString());

    	assertEquals(3, PageUtils.getPageContent(lista, 1, 3).size());
    	assertEquals(subLista, PageUtils.getPageContent(lista, 1, 3));
    	
    	subLista = lista.subList(3, 6);
    	System.out.println("Lista 4 - 6:" + subLista.toString());
    	
    	assertEquals(3, PageUtils.getPageContent(lista, 2, 3).size());
    	assertEquals(subLista, PageUtils.getPageContent(lista, 2, 3));
    	
    	subLista = lista.subList(6, 8);
    	System.out.println("Lista 7 - 8:" + subLista.toString());
    	
    	assertEquals(2, PageUtils.getPageContent(lista, 3, 3).size());
    	assertEquals(subLista, PageUtils.getPageContent(lista, 3, 3));
    	
    	//Nulos
    	assertEquals(null, PageUtils.getPageContent(lista, 4, 3));
    	
    	assertEquals(null, PageUtils.getPageContent(lista, -1, 3));
    	
	}
	
	@Test
	public void deveRetornarTodasAsPaginasComLimite7() {
    	
    	System.out.println();
    	System.out.println("Limite: 7");
    	
    	List<String> subLista = lista.subList(0, 7);
    	System.out.println("Lista 1 - 7:" + subLista.toString());
    	
    	assertEquals(7, PageUtils.getPageContent(lista, 1, 7).size());
    	assertEquals(subLista, PageUtils.getPageContent(lista, 1, 7));
    	
    	subLista = lista.subList(7, 8);
    	System.out.println("Lista 8 - 8:" + subLista.toString());
    	
    	assertEquals(1, PageUtils.getPageContent(lista, 2, 7).size());
    	assertEquals(subLista, PageUtils.getPageContent(lista, 2, 7));
    	
	}
	
	@Test
	public void deveRetornarTodasAsPaginasComLimite10() {
    	
    	System.out.println();
    	System.out.println("Limite: 10");
    	
    	List<String> subLista = lista.subList(0, 8);
    	System.out.println("Lista 1 - 8:" + subLista.toString());
    	
    	assertEquals(8, PageUtils.getPageContent(lista, 1, 10).size());
    	assertEquals(subLista, PageUtils.getPageContent(lista, 1, 10));
    	
    	assertEquals(null, PageUtils.getPageContent(lista, 2, 10));
    	
	}
}
