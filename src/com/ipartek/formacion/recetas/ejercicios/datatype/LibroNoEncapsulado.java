package com.ipartek.formacion.recetas.pojo;

/**
 * Clase {@code Libro} representa un libro.
 *
 */
public class LibroNoEncapsulado {

	// Atributos
	/**
	 * int numeroPaginas numero paginas que contiene el {@code Libro}
	 */
	public int numeroPaginas;

	/**
	 * String nombre nombre del {@code Libro}
	 */
	public String nombre;

	/**
	 * String autor autor del {@code Libro}
	 */
	public String autor;

	// metodos o funciones

	/**
	 * Muestra por pantalla los atributos del Libro
	 */
	public String describete() {

		return "nombre: " + this.nombre + " paginas: " + this.numeroPaginas + " autor: " + this.autor;
	}

	/**
	 * Aumentamos el numero de paginas
	 * 
	 * @param numPaginas
	 *            <code>int</code> numero paginas nuevas escritas
	 */
	public void escribir(int numPaginas) {

		// this.numeroPaginas = this.numeroPaginas + numPaginas ;
		this.numeroPaginas += numPaginas;

	}

}
