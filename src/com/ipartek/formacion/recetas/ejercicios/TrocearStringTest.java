package com.ipartek.formacion.recetas.ejercicios;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TrocearStringTest {

	@Test
	public void test() {
		String linea = "Derick,Morris,Montmeló,8,DerickKMorris@mailinator.com,63655957F,TRABAJADOR";
		String[] trozos = linea.split(",");

		assertEquals("Derick", trozos[0]);
		assertEquals("Morris", trozos[1]);
		assertEquals("Montmeló", trozos[2]);
		assertEquals("8", trozos[3]);
		// Resto de trozos
		assertEquals("TRABAJADOR", trozos[6]);

	}

}
