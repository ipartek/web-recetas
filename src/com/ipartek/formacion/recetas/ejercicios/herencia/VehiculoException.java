package com.ipartek.formacion.recetas.ejercicios.herencia;

public class VehiculoException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	final static String MSG_ERROR_PLAZAS = "Numero de plazas no permitido";
	final static String MSG_ERROR_MODELO = "Modelo vacio no permitido";
	
	public VehiculoException(String msgError) {
		super(msgError);
	}
}
