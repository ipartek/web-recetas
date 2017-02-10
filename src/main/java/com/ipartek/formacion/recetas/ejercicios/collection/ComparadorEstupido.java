package com.ipartek.formacion.recetas.ejercicios.collection;

import java.util.Comparator;

public class ComparadorEstupido implements Comparator<InterfazEstupida> {

	@Override
	public int compare(InterfazEstupida o1, InterfazEstupida o2) {
		return o1.getPeso() - o2.getPeso();
	}

}
