package com.ipartek.formacion.recetas.pojo.comparator;

import java.util.Comparator;

import com.ipartek.formacion.recetas.pojo.Receta;

public class ComparatorRecetaNivelDificultad implements Comparator<Receta> {

	@Override
	public int compare(Receta o1, Receta o2) {				
		return getPesoDificultad(o1) - getPesoDificultad(o2);
	}

	private int getPesoDificultad(Receta r){
		int resul = 0;
		
		switch (r.getDificultad()) {
		case Receta.FACIL:
			resul = 0;
			break;
		case Receta.MODERADO:
			resul = 5;
			break;
		case Receta.DIFICIL:
			resul = 10;
			break;	

		default:
			break;
		}
		
		return resul;
	}
	

}
