package com.ipartek.formacion.recetas.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.recetas.ejercicios.herencia.Vehiculo;
import com.ipartek.formacion.recetas.model.DataBaseConnectionImpl;
import com.ipartek.formacion.recetas.model.Persistable;

public class VehiculoDAO implements Persistable<Vehiculo> {

	private static VehiculoDAO INSTANCE = null;
	private static DataBaseConnectionImpl db;
	private Connection conn;

	private VehiculoDAO() {
		db = DataBaseConnectionImpl.getInstance();
	}

	public static VehiculoDAO getInstance() {
		if (INSTANCE == null) {
			createInstance();
		}
		return INSTANCE;
	}

	private synchronized static void createInstance() {
		if (INSTANCE == null) {
			INSTANCE = new VehiculoDAO();
		}
	}

	@Override
	public List<Vehiculo> getAll() {
		ArrayList<Vehiculo> list = null;
		// buscamos los ultimos 100 vehículos ordenados por orden descendiente
		String sql = "SELECT `id`,`modelo`,`plazas`,`potencia` FROM `vehiculo` ORDER BY`id` DESC LIMIT 100;";
		PreparedStatement pst = null;
		ResultSet rs = null;
		Vehiculo v = null;

		try {
			list = new ArrayList<Vehiculo>();
			conn = db.getConexion();

			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery(); // para decir que es una consulta

			while (rs.next()) { // mientras haya un resultado

				v = new Vehiculo();

				v.setId(rs.getLong("id"));
				v.setModelo(rs.getString("modelo"));
				v.setPlazas(rs.getInt("plazas"));
				v.setPotencia(rs.getFloat("potencia"));
			}

		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			db.desconectar();

		}

		return list;
	}

	@Override
	public Vehiculo getId(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean create(Vehiculo objeto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Vehiculo objeto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(long id) {
		// TODO Auto-generated method stub
		return false;
	}

}
