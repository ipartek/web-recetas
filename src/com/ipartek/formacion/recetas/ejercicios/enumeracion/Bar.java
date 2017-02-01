package com.ipartek.formacion.recetas.ejercicios.enumeracion;

public class Bar {
	
	 private static Vaso vaso;
	 
	 public static void main(String[] args) {
		
		 vaso = Vaso.CAÑA;
		
		 Bar.servir();
	 }
	 
	 public static void servir() {
		 System.out.println("Sirviendo " + vaso.getDescripcion());
	 }

	 
}
