package com.ipartek.formacion.recetas.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.recetas.model.DataBaseConnectionImpl;
import com.ipartek.formacion.recetas.model.Persistable;
import com.ipartek.formacion.recetas.pojo.Receta;

public class RecetaDAO implements Persistable<Receta> {

	private static RecetaDAO INSTANCE = null;
	private static DataBaseConnectionImpl db;
	private Connection conn;

	// buscamos los ultimos 100 recetas ordenados por 'id' en orden
	// descendiente
	private static String SQL_GET_ALL = "SELECT `id`, `nombre`, `tiempo`, `dificultad`, `comensales`, `descripcion` FROM `receta` ORDER BY `id` DESC LIMIT 100";
	private static String SQL_DELETE = "DELETE FROM `receta` WHERE `receta`.`id` = ?";
	private static String SQL_GET_BY_ID = "SELECT `id`, `nombre`, `tiempo`, `dificultad`, `comensales`, `descripcion` FROM `receta` WHERE `receta`.`id` = ?";
	private static String SQL_UPDATE = "UPDATE `receta` SET `nombre` = ?, `tiempo` = ?, `dificultad` = ?, `comensales` = ?, `descripcion` = ? WHERE `receta`.`id` = ?";
	private static String SQL_CREATE = "INSERT INTO `receta` (`nombre`, `tiempo`, `dificultad`, `comensales`, `descripcion`) VALUES ( ?, ?, ?, ?, ? )";

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
	public Receta getById(long id) {

		Receta r = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {

			conn = db.getConexion();
			pst = conn.prepareStatement(SQL_GET_BY_ID);
			pst.setLong(1, id);

			rs = pst.executeQuery();

			while (rs.next()) {
				r = mapear(rs);

			}

		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			db.desconectar();

		}
		return r;
	}

	@Override
	public boolean create(Receta r) {

		boolean resul = false;
		PreparedStatement pst = null;

		try {

			conn = db.getConexion();
			// ademas de crear un Receta, nos devuelve el id asignado por la
			// BBDD
			pst = conn.prepareStatement(SQL_CREATE, Statement.RETURN_GENERATED_KEYS);
			pst.setString(1, r.getTitulo());
			pst.setInt(2, r.getTiempo());
			pst.setString(3, r.getDificultad());
			pst.setInt(4, r.getComensales());
			pst.setString(5, r.getDescripcion());

			// insertamos Receta
			int affectedRows = pst.executeUpdate();

			if (affectedRows == 1) {
				// buscamos el ID generado
				ResultSet generatedKeys = pst.getGeneratedKeys();
				if (generatedKeys.next()) {
					r.setId(generatedKeys.getLong(1)); // 1 = posicion de
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
	public boolean update(Receta r) {

		boolean resul = false;
		PreparedStatement pst = null;

		try {

			conn = db.getConexion();
			pst = conn.prepareStatement(SQL_UPDATE);
			pst.setString(1, r.getTitulo());
			pst.setInt(2, r.getTiempo());
			pst.setString(3, r.getDificultad());
			pst.setInt(4, r.getComensales());
			pst.setString(5, r.getDescripcion());
			pst.setLong(6, r.getId());

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

	private Receta mapear(ResultSet rs) throws SQLException {
		Receta r = new Receta("");

		r.setId(rs.getLong("id"));
		r.setTitulo(rs.getString("nombre"));
		r.setTiempo(Integer.parseInt(rs.getString("tiempo")));
		r.setDificultad(rs.getString("dificultad"));
		r.setComensales(Integer.parseInt(rs.getString("comensales")));
		r.setDescripcion(rs.getString("descripcion"));
		return r;
	}

}
