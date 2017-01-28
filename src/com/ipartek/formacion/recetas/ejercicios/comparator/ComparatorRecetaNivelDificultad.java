package com.ipartek.formacion.recetas.ejercicios.comparator;

import java.util.Comparator;

import com.ipartek.formacion.recetas.pojo.Receta;

public class ComparatorRecetaNivelDificultad implements Comparator<Receta> {

	@Override
	public int compare(Receta o1, Receta o2) {				
		
		return getPesoDificultad(o1) - getPesoDificultad(o2);
		//Orden Descendiente
		//getPesoDificultad(o2) - getPesoDificultad(o1)
	
	}
	
	/**
	 * 0 FACIL
	 * 10 DIFICL
	 * @param r Receta receta
	 * @return int 0-10 dependiendo de getDificultad()
	 */
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
