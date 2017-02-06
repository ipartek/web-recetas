package com.ipartek.formacion.recetas.services;

import java.util.List;

import com.ipartek.formacion.recetas.ejercicios.herencia.pojo.Vehiculo;
import com.ipartek.formacion.recetas.model.dao.VehiculoDAO;

public class ServiceVehiculoMySQL implements ServiceVehiculo {

	private static ServiceVehiculoMySQL INSTANCE;
	private static VehiculoDAO daoVehiculo;
	
	private ServiceVehiculoMySQL() {
		daoVehiculo = VehiculoDAO.getInstance();
	}

	public static ServiceVehiculoMySQL getInstance() {
		if (INSTANCE == null) {
			createInstance();
		}
		return INSTANCE;
	}

	private synchronized static void createInstance() {
		if (INSTANCE == null) {
			INSTANCE = new ServiceVehiculoMySQL();
		}
	}
	
	@Override
	public List<Vehiculo> getAll() {
		return daoVehiculo.getAll();
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
