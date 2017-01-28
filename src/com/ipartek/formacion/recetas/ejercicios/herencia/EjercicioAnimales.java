package com.ipartek.formacion.recetas.ejercicios.herencia;
/**Gestionar Objetos de diferentes Clases mediante Interfaces*/
import java.util.ArrayList;

import com.ipartek.formacion.recetas.ejercicios.herencia.pojo.Burro;
import com.ipartek.formacion.recetas.ejercicios.herencia.pojo.Pajaro;

public class EjercicioAnimales {

	public static void main(String[] args) {

		//Declaracion
		ArrayList<IVendible> animales;
		Burro b;
		Burro b1;
		Burro b2;
		Pajaro p;
		Pajaro p1;
		Pajaro p2;
		
		//Instanciar y asignar
		animales = new ArrayList<IVendible>();
		b1 = new Burro("Platero");
		b2 = new Burro("Rajoy");
		p1 = new Pajaro("kiwi", 1000f);
		p2 = new Pajaro("Biutre", 500f);
		b1.setPrecio(300f);
		b2.setPrecio(3.25f);
		p1.setVolador(false);
		p2.setVolador(true);
		
		//Añadir a ArrayList
		
		animales.add(b1);
		animales.add(b2);
		animales.add(p1);
		animales.add(p2);

		//Syso
		for (IVendible a : animales) {

			//Burro
			if (a instanceof Burro) {
				b = (Burro) a;
				System.out.println(b.getRaza() + " [" + b.getNombre() + "]");
				System.out.println("------------------------");
				System.out.println("Precio: " + b.getPrecio());
				System.out.println("Cocinable: Si");
				System.out.println("Volador: No");

			//Pajaro
			} else if (a instanceof Pajaro) {
				p = (Pajaro) a;
				System.out.println(p.getRaza());
				System.out.println("------------------------");
				System.out.println("Precio: " + p.getPrecio());
				System.out.println("Comestible: No");
				if (p.isVolador()) {
					System.out.println("Volador: Si");
				} else {
					System.out.println("Volador: No");
				}

			//Si no es PajaroBurro	
			} else {
				System.out.println("**** No sabes que eres " + a.toString());
			}
		}
	}
}