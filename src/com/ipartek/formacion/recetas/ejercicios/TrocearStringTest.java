package com.ipartek.formacion.recetas.ejercicios;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TrocearStringTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		String linea = "Ted,Upton,Sant Andreu De La Barca,8,tedfupton@mailinator.com,12277015Y,TRABAJADOR";
		String[] trozos = linea.split(",");

		assertEquals("Ted", trozos[0]);
		assertEquals("Upton", trozos[1]);
		assertEquals("Sant Andreu De La Barca", trozos[2]);
		assertEquals("8", trozos[3]);
		assertEquals("tedfupton@mailinator.com", trozos[4]);
		assertEquals("12277015Y", trozos[5]);
		assertEquals("TRABAJADOR", trozos[6]);

	}

}
