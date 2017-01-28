package com.ipartek.formacion.recetas.ejercicios.datatype;

import java.util.ArrayList;

import com.ipartek.formacion.recetas.pojo.Ingrediente;
import com.ipartek.formacion.recetas.pojo.Receta;

public class ArraysGluten {

	public static void main(String[] args) {

		//Declaracion
		ArrayList<Ingrediente> ingredientes = new ArrayList<Ingrediente>();
		ingredientes.add(new Ingrediente("pimiento verde", 0.5f, false));
		ingredientes.add(new Ingrediente("Bonito", 500, false));
		ingredientes.add(new Ingrediente("patatas", 4, true));
		ingredientes.add(new Ingrediente("ajo", 1, false));
		Receta marmitako = new Receta("Marmitako by Karlos Arguiñano", ingredientes);
		marmitako.setComensales(16);
		marmitako.setDificultad("moderada");
		marmitako.setTiempo(90);

		//Syso
		if (!marmitako.isGlutenFree()) {
			System.out.println("CONTIENE GLUTEN");
		}
		System.out.println(marmitako.toString());
	}
}
