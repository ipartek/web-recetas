package com.ipartek.formacion.recetas.ejercicios.enumeracion;

public class MostrarVasos {

	private static Vaso vaso;
	
	public static void main(String[] args) {
		
		vaso = Vaso.CAÑA;
		MostrarVasos.servir();
		vaso = Vaso.CHUPITO;
		MostrarVasos.servir();
		vaso = Vaso.QUINTO;
		MostrarVasos.servir();
		vaso = Vaso.JARRA;
		MostrarVasos.servir();

	}
	
	 public static void servir() {
	        System.out.println("Sirviendo " + vaso.getDescripcion() + "cc.");
	 }

}
