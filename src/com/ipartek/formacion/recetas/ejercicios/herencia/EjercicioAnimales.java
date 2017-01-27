package com.ipartek.formacion.recetas.ejercicios.herencia;

import java.util.ArrayList;

/**
 * Ejercicio para aprender a usar la Herencia e interfaces.<br>
 * Capitulo 8 del Libro Java 7.<br>
 * 
 * @author ur00
 *
 */
public class ListaAnimalesTienda {

	public static void main(String[] args) {

		// crear objetos
		Burro b1 = new Burro("Platero");
		b1.setPrecio(300f);

		Burro b2 = new Burro("Rajoy");
		b2.setPrecio(3.25f);

		Pajaro kiwi = new Pajaro("kiwi", 1000f);
		Pajaro buitre = new Pajaro("Biutre", 500f);
		buitre.setVolador(true);

		// añadir en ArrayList
		ArrayList<Vendible> stock = new ArrayList<Vendible>();
		stock.add(b1);
		stock.add(b2);
		stock.add(kiwi);
		stock.add(buitre);

		// mostrar por pantalla
		Burro b = null;
		Pajaro p = null;
		for (Vendible v : stock) {

			if (v instanceof Burro) {
				b = (Burro) v;
				System.out.println(b.getRaza() + " [" + b.getNombre() + "]");
				System.out.println("------------------------");
				System.out.println("Precio: " + b.getPrecio());
				System.out.println("Comestible: Si");
				System.out.println("Volador: No");

			} else if (v instanceof Pajaro) {
				p = (Pajaro) v;
				System.out.println(p.getRaza());
				System.out.println("------------------------");
				System.out.println("Precio: " + b.getPrecio());
				System.out.println("Comestible: No");
				if (p.isVolador()) {
					System.out.println("Volador: Si");
				} else {
					System.out.println("Volador: No");
				}

			} else {
				System.out.println("**** No sabes que eres " + v.toString());
			}

			System.out.println();
			System.out.println();

		}

	}

}
