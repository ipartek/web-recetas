package com.ipartek.formacion.recetas.ejercicios.datatype;

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

import com.ipartek.formacion.recetas.pojo.Ingrediente;
import com.ipartek.formacion.recetas.pojo.Receta;

public class RecetaTest {

	//Declaracion
	public ArrayList<Ingrediente> ingredientes;
	public Receta tortillaPatatas;
	public Ingrediente huevos;
	public Ingrediente cebolla;
	public Ingrediente patatas;

	//Se ejecuta una vez ANTES de RecetaTest
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	//Se ejecuta una vez DESPUES de RecetaTest
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	//Se ejecuta una vez ANTES de CADA test
	@Before
	public void setUp() throws Exception {
		ingredientes = new ArrayList<Ingrediente>();
		huevos = new Ingrediente("huevos", 12, false);
		cebolla = new Ingrediente("cebolla", 1, false);
		patatas = new Ingrediente("patatas", 4, false);
		tortillaPatatas = new Receta("tortilla de patatas", null);
		tortillaPatatas.addIngrendiente(huevos);
		tortillaPatatas.addIngrendiente(cebolla);
		tortillaPatatas.addIngrendiente(patatas);
	}

	//Se ejecuta una vez DESPUES de CADA test
	@After
	public void tearDown() throws Exception {
		tortillaPatatas = null;
		huevos = null;
		cebolla = null;
		patatas = null;
	}

	//Add
	@Test
	public void testAddIngrendiente() {
		
		assertEquals("Solo los Inicializados", 3, tortillaPatatas.getIngredientes().size());

		tortillaPatatas.addIngrendiente(null);
		assertEquals("Solo los Inicializados", 3,tortillaPatatas.getIngredientes().size());

		tortillaPatatas.addIngrendiente(new Ingrediente("", 0, true));
		assertEquals(4, tortillaPatatas.getIngredientes().size());
	}

	//Remove
	@Test
	public void testRemoveIngrendiente() {

		ingredientes = tortillaPatatas.getIngredientes();		
		tortillaPatatas.removeIngrendiente(huevos);		
		assertEquals(2, ingredientes.size());
		assertFalse(tortillaPatatas.contiene(null));
		assertFalse(tortillaPatatas.contiene(new Ingrediente("Salmonela", 2, true)));
		assertFalse(tortillaPatatas.contiene(huevos));
		assertTrue(tortillaPatatas.contiene(cebolla));
		assertTrue(tortillaPatatas.contiene(patatas));

	}

	@Test
	public void testConstructor() {

		tortillaPatatas = new Receta("Tortilla patatas", null);
		assertNotNull("Inicializado", tortillaPatatas.getIngredientes());

	}

	//Gluten
	@Test
	public void testIsGlutenFree() {

		//Con Gluten
		ingredientes.add(new Ingrediente("pimiento verde", 0.5f, false));
		ingredientes.add(new Ingrediente("Bonito", 500, true));
		Receta r = new Receta("", ingredientes);
		assertFalse("gluten", r.isGlutenFree());

		//Sin Gluten
		ingredientes.clear();
		ingredientes.add(new Ingrediente("", 0, false));
		ingredientes.add(new Ingrediente("", 0, false));
		r = new Receta("", ingredientes);	
		assertTrue("sin gluten", r.isGlutenFree());

		//Null
		r = new Receta("", null);
		assertTrue("sin gluten", r.isGlutenFree());

	}

}
