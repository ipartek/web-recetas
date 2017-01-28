package com.ipartek.formacion.recetas.ejercicios.herencia.pojo;

public abstract class ACirculo extends AObjetoGrafico {

	//Declaracion
	private int radio;

	//Constructor
	public ACirculo(int x, int y, int radio) {
		super(x, y);//AObjetoGrafico
		this.radio = radio;
	}

	//Getter & Setter
	public int getRadio() {
		return radio;
	}

	public void setRadio(int radio) {
		this.radio = radio;
	}
}