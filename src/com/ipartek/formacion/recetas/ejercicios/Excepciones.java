package com.ipartek.formacion.recetas.ejercicios;

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

			int resul = 20 / 0;

			Object o = null;
			o.toString();

			System.out.println("Esta linea nunca se ejecuta, porque las anteriores en el try petan");

		} catch (ArithmeticException e) {
			System.out.println("Ups ArithmeticException :" + e.getMessage());
			e.printStackTrace();

		} catch (NullPointerException e) {
			System.out.println("Ups NullPointerException :" + e.getMessage());
			e.printStackTrace();

		} catch (Exception e) {
			System.out.println("Se ejecuta  cuando hay excepcion, Excepcion: " + e.getMessage());

		} finally {
			System.out.println("Este bloque se ejecuta siempre haya o no Excepcion");

		}
		System.out.println("Terminamos MetodoB");
	}

}
