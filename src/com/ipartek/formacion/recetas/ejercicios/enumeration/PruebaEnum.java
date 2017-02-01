package com.ipartek.formacion.recetas.ejercicios.enumeration;

import java.util.ArrayList;

public class PruebaEnum {

	public static void main(String[] args) {
		ArrayList<Vaso> vasos = new ArrayList<>();

		Vaso jarra = Vaso.JARRA;
		Vaso caña = Vaso.CAÑA;
		Vaso crianza = Vaso.CRIANZA;
		Vaso quinto = Vaso.QUINTO;

		vasos.add(jarra);
		vasos.add(caña);
		vasos.add(crianza);
		vasos.add(crianza);
		vasos.add(quinto);

		for (Vaso vaso : vasos) {
			System.out.println("" + vaso + " " + vaso.getCentimetrosCubicos());
		}

	}
}
