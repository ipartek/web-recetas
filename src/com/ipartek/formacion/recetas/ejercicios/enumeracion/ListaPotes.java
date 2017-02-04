package com.ipartek.formacion.recetas.ejercicios.enumeracion;

import java.util.ArrayList;

import com.ipartek.formacion.recetas.ejercicios.enumeracion.Bebida.TipoBebida;

public class ListaPotes {

	public static void main(String[] args) {

		ArrayList<Bebida> bebidas = new ArrayList<Bebida>();

		bebidas.add(new Bebida(TipoBebida.VINO, Vaso.QUINTO));
		bebidas.add(new Bebida(TipoBebida.VINO, Vaso.JARRA));
		bebidas.add(new Bebida(TipoBebida.CERVEZA, Vaso.JARRA));
		bebidas.add(new Bebida(TipoBebida.CERVEZA, Vaso.CANA));

		for (Bebida bebida : bebidas) {
			bebida.servir();

		}

	}

}
