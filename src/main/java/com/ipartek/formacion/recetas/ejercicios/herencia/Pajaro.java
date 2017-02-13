package com.ipartek.formacion.recetas.ejercicios.herencia;

import com.ipartek.formacion.recetas.ejercicios.collection.InterfazEstupida;

public class Pajaro extends Animal implements Vendible, Volador, InterfazEstupida {

	private boolean volador;
	private int numHuevosSemana;

	public Pajaro(String raza, float precio) {
		super(raza, precio);
		this.volador = false;
		this.numHuevosSemana = 0;
	}

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

	@Override
	public void despegar() {
		System.out.println("Legando a las alturas");
	}

	@Override
	public void aterrizar() {
		System.out.println("Aterriza como puedas 2 y un medio");

	}

	@Override
	public void generarFactura() {
		System.out.println("Factura generada");

	}

	@Override
	public int getPeso() {
		return this.getNumHuevosSemana();
	}

}
