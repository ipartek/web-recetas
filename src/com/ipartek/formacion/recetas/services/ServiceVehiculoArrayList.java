package com.ipartek.formacion.recetas.services;

import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.recetas.ejercicios.herencia.Usuario;

public class ServiceVehiculoArrayList implements ServiceVehiculo {

	private static ServiceVehiculoArrayList INSTANCE;
	private static ArrayList<Usuario> vehiculos = null;
	// simular el indice en la BaseDatos
	private static long indice = 500;

	// Private constructor suppresses
	private ServiceVehiculoArrayList() {

		vehiculos = new ArrayList<>();
		vehiculos.add(new Usuario("Seat Panda", 2));
		vehiculos.add(new Usuario("Lamborgini", 4));
		vehiculos.add(new Usuario("Ford K2", 1));
		vehiculos.add(new Usuario("Citoren Shara", 12));
		vehiculos.add(new Usuario("Ferrari", 500));
		vehiculos.add(new Usuario("Tesla", 23));

	}

	// creador sincronizado para protegerse de posibles problemas multi-hilo
	// otra prueba para evitar instanciación múltiple
	private synchronized static void createInstance() {
		if (INSTANCE == null) {
			INSTANCE = new ServiceVehiculoArrayList();
		}
	}

	public static ServiceVehiculoArrayList getInstance() {
		if (INSTANCE == null) {
			createInstance();
		}
		return INSTANCE;
	}

	@Override
	public List<Usuario> getAll() {
		return this.vehiculos;
	}

	@Override
	public Usuario getById(long id) {
		Usuario resul = null;
		for (Usuario v : vehiculos) {
			if (id == v.getId()) {
				resul = v;
				break;
			}
		}
		return resul;
	}

	@Override
	public boolean delete(long id) {
		boolean resul = false;
		for (Usuario v : vehiculos) {
			if (id == v.getId()) {
				resul = true;
				vehiculos.remove(v);
				break;
			}
		}
		return resul;
	}

	@Override
	public boolean update(Usuario vModificar) {
		boolean resul = false;
		for (Usuario v : vehiculos) {
			if (vModificar.getId() == v.getId()) {
				resul = true;
				int pos = vehiculos.indexOf(v);
				vehiculos.remove(v);
				vehiculos.add(pos, vModificar);
				break;
			}
		}
		return resul;
	}

	@Override
	public boolean create(Usuario v) {
		v.setId(++indice);
		return vehiculos.add(v);
	}

}
