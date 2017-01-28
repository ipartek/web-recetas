package com.ipartek.formacion.recetas.ejercicios.herencia.pojo;

public class Linea extends AObjetoGrafico {

	//Declaracion
	private int longitud;

	//Constructor
	public Linea(int x, int y) {	
		super(x, y);//AObjetoGrafico
		this.longitud = 100;
	}

	//Getter & Setter
	public int getLongitud() {
		return longitud;
	}

	public void setLongitud(int longitud) {
		this.longitud = longitud;
	}
	
	//AObjetoGrafico
		@Override
		public void dibujar() {
			System.out.println(this.x + this.y + this.longitud);
	}
}