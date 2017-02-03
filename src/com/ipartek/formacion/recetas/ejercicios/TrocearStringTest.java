package com.ipartek.formacion.recetas.ejercicios;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TrocearStringTest {

	@Test
	public void test() {
		String linea = "Mildred,Rivera,Ares,15,MildredRRivera@dodgit.com,71255654K,TRABAJADOR";
		String[] trozos = linea.split(",");
		

		assertEquals("Mildred", trozos[0]);
		assertEquals("Rivera", trozos[1]);
		assertEquals("Ares", trozos[2]);
		assertEquals("15", trozos[3]);
		assertEquals("MildredRRivera@dodgit.com", trozos[4]);
		assertEquals("71255654K", trozos[5]);
		assertEquals("TRABAJADOR", trozos[6]);
	}

}
