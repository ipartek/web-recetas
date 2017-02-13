package com.ipartek.formacion.recetas.pojo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class RecetaTest {

	// variables globales, se inicializan en "setUp"
	public Receta tortillaPatatas = null;
	public Ingrediente huevos = new Ingrediente("huevos", 12, true);
	public Ingrediente cebolla = new Ingrediente("cebolla", 1, true);
	public Ingrediente patatas = new Ingrediente("patatas", 4, true);

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		tortillaPatatas = new Receta("tortilla de patatas", null);
		tortillaPatatas.addIngrendiente(huevos);
		tortillaPatatas.addIngrendiente(cebolla);
		tortillaPatatas.addIngrendiente(patatas);
	}

	@After
	public void tearDown() throws Exception {
		tortillaPatatas = null;
	}

	@Test
	public void testAddIngrendiente() {
		Receta r = new Receta("Tortilla patatas", null);
		int numero = r.getIngredientes().size();
		assertEquals("No deben existir ingredientes", 0, numero);

		r.addIngrendiente(null);
		numero = r.getIngredientes().size();
		assertEquals("No deben existir ingredientes", 0, numero);

		r.addIngrendiente(new Ingrediente("", 0, true));
		numero = r.getIngredientes().size();
		assertEquals(1, numero);
	}

	@Test
	public void testRemoveIngrendiente() {

		Receta r = new Receta("Tortilla patatas", null);
		assertFalse(r.removeIngrendiente(null));

		tortillaPatatas.addIngrendiente(huevos);

		huevos.setNombre("HueVos");
		tortillaPatatas.removeIngrendiente(huevos);

		ArrayList<Ingrediente> ingredientes = tortillaPatatas.getIngredientes();
		assertEquals(3, ingredientes.size());

		// TODO comprobar que sean huevo, cebolla y patatas
		assertFalse(tortillaPatatas.contiene(null));
		assertFalse(tortillaPatatas.contiene(new Ingrediente("Salmonela", 2, true)));
		assertTrue(tortillaPatatas.contiene(huevos));
		assertTrue(tortillaPatatas.contiene(cebolla));
		assertTrue(tortillaPatatas.contiene(patatas));

	}

	@Test
	public void testConstructor() {

		Receta r = new Receta("Tortilla patatas", null);
		assertNotNull("Deberia estar inicializado a new", r.getIngredientes());

	}

	@Test
	public void testIsGlutenFree() {

		ArrayList<Ingrediente> ingredientes = new ArrayList<Ingrediente>();
		ingredientes.add(new Ingrediente("pimiento verde", 0.5f, true));
		ingredientes.add(new Ingrediente("Bonito", 500, true));

		// caso1 todos los ingredientes con gluten
		Receta r = new Receta("", ingredientes);
		assertFalse("caso1 todos los ingredientes con gluten", r.isGlutenFree());

		// caso2 todos los ingredientes SIN gluten
		ingredientes.clear();
		ingredientes.add(new Ingrediente("", 0, false));
		ingredientes.add(new Ingrediente("", 0, false));

		r = new Receta("", ingredientes);
		assertTrue("caso2 todos los ingredientes SIN gluten", r.isGlutenFree());

		// caso3 todos los ingredientes con y sin gluten
		ingredientes.clear();
		ingredientes.add(new Ingrediente("", 0, true));
		ingredientes.add(new Ingrediente("", 0, false));

		r = new Receta("", ingredientes);
		assertFalse("caso3 todos los ingredientes con y sin gluten", r.isGlutenFree());

		// caso4 sin ingredientes (null)
		r = new Receta("", null);
		assertTrue("caso4 sin ingredientes", r.isGlutenFree());

	}

}
