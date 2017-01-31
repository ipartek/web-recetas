package com.ipartek.formacion.recetas.services;

import java.util.List;

import com.ipartek.formacion.recetas.ejercicios.herencia.Vehiculo;

public class VehiculoServiceObjectStream implements ServiceVehiculo {

	// TODO patron Singleton
	// TODO Cuidado hay que comprobar que el fichero existe, si no existe
	// crearlo
	// TODO PATH relativo al proyecto
	public static final String PATH = "C:\\desarrollo\\workspace\\web-recetas\\data\\vehiculo.txt";

	@Override
	public List<Vehiculo> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vehiculo getById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Vehiculo v) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean create(Vehiculo v) {
		// TODO Auto-generated method stub
		return false;
	}

}
