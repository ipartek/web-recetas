package com.ipartek.formacion.recetas.ejercicios.herencia.pojo;

public class Circulo extends ACirculo {

	//Declaracion
	//Circulo con radio predefinido
	private static int radio;
		
	//Constructor
	public Circulo(int x, int y) {
		super(x, y, radio); //ACirculo
	}

	//AObjetoGrafico
	@Override
	public void dibujar() {
		System.out.println("Pintar Circulo");
	}
}