package com.ipartek.formacion.recetas.pojo;

public class VehiculoException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public final static String MSG_ERROR_PLAZAS = "Numero de plazas no permitido";
	public final static String MSG_ERROR_MODELO = "Falta el modelo del coche";
	
	public VehiculoException(String msgError) {
		super(msgError);
	}
}
