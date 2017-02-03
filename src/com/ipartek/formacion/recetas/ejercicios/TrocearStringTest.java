package com.ipartek.formacion.recetas.ejercicios;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TrocearStringTest {

	@Test
	public void test() {
		String linea = "Terry,Suttle,Valverde Del Camino,21,TerryMSuttle@mailinator.com,63056684E,TRABAJADOR";
		String[] trozos = linea.split(",");

		assertEquals("Terry", trozos[0]);
		assertEquals("Suttle", trozos[1]);
		assertEquals("Valverde Del Camino", trozos[2]);
		assertEquals("21", trozos[3]);
		assertEquals("TerryMSuttle@mailinator.com", trozos[4]);
		assertEquals("63056684E", trozos[5]);
		assertEquals("TRABAJADOR", trozos[6]);
	}

}
