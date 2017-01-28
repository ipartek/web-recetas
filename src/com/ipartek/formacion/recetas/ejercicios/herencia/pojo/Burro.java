package com.ipartek.formacion.recetas.ejercicios.herencia.pojo;

import java.util.ArrayList;

import com.ipartek.formacion.recetas.ejercicios.herencia.ICocinable;
import com.ipartek.formacion.recetas.ejercicios.herencia.IConducible;
import com.ipartek.formacion.recetas.ejercicios.herencia.IVendible;
import com.ipartek.formacion.recetas.pojo.Ingrediente;

public class Burro extends Animal implements IConducible, ICocinable, IVendible {

	//Declaracion
	private static final long serialVersionUID = 1L;
	private String nombre;

	//Constructor 1 parametro
	public Burro(String nombre) {
		super("", 0);
		setRaza("burro");
		this.nombre = nombre;
	}

	//Getter & Setter
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	//IConducible
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
	
	//ICocinable
	@Override
	public ArrayList<Ingrediente> getIngredientes() {
		return new ArrayList<Ingrediente>();
	}

	@Override
	public String getDescripcionReceta() {
		return "Sal pimentar y a la cazuela";
	}

	//IVendible
	@Override
	public void generarFactura() {
		System.out.println("Factura generada");
	}
	
	//toString()
	@Override
	public String toString() {
		return "Burro [nombre=" + nombre + "]";
	}
}