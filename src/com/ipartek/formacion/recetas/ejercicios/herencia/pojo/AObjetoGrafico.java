package com.ipartek.formacion.recetas.ejercicios.herencia.pojo;

public abstract class AObjetoGrafico {

	//Declaracion
	//La pueden usar sus hijas
	protected int x;
	protected int y;

	//Constructor
	public AObjetoGrafico(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	//Getter & Setter
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	//Metodos
	public void mover(int x, int y) {
		System.out.println("Objeto movido a nueva posicion " + x + " " + y);
	}

	//Clase abstracta
	public abstract void dibujar();
	
	//Clase Interna
		class GeoPunto {
			public float latitud;
			public float longitud;
		}
}