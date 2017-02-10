package com.ipartek.formacion.recetas.ejercicios.enumeracion;

public enum EstadoCoche {

	NUEVO, SEGUNDA_MANO, KM0;

	String getDescripcion() {
		String resul = "sin descripcion";
		switch (this) {

		case NUEVO:
			resul = "Coche a extrenar";
			break;

		case KM0:
			resul = "Coche semi nuevo, con menos de 100 km";
			break;

		case SEGUNDA_MANO:
			resul = "Coche segunda mano";
			break;

		default:
			break;
		}
		return resul;
	}

}
