package com.ipartek.formacion.services;

import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.vehiculo.pojo.Vehiculo;

public class ServiceReceta {
	private static ServiceReceta INSTANCE = null;
	private static ArrayList<String> recetas = null;
	// Simular indice
	private static long indice = 500;

	// Private constructor suppresses
	private ServiceReceta() {

		recetas = new ArrayList<>();

	}

	// creador sincronizado para protegerse de posibles problemas multi-hilo
	// otra prueba para evitar instanciación múltiple
	private synchronized static void createInstance() {
		if (INSTANCE == null) {
			INSTANCE = new ServiceReceta();
		}
	}

	public static ServiceReceta getInstance() {
		if (INSTANCE == null) {
			createInstance();
		}
		return INSTANCE;
	}

	@Override
	public List<Vehiculo> getAll() {

		return this.vehiculos;

	}

	@Override
	public Vehiculo getById(long id) {
		Vehiculo resul = null;
		for (Vehiculo v : vehiculos) {
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
		for (Vehiculo v : vehiculos) {
			if (id == v.getId()) {
				resul = true;
				vehiculos.remove(v);
				break;
			}
		}
		return resul;
	}

	@Override
	public boolean update(Vehiculo vMod) {

		boolean resul = false;
		for (Vehiculo v : vehiculos) {
			if (vMod.getId() == v.getId()) {
				resul = true;
				int pos = vehiculos.indexOf(v);
				vehiculos.remove(v);
				vehiculos.add(pos, vMod);
				break;
			}
		}
		return resul;
	}

	@Override
	public boolean create(Vehiculo v) {
		v.setId(++indice);

		return vehiculos.add(v);
	}

}
