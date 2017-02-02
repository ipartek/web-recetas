package com.ipartek.formacion.recetas.ejercicios.datatype;

public class Libro {

	// Declaracion
	private String titulo;
	private String autor;
	private int numeroPaginas;

	// Constructor
	// Sirven para instanciar objetos de las Clase Tienen el mismo nombre que la
	// Clase, no hace falta especificar return
	public Libro() {
		super();
		this.numeroPaginas = 0;
		this.titulo = "desconocido";
		this.autor = "anonimo";
	}

	// Constructor con parametros
	public Libro(String titulo, int numeroPAginas) {
		super();
		this.setNumeroPaginas(numeroPAginas);
		this.titulo = titulo;
		this.autor = "anonimo";
	}

	// Getter & Setter
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

	/** En caso de ser negativo, set a 0 @param numeroPaginas */
	public void setNumeroPaginas(int numeroPaginas) {
		this.numeroPaginas = (numeroPaginas < 0) ? 0 : numeroPaginas;
	}

	// toString()
	// sobreescritura es un metodo con el mismo nombre y mismo return
	@Override
	public String toString() {
		return "Libro [titulo=" + titulo + ", autor=" + autor + ", numeroPaginas=" + numeroPaginas + "]";
	}

}
