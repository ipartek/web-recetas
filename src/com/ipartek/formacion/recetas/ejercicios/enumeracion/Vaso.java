package com.ipartek.formacion.recetas.ejercicios.enumeracion;

public enum Vaso {
	// Tipos de vaso disponibles. Pasan al constructor su capacidad en cc.
	JARRA(500), TUBO(250), TERCIO(333), CAÑA(200), CRIANZA(20), QUINTO(220);
	private int cc; // Variable interna donde almacenaremos la capacidad
	// Nuestro constructor nos fuerza a pasar parámetros al definir un nuevo
	// tipo

	Vaso(int cc) {
		this.cc = cc;
	}

	// Devuelve la capacidad del vaso
	public int getCentimetrosCubicos() {
		return cc;
	}

}
