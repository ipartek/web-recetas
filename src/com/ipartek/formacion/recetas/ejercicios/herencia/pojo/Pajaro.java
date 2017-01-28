package com.ipartek.formacion.recetas.ejercicios.herencia.pojo;

import com.ipartek.formacion.recetas.ejercicios.comparator.IComparator;
import com.ipartek.formacion.recetas.ejercicios.herencia.IVendible;
import com.ipartek.formacion.recetas.ejercicios.herencia.IVolador;

public class Pajaro extends Animal implements IVendible, IVolador, IComparator {

	//Declaracion
	private boolean volador;
	private int numHuevosSemana;

	//Constructor
	public Pajaro(String raza, float precio) {
		super(raza, precio);
		this.volador = false;
		this.numHuevosSemana = 0;
	}

	//Getter & Setter
	public int getNumHuevosSemana() {
		return numHuevosSemana;
	}

	public void setNumHuevosSemana(int numHuevosSemana) {
		this.numHuevosSemana = numHuevosSemana;
	}

	public boolean isVolador() {
		return volador;
	}

	public void setVolador(boolean volador) {
		this.volador = volador;
	}

	//IVolador
	@Override
	public void despegar() {
		System.out.println("Legando a las alturas");
	}

	@Override
	public void aterrizar() {
		System.out.println("Aterriza como puedas 2 y un medio");

	}

	//IVendible
	@Override
	public void generarFactura() {
		System.out.println("Factura generada");

	}
	
	//IComparator
	@Override
	public int getPeso() {
		return this.getNumHuevosSemana();
	}
}