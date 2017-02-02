package com.ipartek.formacion.recetas.ejercicios.herencia;

import java.io.Serializable;

abstract public class HerenciMultipleInterfaz implements interface1, interface2, Serializable {

	@Override
	public void sinmas() {
		String nombres[] = { "Juan", "Maria", "Antonio", "Victoria" };
		System.out.println("La longuitud del array es= ");

	}

}
