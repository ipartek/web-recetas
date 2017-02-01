package com.ipartek.formacion.recetas.ejercicios.enumeracion;

enum Vaso {
	// Tipos de vaso disponibles. Pasan al constructor su capacidad en cc.
	JARRA(500), TUBO(250), TERCIO(333), CAÑA(200), QUINTO(220), CHUPITO(25);
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

	String setDescripcion() {

		String resul = "";
		switch (this) {
		case JARRA:
			resul = "Jarra de cerveza";
			break;
		case CAÑA:
			resul = "Caña";
			break;
		case CHUPITO:
			resul = "chupito";
			break;
		case QUINTO:
			resul = "quinto";
			break;

		default:
			break;
		}
		return resul;

	}
}