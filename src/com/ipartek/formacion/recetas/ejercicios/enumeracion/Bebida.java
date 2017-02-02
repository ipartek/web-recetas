package com.ipartek.formacion.recetas.ejercicios.enumeracion;

public class Bebida {

	enum TipoBebida {
		CERVEZA, VINO
	} // Tipos enumerados sencillos. Solo tenemos estas marcas

	private Vaso vaso;
	private TipoBebida tipo;

	Bebida(TipoBebida tipo, Vaso vaso) {
		this.tipo = tipo;
		this.vaso = vaso;
	}

	public void servir() {
		System.out
				.println("Sirviendo " + vaso.setDescripcion() + " " + vaso.getCentimetrosCubicos() + "cc. de " + tipo);
	}
}
