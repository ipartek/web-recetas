package com.ipartek.formacion.recetas.pojo;

/**
 * Gestion de mensajes para el usuario Basado en el compoonente Alerts de
 * Bootstrap3.
 * 
 * @author curso
 *
 */

public class Mensaje {

	public static final String CLASE_SUCCESS = "alert-sucess";
	public static final String CLASE_INFO = "alert-info";
	public static final String CLASE_WARNING = "alert-warning";
	public static final String CLASE_DANGER = "alert-danger";

	private String descripcion;
	private String clase;

	public Mensaje(String descripcion, String clase) {
		super();
		this.descripcion = descripcion;
		this.clase = clase;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getClase() {
		return clase;
	}

	public void setClase(String clase) {
		this.clase = clase;
	}

	public Mensaje() {
		super();
		this.clase = CLASE_DANGER;
		this.descripcion = "Error, algo esta fallando ):";
	}

	@Override
	public String toString() {
		return "Mensaje [descripcion=" + descripcion + ", clase=" + clase + "]";
	}

}
