package com.ipartek.formacion.recetas.ejercicios.enumeracion;

public enum EstadoCoche {

	NUEVO, SEGUNDA_MANO, KM0;
	
	String getDescripcion() {
		String resul = "Sin descripcion";
		switch(this){
		
		case NUEVO:
			resul = "Coche a estrenar";
			break;
		case KM0:
			resul = "Coche seminuevo, con menos de 100 km";
		case SEGUNDA_MANO:
			resul = "Coche segunda mano";
		default:
			break;
		}
		return resul;
	}
	
	
}
