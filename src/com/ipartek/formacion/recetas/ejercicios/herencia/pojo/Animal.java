package com.ipartek.formacion.recetas.ejercicios.herencia.pojo;

public class Animal {

	//Declaracion
	private String raza;
	private float precio;

	//Constructor
	public Animal(String raza, float precio) {
		super();
		this.raza = raza;
		this.precio = precio;
	}

	//Getter & Setter
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

	//toString()
	@Override
	public String toString() {
		return "Animal [raza=" + raza + ", precio=" + precio + "]";
	}
}