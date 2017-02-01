package com.ipartek.formacion.recetas.ejercicios.enumeracion;

import java.util.ArrayList;

/*
 * Clase pública que prueba todo esto
 */
public class PruebaEnum {
	public static void main(String[] args) {

		ArrayList<Vaso> bebidas = new ArrayList<>();

		Vaso jarra = Vaso.JARRA;
		Vaso caña = Vaso.CAÑA;
		Vaso crianza = Vaso.CRIANZA;
		Vaso quinto = Vaso.QUINTO;

		bebidas.add(jarra);
		bebidas.add(caña);
		bebidas.add(crianza);
		bebidas.add(crianza);
		bebidas.add(quinto);

		for (Vaso vaso : bebidas) {
			System.out.println(" " + vaso + " " + vaso.getCentimetrosCubicos());
		}
	}
}
