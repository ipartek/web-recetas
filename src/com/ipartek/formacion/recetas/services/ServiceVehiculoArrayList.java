package com.ipartek.formacion.recetas.services;

import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.recetas.ejercicios.herencia.pojo.Vehiculo;

public class ServiceVehiculoArrayList implements ServiceVehiculo {

	//Declaracion
	private static ServiceVehiculoArrayList INSTANCE;
	private static long indice = 500;
	private ArrayList<Vehiculo> vehiculos = null;
	private ServiceVehiculoArrayList() {
		vehiculos = new ArrayList<>();
		vehiculos.add(new Vehiculo("Seat Panda", 4));
		vehiculos.add(new Vehiculo("Lamborghini", 2));
		vehiculos.add(new Vehiculo("Ford K2", 1));
		vehiculos.add(new Vehiculo("Citroen Xsara", 12));
		vehiculos.add(new Vehiculo("Ferrari", 500));
		vehiculos.add(new Vehiculo("Tesla", 23));
	}
	
	//Singleton
	private synchronized static void createInstance() {
		if (INSTANCE == null) {
			INSTANCE = new ServiceVehiculoArrayList();
		}
	}

	public static ServiceVehiculoArrayList getInstance() {
		if (INSTANCE == null)
			createInstance();
		return INSTANCE;
	}

	//ServiceVehiculo
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
	public boolean update(Vehiculo vModificar) {
		boolean resul = false;
		for (Vehiculo v : vehiculos) {
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
	public boolean create(Vehiculo v) {
		v.setId(++indice);
		return vehiculos.add(v);
	}
}