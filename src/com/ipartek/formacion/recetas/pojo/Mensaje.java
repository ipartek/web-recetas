package com.ipartek.formacion.recetas.pojo;

public class Mensaje {
	
	public static final String CLASE_SUCCESS = "alert-success";
	public static final String CLASE_WARNING = "alert-warning";
	public static final String CLASE_DANGER = "alert-danger";
	public static final String CLASE_INFO = "alert-info";
	
	
	private String descripcion;
	private String clase;
	
	public Mensaje() {
		super();
		this.clase = CLASE_DANGER;
		this.descripcion = "Error, algo esta fallando.";
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
