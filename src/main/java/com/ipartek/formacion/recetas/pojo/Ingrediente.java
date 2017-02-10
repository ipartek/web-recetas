package com.ipartek.formacion.recetas.pojo;

public class Ingrediente {

	private String nombre;
	private float cantidad;
	private boolean gluten;
	
	public Ingrediente(String nombre, float cantidad, boolean gluten) {
		super();
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.gluten = gluten;
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
