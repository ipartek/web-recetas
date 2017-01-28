package com.ipartek.formacion.recetas.ejercicios.exception;
/** RUN AS/Java Aplication */
public class Excepciones {

	public static void main(String[] args) throws Exception {
		System.out.println("Empezamos Main");
		metodoA();
		System.out.println("Terminamos Main");
	}

	public static void metodoA() throws Exception {
		System.out.println("Empezamos MetodoA");
		metodoB();
		System.out.println("Terminamos MetodoA");
	}

	public static void metodoB() {
		System.out.println("Empezamos MetodoB");

		try {	
			//EXCEPTION int resul = 20 / 0; 
			System.out.println("Esta linea nunca se ejecuta, porque las anteriores en el try petan");

		} catch (ArithmeticException e) {
			System.out.println("ArithmeticException:" + e.getMessage());
			e.printStackTrace();

		} catch (Exception e) {
			System.out.println("Se ejecuta  cuando hay excepcion, Excepcion: " + e.getMessage());

		} finally {
			System.out.println("Este bloque se ejecuta siempre haya o no Excepcion");

		}
		System.out.println("Terminamos MetodoB");
	}
}
