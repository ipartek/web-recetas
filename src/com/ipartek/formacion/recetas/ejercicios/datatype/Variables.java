package com.ipartek.formacion.recetas;

import com.ipartek.formacion.recetas.pojo.LibroNoEncapsulado;

/**
 * Clase para relizar un 'Hello Wolrd'
 * 
 * @author ur00
 *
 */
public class Hola {

	/**
	 * metodo 'main' para ejecutar la clase
	 * 
	 * @param args
	 *            []String
	 */
	public static void main(String[] args) {

		// operador ternario
		// asignar un valor a una variable en funcion de una 'condicion'
		// ( condicion ) ? true : false;
		int edad = (3 < 100) ? 18 : 34;
		System.out.println("edad " + edad);

		System.out.println("-----------------------------");
		for (int i = 0; i < 2; i++) {
			System.out.println("Valor de i= " + i);
		}
		System.out.println("-----------------------------");

		for (int i = 0; i < 2; ++i) {
			System.out.println("Valor de i= " + i);
		}

		// decalarar variables
		int iEntera;
		boolean bBooleana = true;
		if (!bBooleana) {
			System.out.println("ES verdadero");
		} else {
			System.out.println("ES falso");
		}

		float dineroCuenta = 10.23f; // 10,23 €
		float dineroCuenta2 = (float) 10.23;

		char caracter = 'p';
		String cadena = "dobles";

		System.out.println("Hello World");

		// instanciar un objeto de la clase Libro
		LibroNoEncapsulado libroJava = new LibroNoEncapsulado();
		libroJava.numeroPaginas = 320;
		libroJava.nombre = "Java 7";
		libroJava.autor = "Roberto Montero Miguel";

		String retorno = libroJava.describete();
		System.out.println(retorno);

		System.out.println("escribir 10 paginas nuevas");
		// for (int i = 0; i < 10; i++) {

		int paginasAEscribir = 10;
		libroJava.escribir(paginasAEscribir);
		// }

		System.out.println(libroJava.describete());

		LibroNoEncapsulado libroHtml = new LibroNoEncapsulado();
		libroHtml.numeroPaginas = 723;
		libroHtml.nombre = "Html y PHP";

		System.out.println(libroHtml.describete());

	}

}
