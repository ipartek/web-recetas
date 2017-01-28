package com.ipartek.formacion.recetas.ejercicios.datatype;

public class LibroNoEncapsulado {

	//Declarar
	public int numeroPaginas;
	public String nombre;
	public String autor;

	/**Aumentamos el numero de paginas +1*/
	public void escribir(int numPaginas) {
		this.numeroPaginas += numPaginas;
	}

	//toString()
	@Override
	public String toString() {
		return "LibroNoEncapsulado [numeroPaginas=" + numeroPaginas + ", nombre=" + nombre + ", autor=" + autor + "]";
	}
}
