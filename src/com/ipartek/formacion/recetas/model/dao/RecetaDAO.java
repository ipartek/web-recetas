package com.ipartek.formacion.recetas.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.model.DataBaseConnectionImpl;
import com.ipartek.formacion.model.Persistable;
import com.ipartek.formacion.recetas.pojo.Receta;
import com.mysql.jdbc.Statement;

public class RecetaDAO implements Persistable<Receta> {

	private static RecetaDAO INSTANCE = null;
	private static DataBaseConnectionImpl db;
	private Connection conn;
	private static String SQL_GET_ALL = "SELECT `id`,`nombre`,`tiempo` FROM `receta` ORDER BY `id` DESC LIMIT 100";
	private static String SQL_GET_BY_ID = "SELECT `id`,`nombre`,`tiempo` FROM `receta` WHERE `id` = ?";
	private static String SQL_DELETE = "DELETE FROM `receta` WHERE `id` = ?";
	private static String SQL_UPDATE = "UPDATE `receta` SET `nombre` = ? , `tiempo` = ? WHERE `id` = ?;";
	private static String SQL_CREATE = "INSERT INTO `receta` (`nombre`, `tiempo`) VALUES ( ?,? );";

	// Usamos patron singleton
	private RecetaDAO() {
		db = DataBaseConnectionImpl.getInstance();
	}

	public static RecetaDAO getInstance() {
		if (INSTANCE == null) {
			createInstance();
		}
		return INSTANCE;
	}

	private synchronized static void createInstance() {
		if (INSTANCE == null) {
			INSTANCE = new RecetaDAO();
		}
	}

	@Override
	public List<Receta> getAll() {

		ArrayList<Receta> list = null;

		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			list = new ArrayList<Receta>();
			conn = db.getConexion();
			pst = conn.prepareStatement(SQL_GET_ALL);
			rs = pst.executeQuery();
			while (rs.next()) {
				list.add(mapper(rs));
			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			db.desconectar();
		}
		return list;
	}

	@Override
	public Receta getByID(long id) {
		Receta v = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			conn = db.getConexion();
			pst = conn.prepareStatement(SQL_GET_BY_ID);
			pst.setLong(1, id);

			rs = pst.executeQuery();
			while (rs.next()) {
				v = mapper(rs);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.desconectar();
		}
		return v;
	}

	@Override
	public boolean create(Receta v) {
		boolean resul = false;
		PreparedStatement pst = null;
		try {
			conn = db.getConexion();
			pst = conn.prepareStatement(SQL_CREATE, Statement.RETURN_GENERATED_KEYS);
			pst.setString(1, v.getTitulo());
			pst.setInt(2, v.getTiempo());

			// insertamos vehiculo
			int affectedRows = pst.executeUpdate();

			if (affectedRows == 1) {
				// buscamos el ID generado
				ResultSet generatedKeys = pst.getGeneratedKeys();
				if (generatedKeys.next()) {
					v.setId(generatedKeys.getLong(1));
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
	public boolean update(Receta v) {
		boolean resul = false;
		PreparedStatement pst = null;
		try {
			conn = db.getConexion();
			pst = conn.prepareStatement(SQL_UPDATE);
			pst.setString(1, v.getTitulo());
			pst.setLong(3, v.getId());
			pst.setInt(2, v.getTiempo());

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

			pst.close();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.desconectar();
		}
		return resul;
	}

	private Receta mapper(ResultSet rs) throws SQLException {
		Receta v = new Receta();
		v.setId(rs.getLong("id"));
		v.setTitulo(rs.getString("nombre"));
		v.setTiempo(rs.getInt("tiempo"));
		return v;
	}

}
