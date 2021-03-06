package com.ipartek.formacion.recetas.services;

import java.util.List;

import com.ipartek.formacion.recetas.ejercicios.herencia.Vehiculo;
import com.ipartek.formacion.recetas.model.dao.VehiculoDAO;

public class ServiceVehiculoMysql implements ServiceVehiculo {

	private static ServiceVehiculoMysql INSTANCE;
	private static VehiculoDAO daoVehiculo;

	private ServiceVehiculoMysql() {
		daoVehiculo = VehiculoDAO.getInstance();
	}

	private synchronized static void createInstance() {
		if (INSTANCE == null) {
			INSTANCE = new ServiceVehiculoMysql();
		}
	}

	public static ServiceVehiculoMysql getInstance() {
		if (INSTANCE == null) {
			createInstance();
		}
		return INSTANCE;
	}

	@Override
	public List<Vehiculo> getAll() {
		return daoVehiculo.getAll();
	}

	@Override
	public Vehiculo getById(long id) {
		return daoVehiculo.getById(id);
	}

	@Override
	public boolean delete(long id) {
		return daoVehiculo.delete(id);
	}

	@Override
	public boolean update(Vehiculo v) {
		return daoVehiculo.update(v);
	}

	@Override
	public boolean create(Vehiculo v) {
		return daoVehiculo.create(v);
	}

}
