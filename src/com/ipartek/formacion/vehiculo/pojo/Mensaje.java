package com.ipartek.formacion.vehiculo.pojo;

/**
 * Gestion de mensajes para el usuario<br>
 * basado en bootstrap 3.
 * 
 * @author Curso
 * @see :http://getbootstrap.com/components/#alerts
 */
public class Mensaje {
	private String descripcion;
	private String clase;

	public static final String CLASE_SUCCESS = "alert-success";
	public static final String CLASE_INFO = "alert-info";
	public static final String CLASE_WARNING = "alert-warning";
	public static final String CLASE_DANGER = "alert-danger";

	public Mensaje() {
		super();
		this.clase = CLASE_DANGER;
		this.descripcion = "Upps !!! Algo falla ";

	}

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

	@Override
	public String toString() {
		return "Mensaje [descripcion=" + descripcion + ", clase=" + clase + "]";
	}

}
