package com.ipartek.formacion.recetas.ejercicios.datatype;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.Iterator;

import org.junit.Test;

public class ArrayListTest {

	// Declaracion
	ArrayList<String> paises;
	String pais;

	@Test
	public void test() {
		assertNull("Deberia ser null", paises);

		// Instancia Vacia NO null
		paises = new ArrayList<String>();
		assertEquals("0 paises", 0, paises.size());
		assertNotNull("No es null", paises);

		// Add
		paises.add("EH");
		paises.add("kudbejistan");
		paises.add("portugal");
		paises.add("Barakaldo");
		paises.add("Alemania");
		assertEquals(5, paises.size());

		// Remove
		assertEquals("Barakaldo", paises.remove(3));
		assertEquals(4, paises.size());

		// Get
		assertEquals("EH", paises.get(0));
		// TODO
		assertEquals("Portugalete", paises.get(1));
		assertEquals("kudbejistan", paises.get(2));

		String pais = "";
		Iterator<String> it = paises.iterator();
		while (it.hasNext()) {
			pais = it.next();
		}
	}
}
