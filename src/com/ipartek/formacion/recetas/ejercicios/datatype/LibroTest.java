package com.ipartek.formacion.recetas.ejercicios.datatype;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LibroTest {

	@Test
	public void testConstructorPorDefecto() {
		
		Libro l = new Libro();
		assertEquals("desconocido", l.getTitulo());
		assertEquals("anonimo", l.getAutor());
		assertEquals(0, l.getNumeroPaginas());
	}

	@Test
	public void testSetTitulo() {
		Libro libroJava = new Libro();
		libroJava.setTitulo("java 7");
		assertEquals("java 7", libroJava.getTitulo());
	}
	
	@Test
	public void testConstructorConParametros() {

		Libro l = new Libro("java 7", 324);
		assertEquals("java 7", l.getTitulo());
		assertEquals("anonimo", l.getAutor());
		assertEquals(324, l.getNumeroPaginas());

		//Paginas Negativas
		//(paginas<0)?0:paginas;
		l.setNumeroPaginas(-300);
		assertEquals(0, l.getNumeroPaginas());
				
		//setPaginas en Constructor
		l = new Libro("java 7", -1);
		assertEquals("java 7", l.getTitulo());
		assertEquals("anonimo", l.getAutor());
		assertEquals(0, l.getNumeroPaginas());	
	}
}