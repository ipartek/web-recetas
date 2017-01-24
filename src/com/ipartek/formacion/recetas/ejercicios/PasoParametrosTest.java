package com.ipartek.formacion.recetas.ejercicios;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ipartek.formacion.recetas.ejercicios.herencia.Vehiculo;
import com.ipartek.formacion.recetas.ejercicios.herencia.VehiculoException;

/**
 * Al pasar parametros a un metodo existen dos posiblidades:<br>
 * 1. Paso por valor (primitivos: int, boolean, etc.).<br>
 * 2. Paso por Referencia (cualquier Object o descendiente).<br>
 * 
 * En el paso por valor, se pasa una copia del valor primitovo.<r> Sin embargo,
 * en el paso por referencia, se pasa la posicion de memoria donde estan los
 * datos del Objeto.<br>
 * 
 * @author Curso
 *
 */
public class PasoParametrosTest {

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
	public void testParametroValor() {
		int x = 0;

		int y = suma(x);

		assertEquals(0, x);
		assertEquals(1, y);
	}

	@Test
	public void testParametroReferencia() throws VehiculoException {
		Vehiculo x = new Vehiculo();
		x.setPlazas(0);

		sumaPlazas(x);

		assertEquals(1, x.getPlazas());

	}

	private int suma(int pValor) {
		return ++pValor;
	}

	private void sumaPlazas(Vehiculo v) throws VehiculoException {
		v.setPlazas(v.getPlazas() + 1);
	}
}
