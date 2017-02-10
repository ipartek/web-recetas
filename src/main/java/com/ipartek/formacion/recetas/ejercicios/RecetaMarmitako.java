package com.ipartek.formacion.recetas.ejercicios;

import java.util.ArrayList;

import com.ipartek.formacion.recetas.pojo.Ingrediente;
import com.ipartek.formacion.recetas.pojo.Receta;

public class RecetaMarmitako {

	public static void main(String[] args) {

		// Crear Ingredientes
		ArrayList<Ingrediente> ingredientes = new ArrayList<Ingrediente>();
		ingredientes.add(new Ingrediente("pimiento verde", 0.5f, false));
		ingredientes.add(new Ingrediente("Bonito", 500, false));
		ingredientes.add(new Ingrediente("patatas", 4, false));
		ingredientes.add(new Ingrediente("ajo", 1, false));

		// crear Receta
		Receta marmitako = new Receta("Marmitako by Karlos Arguiñano", ingredientes);
		marmitako.setComensales(16);
		// marmitako.setDescripcion("");
		marmitako.setDificultad("moderada");
		marmitako.setTiempo(90);

		// mostrar por pantalla
		System.out.println("Marmitako rico rigo, la receta es:");
		if (!marmitako.isGlutenFree()) {
			System.out.println("***CONTIENE GLUTEN, atención alergicos");
		}
		System.out.println(marmitako.toString());

	}

}
