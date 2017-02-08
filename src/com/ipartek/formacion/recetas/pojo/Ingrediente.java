package com.ipartek.formacion.recetas.pojo;

public class Ingrediente {
	private long id;

	private String nombre;
	private float cantidad;
	private boolean gluten;

	// CONSTRUCTOR
	public Ingrediente() {

		this.id = -1;
		this.nombre = "";
		this.cantidad = 0;
		this.gluten = false;

	}

	public Ingrediente(String nombre, float cantidad, boolean gluten) {
		super();
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.gluten = gluten;
	}

	// GETTERS AND SETTERS
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getCantidad() {
		return cantidad;
	}

	public void setCantidad(float cantidad) {
		this.cantidad = cantidad;
	}

	public boolean isGluten() {
		return gluten;
	}

	public void setGluten(boolean gluten) {
		this.gluten = gluten;
	}

	@Override
	public String toString() {
		return "Ingrediente [nombre=" + nombre + ", cantidad=" + cantidad + ", gluten=" + gluten + "]";
	}

}
