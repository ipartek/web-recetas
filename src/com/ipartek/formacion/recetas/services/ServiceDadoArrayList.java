package com.ipartek.formacion.recetas.services;

import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.recetas.pojo.DadoAlumno;

public class ServiceDadoArrayList implements ServiceDado {

	public static ServiceDadoArrayList INSTANCE;

	private ArrayList<DadoAlumno> alumnos = null;

	// simular el indice en la BaseDatos
	// private static long indice = 500;

	// Private constructor suppresses
	private ServiceDadoArrayList() {

		alumnos = new ArrayList<>();
		alumnos.add(new DadoAlumno("Aaron", 1));
		alumnos.add(new DadoAlumno("Eneko", 2));
		alumnos.add(new DadoAlumno("Itsaso", 3));
		alumnos.add(new DadoAlumno("Ivan", 4));
		alumnos.add(new DadoAlumno("Guillermo", 5));
		alumnos.add(new DadoAlumno("Lozoya", 6));
		alumnos.add(new DadoAlumno("Josu", 7));
		alumnos.add(new DadoAlumno("Ignacio", 8));
		alumnos.add(new DadoAlumno("Gomez", 9));
		alumnos.add(new DadoAlumno("Nerea", 10));
		alumnos.add(new DadoAlumno("Nagore", 11));
		alumnos.add(new DadoAlumno("Garbiñe", 12));
		alumnos.add(new DadoAlumno("Egoitz", 13));
		alumnos.add(new DadoAlumno("Pavel", 14));
		alumnos.add(new DadoAlumno("Pérez", 15));

	}

	// creador sincronizado para protegerse de posibles problemas multi-hilo
	// otra prueba para evitar instanciación múltiple
	private synchronized static void createInstance() {
		if (INSTANCE == null) {
			INSTANCE = new ServiceDadoArrayList();
		}
	}

	public static ServiceDadoArrayList getInstance() {
		if (INSTANCE == null)
			createInstance();
		return INSTANCE;
	}

	@Override
	public List<DadoAlumno> getAll() {
		return this.alumnos;
	}

	@Override
	public DadoAlumno getById(long id) {
		DadoAlumno resul = null;
		for (DadoAlumno d : alumnos) {
			if (id == d.getId()) {
				resul = d;
				break;
			}
		}
		return resul;

	}

	public long getNumeroAleatorio(int maxValor) {
		return (long) (Math.random() * maxValor);
	}

}
