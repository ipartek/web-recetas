package com.ipartek.formacion.recetas.ejercicios.datatype;

public class Variables {

	public static void main(String[] args) {

		//Declaracion
		int iEntera = 10;
		boolean bBooleana = true;
		float dineroCuenta = 10.23f;
		char caracter = 'p';
		String cadena = "dobles";

		//Clase con Variables publicas
		LibroNoEncapsulado libroJava = new LibroNoEncapsulado();
		libroJava.numeroPaginas = 320;
		libroJava.nombre = "Java 7";
		libroJava.autor = "Roberto Montero Miguel";
		
		//Clase con Variables Privadas se accede mediante 
		//Getter & Setter
		Libro libroHtml = new Libro();
		libroHtml.setNumeroPaginas(700);;
		libroHtml.setTitulo("Html");


		//Syso
		System.out.println("Hello World");
		System.out.println(""+iEntera + bBooleana+ dineroCuenta + caracter + cadena);
		for (int i = 0; i < 4; i++) {
			System.out.println("i= " + i );
		}
		System.out.println(libroJava.toString());
		libroJava.escribir(10);
		System.out.println(libroJava.toString());
		System.out.println(libroHtml.toString());
	}
}
