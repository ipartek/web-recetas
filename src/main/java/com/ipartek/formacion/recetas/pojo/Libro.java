package com.ipartek.formacion.recetas.pojo;

public class Libro {

	// atributos y constantes
	private String titulo;
	private String autor;
	private int numeroPaginas;

	/*
	 * Constructores
	 * 
	 * Sirven para instanciar objetos de las Clase <br> Tienen el mismo nombre
	 * que la Clase No hace falta especificar el <code>return</code>
	 * 
	 * sobrecarga: es un metodo con el mismo nombre y mismo return, <br> pero
	 * diferentes parametros
	 * 
	 */

	// constructor por defecto
	public Libro() {
		super();
		this.numeroPaginas = 0;
		this.titulo = "desconocido";
		this.autor = "anonimo";
	}

	// constructor con parametros
	public Libro(String titulo, int numeroPAginas) {
		super();
		this.setNumeroPaginas(numeroPAginas);
		this.titulo = titulo;
		this.autor = "anonimo";
	}

	// getters y setters

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getNumeroPaginas() {
		return numeroPaginas;
	}

	/**
	 * En caso de ser negativo, seteamos a 0
	 * 
	 * @param numeroPaginas
	 */
	public void setNumeroPaginas(int numeroPaginas) {
		this.numeroPaginas = (numeroPaginas < 0) ? 0 : numeroPaginas;
	}

	// otros metodos

	@Override
	public String toString() {
		return "Libro [titulo=" + titulo + ", autor=" + autor + ", numeroPaginas=" + numeroPaginas + "]";
	}

}
