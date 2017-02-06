package com.ipartek.formacion.vehiculo.servicios;

import java.util.List;

import com.ipartek.formacion.model.dao.VehiculoDAO;
import com.ipartek.formacion.vehiculo.pojo.Vehiculo;

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
