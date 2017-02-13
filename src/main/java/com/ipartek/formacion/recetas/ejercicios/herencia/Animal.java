package com.ipartek.formacion.recetas.ejercicios.herencia;

public class Animal {

	private String raza;
	private float precio;

	public Animal(String raza, float precio) {
		super();
		this.raza = raza;
		this.precio = precio;
	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Animal [raza=" + raza + ", precio=" + precio + "]";
	}

}
