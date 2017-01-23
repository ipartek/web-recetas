package com.ipartek.formacion.recetas.ejercicios.herencia;

public class VehiculoException extends Exception {

	private static final long serialVersionUID = 1L; // hay que meter esto si
														// extiende de una clase
														// serializable.

	public final static String MSG_ERROR_PLAZAS = "Numero de plazas no permitido";

	public VehiculoException(String msgError) {
		super(msgError);
	}

}
