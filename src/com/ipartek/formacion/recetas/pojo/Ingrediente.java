package com.ipartek.formacion.recetas.pojo;

public class Ingrediente {

	//Declaracion
	private String nombre;
	private float cantidad;
	private boolean gluten;
	
	//Constructor
	public Ingrediente(String nombre, float cantidad, boolean gluten) {
		super();
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.gluten = gluten;
	}

	//Getter & Setter
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

	//toString()
	@Override
	public String toString() {
		return "Ingrediente [nombre=" + nombre + ", cantidad=" + cantidad + ", gluten=" + gluten + "]";
	}	
}