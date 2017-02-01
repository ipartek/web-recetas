package com.ipartek.formacion.recetas.ejercicios.enumeration;

public enum EstadoCoche {

	NUEVO, SEGUNDA_MANO, KM0;

	String getDescripcion() {
		String resul = "Sin descripcion";
		switch (this) {
		case NUEVO:
			resul = "Coche a estrenar";
			break;

		case SEGUNDA_MANO:
			resul = "Coche de segunda mano";
			break;

		case KM0:
			resul = "Coche con menos de 100km";
			break;

		}
		return resul;

	}
}
