package com.ipartek.formacion.recetas.ejercicios.enumeracion;

public enum EstadoCoche {

	NUEVO, SEGUNDA_MANO, KM0;

	String getDescripcion() {

		String resul = "Sin descripcion";

		switch (this) {
		case NUEVO:
			resul = "Coche a estrenar";
			break;
		case SEGUNDA_MANO:
			resul = "Coche segunda mano.";
			break;

		case KM0:
			resul = "Coche semi nuevo, con menos de 100 km.";
			break;

		default:

			break;
		}
		return "";
	}

}
