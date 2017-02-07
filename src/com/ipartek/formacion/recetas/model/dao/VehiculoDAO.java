package com.ipartek.formacion.recetas.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.recetas.ejercicios.herencia.Vehiculo;
import com.ipartek.formacion.recetas.ejercicios.herencia.VehiculoException;
import com.ipartek.formacion.recetas.model.DataBaseConnectionImpl;
import com.ipartek.formacion.recetas.model.Persistable;

public class VehiculoDAO implements Persistable<Vehiculo> {

	private static VehiculoDAO INSTANCE = null;
	private static DataBaseConnectionImpl db;
	private Connection conn;

	// buscamos los ultimos 100 vehiculos ordenados por 'id' en orden
	// descendiente
	private static String SQL_GET_ALL = "SELECT `id`, `modelo`, `plazas`, `potencia` FROM `vehiculo` ORDER BY `id` DESC LIMIT 100";
	private static String SQL_DELETE = "DELETE FROM `vehiculo` WHERE `vehiculo`.`id` = ?";
	private static String SQL_GET_BY_ID = "SELECT `id`, `modelo`, `plazas`, `potencia` FROM `vehiculo` WHERE `vehiculo`.`id` = ?";
	private static String SQL_UPDATE = "UPDATE `vehiculo` SET `modelo` = ?, `plazas` = ?, `potencia` = ? WHERE `vehiculo`.`id` = ?";
	private static String SQL_CREATE = "INSERT INTO `vehiculo` (`modelo`, `plazas`, `potencia`) VALUES ( ?, ?, ? )";
	// private static String SQL_GET_ID = "SELECT MAX (`id`) FROM `vehiculo`";
	// // Para conseguir el max id que hay en la BBDD. De esta manera al crear
	// un Vehiculo nos devolveria el id la cual es la MAX.

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

		PreparedStatement pst = null;
		ResultSet rs = null;

		try {

			list = new ArrayList<Vehiculo>();
			conn = db.getConexion();
			pst = conn.prepareStatement(SQL_GET_ALL);
			rs = pst.executeQuery();

			while (rs.next()) {

				list.add(mapear(rs));

			}

		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			db.desconectar();

		}

		return list;
	}

	@Override
	public Vehiculo getById(long id) {

		Vehiculo v = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {

			conn = db.getConexion();
			pst = conn.prepareStatement(SQL_GET_BY_ID);
			pst.setLong(1, id);

			rs = pst.executeQuery();

			while (rs.next()) {
				v = mapear(rs);

			}

		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			db.desconectar();

		}
		return v;
	}

	@Override
	public boolean create(Vehiculo v) {

		boolean resul = false;
		PreparedStatement pst = null;

		try {

			conn = db.getConexion();
			// ademas de crear un Vehiculo, nos debuelve el id asignado por la
			// BBDD
			pst = conn.prepareStatement(SQL_CREATE, Statement.RETURN_GENERATED_KEYS);
			pst.setString(1, v.getModelo());
			pst.setInt(2, v.getPlazas());
			pst.setFloat(3, v.getPotencia());

			// insertamos vehiculo
			int affectedRows = pst.executeUpdate();

			if (affectedRows == 1) {
				// buscamos el ID generado
				ResultSet generatedKeys = pst.getGeneratedKeys();
				if (generatedKeys.next()) {
					v.setId(generatedKeys.getLong(1)); // 1 = posicion de
														// columna
					resul = true;
				}
			}

		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			db.desconectar();

		}

		return resul;

	}

	@Override
	public boolean update(Vehiculo v) {

		boolean resul = false;
		PreparedStatement pst = null;

		try {

			conn = db.getConexion();
			pst = conn.prepareStatement(SQL_UPDATE);
			pst.setString(1, v.getModelo());
			pst.setInt(2, v.getPlazas());
			pst.setFloat(3, v.getPotencia());
			pst.setLong(4, v.getId());

			if (pst.executeUpdate() == 1) {
				resul = true;
			}

		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			db.desconectar();

		}

		return resul;
	}

	@Override
	public boolean delete(long id) {

		boolean resul = false;
		PreparedStatement pst = null;

		try {

			conn = db.getConexion();
			pst = conn.prepareStatement(SQL_DELETE);
			pst.setLong(1, id);

			if (pst.executeUpdate() == 1) {
				resul = true;
			}

		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			db.desconectar();

		}

		return resul;
	}

	private Vehiculo mapear(ResultSet rs) throws SQLException, VehiculoException {
		Vehiculo v = new Vehiculo();

		v.setId(rs.getLong("id"));
		v.setModelo(rs.getString("modelo"));
		v.setPlazas(rs.getInt("plazas"));
		// TODO dimensiones
		// v.setDimensiones(rs.getFloat("dimensiones"));
		v.setPotencia(rs.getFloat("potencia"));

		return v;
	}

}
