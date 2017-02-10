package com.ipartek.formacion.recetas.ejercicios.herencia;

public class CirculoNoAbstracto extends Circulo {

	public CirculoNoAbstracto(int x, int y) {
		super(x, y);
	}

	@Override
	public void dibujar() {
		System.out.println("Pintar Circulo");
	}

}
