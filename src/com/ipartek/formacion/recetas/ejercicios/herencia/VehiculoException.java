package com.ipartek.formacion.recetas.ejercicios.herencia;

public class VehiculoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public final static String MSG_ERROR_MODELO = "El vehiculo debe de tener un modelo.";
	public final static String MSG_ERROR_DIMENSIONES = "Las dimensiones no son correctas.";
	public final static String MSG_ERROR_PLAZAS = "Numero de plazas no permitido.";
	public final static String MSG_ERROR_POTENCIA = "Esta potencia no esta permitida.";

	public VehiculoException(String msgError) {
		super(msgError);
	}
}