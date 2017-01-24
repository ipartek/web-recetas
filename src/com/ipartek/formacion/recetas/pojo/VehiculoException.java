package com.ipartek.formacion.recetas.pojo;

public class VehiculoException extends Exception {

	private static final long serialVersionUID = 1L;

	public final static String MSG_ERROR_PLAZAS = "Numero de plazas no permitido";

	public VehiculoException(String msgError) {
		super(msgError);
	}

}