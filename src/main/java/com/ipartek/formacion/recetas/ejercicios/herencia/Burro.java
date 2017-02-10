package com.ipartek.formacion.recetas.ejercicios.herencia;

import java.util.ArrayList;

import com.ipartek.formacion.recetas.pojo.Ingrediente;

public class Burro extends Animal implements Conducible, Cocinable, Vendible {

	private String nombre;

	public Burro(String nombre) {
		super("", 0);
		setRaza("burro");
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public void arrancar() {
		System.out.println("Arre burro");

	}

	@Override
	public void detener() {
		System.out.println("Soooooo");

	}

	@Override
	public void girar(String direccion) {
		System.out.println("giro a " + direccion);

	}

	@Override
	public String toString() {
		return "Burro [nombre=" + nombre + "]";
	}

	@Override
	public ArrayList<Ingrediente> getIngredientes() {
		return new ArrayList<Ingrediente>();
	}

	@Override
	public String getDescripcionReceta() {
		return "Sal pimentar y a la cazuela";
	}

	@Override
	public void generarFactura() {
		System.out.println("Factura generada");

	}

}
