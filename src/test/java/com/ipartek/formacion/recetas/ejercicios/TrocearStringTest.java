package com.ipartek.formacion.recetas.ejercicios;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TrocearStringTest {

	@Test
	public void test() {
		String linea = "Charles,Lam,Aledo,30,CharlesCLam@mailinator.com,60949098H,TRABAJADOR";
		String[] trozos = linea.split(",");

		assertEquals("Charles", trozos[0]);
		assertEquals("Lam", trozos[1]);
		assertEquals("Aledo", trozos[2]);
		assertEquals("30", trozos[3]);
		// resto trozos
		assertEquals("TRABAJADOR", trozos[6]);

	}

}
