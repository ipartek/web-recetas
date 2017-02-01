package com.ipartek.formacion.recetas.ejercicios.enumeracion;

import java.util.ArrayList;

/*
 * Clase p�blica que prueba todo esto
 */
public class PruebaEnum {
	public static void main(String[] args) {

		ArrayList<Vaso> bebidas = new ArrayList<>();

		Vaso jarra = Vaso.JARRA;
		Vaso ca�a = Vaso.CA�A;
		Vaso crianza = Vaso.CRIANZA;
		Vaso quinto = Vaso.QUINTO;

		bebidas.add(jarra);
		bebidas.add(ca�a);
		bebidas.add(crianza);
		bebidas.add(crianza);
		bebidas.add(quinto);

		for (Vaso vaso : bebidas) {
			System.out.println(" " + vaso + " " + vaso.getCentimetrosCubicos());
		}
	}
}
