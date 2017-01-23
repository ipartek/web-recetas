package com.ipartek.formacion.recetas.ejercicios.herencia;

public class VehiculoException extends Exception {

	private static final long serialVersionUID = 1L;
	public final static String MSG_ERROR_PLAZAS = "Número de plazas no permitido";

	public VehiculoException(String msg_Error) {
		super(msg_Error); // necesitamos este constructor para que en vehículos
							// puedan devolvernos el mensaje de error. El
							// constructor debe escribirse manualmente.
	}
}
