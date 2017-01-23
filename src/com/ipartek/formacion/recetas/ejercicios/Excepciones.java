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
			// Lanza excepcion aritmetica
			int resul = 20 / 0;
			Object o = null;
			o.toString();
			System.out.println("Esta linea nunca se ejecuta");
		} catch (ArithmeticException e) {
			System.out.println("Upsss ArithmeticException " + e.getMessage());
		} catch (NullPointerException e) {
			System.out.println("Upsss NullPointerException " + e.getMessage());
			e.printStackTrace();// pinta la traza de la excepcion.
		} catch (Exception e) {
			System.out.println("Upsss hemos tenido una Excepción " + e.getMessage());
		} finally { // es opcional. se usa para ejecutar algo sin importar que
					// haya o no excepcion
			System.out.println("Este bloque se ejecuta siempre, haya o no Excepciones.");
		}
		System.out.println("Terminamos MetodoB");
	}

}
