package com.ipartek.formacion.recetas.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.recetas.model.DataBaseConnectionImpl;
import com.ipartek.formacion.recetas.model.Persistable;
import com.ipartek.formacion.recetas.pojo.Receta;
import com.mysql.jdbc.Statement;

public class RecetaDAO implements Persistable<Receta> {
	private static RecetaDAO INSTANCE = null;
	private static DataBaseConnectionImpl db;
	private Connection conn;

	private static String sql = "SELECT `id`,`nombre`,`imagen`,`tiempo`,`comensales`,`dificultad`,`descripcion` FROM `receta` ORDER BY `id` DESC LIMIT 100 ";
	private static String SQL_DELETE = "DELETE FROM `receta` WHERE `id` = ?";
	private static String SQL_GET_BY_ID = "SELECT `id`,`nombre`,`imagen`,`tiempo`,`comensales`,`dificultad`,`descripcion` FROM `receta` WHERE `id` = ? ";
	private static String SQL_UPDATE = "UPDATE `receta` SET `nombre` = ? , `imagen`= ? , `tiempo`= ? , `comensales`= ?, `dificultad`= ?, `descripcion`= ? WHERE `id` = ? ";
	private static String SQL_CREATE = "INSERT INTO `receta` (`nombre`,`imagen`,`tiempo`,`comensales`,`dificultad`,`descripcion`) VALUES (?,?,?,?,?,?)";

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
			pst = conn.prepareStatement(sql);
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
			try {
				rs.close();
				pst.close();

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {

				db.desconectar();
			}
		}
		return r;
	}

	// TODO AGREGAR RECETAEXCEPTION
	private Receta mapear(ResultSet rs) throws SQLException {
		Receta r = new Receta();
		r.setId(rs.getInt("id"));
		r.setTitulo(rs.getString("nombre"));
		r.setImagen(rs.getString("imagen"));
		r.setTiempo(rs.getInt("tiempo"));
		r.setComensales(rs.getInt("comensales"));
		r.setDificultad(rs.getString("dificultad"));
		r.setDescripcion(rs.getString("descripcion"));

		return r;

	}

	@Override
	public boolean create(Receta r) {
		boolean resul = false;
		PreparedStatement pst = null;

		try {
			conn = db.getConexion();
			// RETURN_GENERATED_KEYS devuelve la key ( en este caso la id)
			// generada.
			pst = conn.prepareStatement(SQL_CREATE, Statement.RETURN_GENERATED_KEYS);
			pst.setString(1, r.getTitulo());
			pst.setString(2, r.getImagen());
			pst.setInt(3, r.getTiempo());
			pst.setInt(4, r.getComensales());
			pst.setString(5, r.getDificultad());
			pst.setString(6, r.getDescripcion());

			// Insertamos vehiculo
			int affectedRows = pst.executeUpdate();

			// Buscamos Id generado
			if (affectedRows == 1) {
				ResultSet generatedKeys = pst.getGeneratedKeys();
				if (generatedKeys.next()) {
					r.setId(generatedKeys.getInt(1));
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
			pst.setString(2, r.getImagen());
			pst.setInt(3, r.getTiempo());
			pst.setInt(4, r.getComensales());
			pst.setString(5, r.getDificultad());
			pst.setString(6, r.getDescripcion());

			pst.setInt(7, r.getId());

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

}
