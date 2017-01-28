package com.ipartek.formacion.recetas.ejercicios.comparator;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ipartek.formacion.recetas.ejercicios.herencia.pojo.Pajaro;
import com.ipartek.formacion.recetas.ejercicios.herencia.pojo.Vehiculo;
import com.ipartek.formacion.recetas.pojo.Receta;

public class ComparatorComparableTest {
	
	//Declaracion
	ArrayList<Receta> recetas ;
	private Receta solomillo ;
	private Receta marmitako ;
	private Receta tortilla ;

	private ArrayList<IComparator> pajarosVehiculos;
	private Vehiculo vSeat;
	private Vehiculo vFord;
	private Pajaro pKiwi;
	private Pajaro pGallina;

	//Se ejecuta antes de CADA Test
	@Before
	public void setUp() throws Exception {
		
		//Instanciar ArrayList
		recetas = new ArrayList<Receta>();
		
		//Instanciar Ingrediente-s 
		//Asignar setDificultad()
		solomillo = new Receta("solomillo");
		solomillo.setDificultad(Receta.MODERADO);
		marmitako = new Receta("marmitako");
		marmitako.setDificultad(Receta.DIFICIL);
		tortilla = new Receta("Torilla Patatas");
		tortilla.setDificultad(Receta.FACIL);

		//Añadir a ArrayList()
		recetas.add(solomillo);
		recetas.add(marmitako);
		recetas.add(tortilla);

		//Otra vez
		pajarosVehiculos = new ArrayList<IComparator>();
		
		vSeat = new Vehiculo("Seat");
		vSeat.setPotencia(500);
		vFord = new Vehiculo("Ford K");
		vFord.setPotencia(100);
		pKiwi = new Pajaro("Kiwi", 0);
		pKiwi.setNumHuevosSemana(2);
		pGallina = new Pajaro("Gallina", 0);
		pGallina.setNumHuevosSemana(700);

		pajarosVehiculos.add(vSeat);
		pajarosVehiculos.add(vFord);
		pajarosVehiculos.add(pKiwi);
		pajarosVehiculos.add(pGallina);
	}
	
	//Se ejecuta despues de CADA Test
	@After
	public void tearDown() throws Exception {
		recetas = null;
		solomillo = null;
		tortilla = null;
		marmitako = null;

		pajarosVehiculos = null;
		vSeat = null;
		pKiwi = null;
		vFord = null;
		pGallina = null;
	}

	//COMPARABLE
	@Test
	public void testComparable() {

		//Ordena A-Z
		Collections.sort(recetas);
		
		//Como Metodo propio
		//@Override
		//public int compareTo(Objeto o) {		
		//	return this.getTitulo().toLowerCase().compareTo(o.getTitulo().toLowerCase());
		//}

		assertEquals(marmitako, recetas.get(0));
		assertEquals(solomillo, recetas.get(1));
		assertEquals(tortilla, recetas.get(2));

		//Ordena Z-A
		Collections.sort(recetas, Collections.reverseOrder());
		
		assertEquals(marmitako, recetas.get(2));
		assertEquals(solomillo, recetas.get(1));
		assertEquals(tortilla, recetas.get(0));

	}

	//COMPARATOR
	@Test
	public void testComparator() {
		
		//assertEquals muestra un mensaje en caso de error
		final String MSG_ERROR_DIFICULTAD = "No ordena por nivel de dificultad";
		
		//Instaciar y pasar el Comparator a Collections.sort()
		Collections.sort(recetas, new ComparatorRecetaNivelDificultad());

		assertEquals(MSG_ERROR_DIFICULTAD, tortilla, recetas.get(0));
		assertEquals(MSG_ERROR_DIFICULTAD, solomillo, recetas.get(1));
		assertEquals(MSG_ERROR_DIFICULTAD, marmitako, recetas.get(2));

	}

	@Test
	public void testComparatorInterfaz() {

		//Instaciar y pasar el Comparator a Collections.sort()
		Collections.sort(pajarosVehiculos, new ComparatorPeso());

		//Si los objetos son de dos clases diferentes necesitan implementar una Interfaz
		//public interface IComparator {
			//int getPeso();
		//}
		
		//Asi pueden implementar el mismo metodo de dos formas diferentes
		//@Override
		//public int getPeso() {
		//	return (int) this.potencia;
		//}
		
		//@Override
		//public int getPeso() {
		//	return this.getNumHuevosSemana();
		//}
		
		assertEquals(pKiwi, pajarosVehiculos.get(0));
		assertEquals(vFord, pajarosVehiculos.get(1));
		assertEquals(vSeat, pajarosVehiculos.get(2));
		assertEquals(pGallina, pajarosVehiculos.get(3));

	}

}
