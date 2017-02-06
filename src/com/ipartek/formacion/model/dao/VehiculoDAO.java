package com.ipartek.formacion.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.model.DataBaseConnectionImpl;
import com.ipartek.formacion.model.Persistable;
import com.ipartek.formacion.vehiculo.pojo.Vehiculo;
import com.ipartek.formacion.vehiculo.pojo.VehiculoException;

public class VehiculoDAO implements Persistable<Vehiculo> {

	private static VehiculoDAO INSTANCE = null;
	private static DataBaseConnectionImpl db;
	private Connection conn;

	// Usamos patron singleton
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
		String sql = "SELECT `id`, `modelo`, `plazas`, `potencia` FROM `vehiculo`  ORDER BY `id` DESC LIMIT 100";
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			list = new ArrayList<Vehiculo>();
			conn = db.getConexion();
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				list.add(mapper(rs));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// cerrar conexion
			db.desconectar();
		}
		return list;
	}

	@Override
	public Vehiculo getByID(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean create(Vehiculo obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Vehiculo obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(long id) {
		// TODO Auto-generated method stub
		return false;
	}

	private Vehiculo mapper(ResultSet rs) throws SQLException, VehiculoException {
		Vehiculo v = new Vehiculo();
		v.setId(rs.getLong("id"));
		v.setModelo(rs.getString("modelo"));
		v.setPlazas(rs.getInt("plazas"));
		v.setPotencia(rs.getFloat("potencia"));
		return v;
	}

}
