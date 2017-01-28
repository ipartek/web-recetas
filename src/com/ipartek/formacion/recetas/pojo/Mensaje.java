package com.ipartek.formacion.recetas.pojo;
/**Gestion de mensajes para el usuario
 * @see: http://getbootstrap.com/components/#alerts*/
public class Mensaje {

	//Declaracion
	public static final String CLASE_SUCCESS = "alert-success";
	public static final String CLASE_INFO = "alert-info";
	public static final String CLASE_WARNING = "alert-warning";
	public static final String CLASE_DANGER = "alert-danger";
	private String descripcion;
	private String clase;

	//Constructor
	public Mensaje() {
		super();
		this.clase = CLASE_DANGER;
		this.descripcion = "Error!!! Upsss algo esta fallando";
	}

	//Constructor parametros
	public Mensaje(String descripcion, String clase) {
		super();
		this.descripcion = descripcion;
		this.clase = clase;
	}

	//Getter & Setter
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

	//toString()
	@Override
	public String toString() {
		return "Mensaje [descripcion=" + descripcion + ", clase=" + clase + "]";
	}
}