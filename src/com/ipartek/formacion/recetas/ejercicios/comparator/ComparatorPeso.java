package com.ipartek.formacion.recetas.ejercicios.comparator;

import java.util.Comparator;

public class ComparatorPeso implements Comparator<IComparator> {

	@Override
	public int compare(IComparator o1, IComparator o2) {
		
		return o1.getPeso() - o2.getPeso();
		//Ordenacion Descendente
		//o2.getPeso() - o1.getPeso() 
		
	}
	//@Override
	//public int getPeso() {
	//	return (int) this.potencia;
	//}
			
	//@Override
	//public int getPeso() {
	//	return this.getNumHuevosSemana();
	//}
}
