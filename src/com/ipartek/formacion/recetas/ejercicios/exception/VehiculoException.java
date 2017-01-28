package com.ipartek.formacion.recetas.ejercicios.exception;
/**CustomException <br>
 * Extiende de Exception <br>
 * Pasa Valores a Exception
 * @param MSG_ERROR_PLAZAS
 * @param MSG_ERROR_DIMENSIONES
 * @param MSG_ERROR_Potencia*/
public class VehiculoException extends Exception {
	
	//Declaracion de mensajes de error
	private static final long serialVersionUID = 1L;
	public final static String MSG_ERROR_PLAZAS = "Numero de plazas no permitido ";
	public final static String MSG_ERROR_DIMENSIONES = "Dimensiones no permitidas ";
	public final static String MSG_ERROR_POTENCIA = "Potencia no permitida ";

	//Pasa esos mensajes a su padre Exception
	public VehiculoException(String msgError) {
		super(msgError);
	}
}