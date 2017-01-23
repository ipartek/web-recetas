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
			// lanza excepcion arimetica
			// int resul = 20 / 0;

			Object o = null;
			o.toString();
			System.out.println("Esta linea nunca se ejecuta");

		} catch (ArithmeticException e) {
			System.out.println("UPsss ArithmeticException " + e.getMessage());

		} catch (NullPointerException e) {
			System.out.println("UPsss NullPointerException " + e.getMessage());
			e.printStackTrace();

		} catch (Exception e) {
			System.out.println("UPsss Exception " + e.getMessage());

		} finally {
			System.out.println("Este bloque se ejecuta siempre, haya o no Exception");
		}

		System.out.println("Terminamos MetodoB");
	}

}
