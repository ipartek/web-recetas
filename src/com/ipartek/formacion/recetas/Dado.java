package com.ipartek.formacion.recetas;

public class Dado {

	//Declaracion
	final static int NUM_MAX_ALUMNOS = 15;
	static String alumnoAfortunado;
	static String[] aAlumnos = { "Aaron", "Eneko", "Itsaso", "Ivan", "Guillermo", "Lozoya", "Josu", "Ignacio", "Gomez",
			"Nerea", "Nagore", "Garbieñe", "Egoitz", "Pavel", "Pérez" };
	
	public static void listar() {

		String alumno = "";
		for (int i = 0; i < aAlumnos.length; i++) {
			alumno = aAlumnos[i];
			System.out.println(i + " - " + alumno);
		}
		//for (String alumno : aAlumnos) {
		//	System.out.println(alumno);
		//}
	}

	public static void main(String[] args) {

		//Random
		int numeroAleatorio = Utilidades.getNumeroAleatorio((aAlumnos.length - 1));
	
		System.out.println("El/a afortunad@ es: " + aAlumnos[numeroAleatorio]);
		System.out.println("-------- listado ----------------");
		listar();

	}

}
