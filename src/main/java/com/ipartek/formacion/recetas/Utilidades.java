package com.ipartek.formacion.recetas;

/**
 * Clase {@code Utilidades} con metodos estaticos y comunues.<br>
 * Por ejemplo: generar numeros aleatorios, validaciones etc
 * 
 * @author ur00
 *
 */
public class Utilidades {

	/**
	 * Generar numero {@code int} aleatorio desde 0 hasta <b>maximoValor</b>
	 * 
	 * @param maximoValor
	 *            numero aletarorio maximos que puede generar, incluido este.
	 * @return numero entero aleatorio
	 */
	static public int getNumeroAleatorio(int maximoValor) {
		return (int) (Math.random() * maximoValor);
	}

	/**
	 * Ordenacion en burbuja para un array de enteros
	 * 
	 * @see https://www.youtube.com/watch?v=lyZQPjUT5B4
	 * @param aDesordenado
	 * @return
	 */
	static public int[] bubbleSort(int[] aDesordenado) {
		int[] aOrdenado = aDesordenado;
		boolean flag = true; // set flag to true to begin first pass
		int temp; // holding variable

		while (flag) {
			flag = false;
			for (int j = 0; j < aOrdenado.length - 1; j++) {
				if (aOrdenado[j] > aOrdenado[j + 1]) {
					temp = aOrdenado[j];
					aOrdenado[j] = aOrdenado[j + 1];
					aOrdenado[j + 1] = temp;
					flag = true;
				}
			}
		}

		return aOrdenado;
	}

	/**
	 * Suma muy rara que se inventa el jefe, no me digas para que
	 * 
	 * @param num1
	 *            entero a sumar
	 * @param num2
	 *            entero a sumar
	 * @return sumar de los dos parametros, pero: <br>
	 *         si cualquiera de los dos negativo return 0. <br>
	 *         Si la suma es superior a 100 return 0.
	 */
	static public int sumaTonta(int num1, int num2) {
		int resultado = -1;

		if (num1 < 0 || num2 < 0 || (num1 + num2 > 100)) {
			resultado = 0;
		} else {
			resultado = num1 + num2;
		}
		return resultado;
	}

}
