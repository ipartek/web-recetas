package com.ipartek.formacion.recetas.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.recetas.model.DataBaseConnectionImpl;
import com.ipartek.formacion.recetas.model.Persistable;
import com.ipartek.formacion.recetas.pojo.Usuario;
import com.mysql.jdbc.Statement;

public class UsuarioDAO implements Persistable<Usuario> {

	private static UsuarioDAO INSTANCE = null;
	private static DataBaseConnectionImpl db;
	private Connection conn;

	private static final String SQL_GET_ALL = "SELECT `id`,`nombre`, `apellido1`, `apellido2`, `edad`, `email`, `dni`, `puesto`, `password`, `imagen`  FROM `usuario` ORDER BY `id` DESC LIMIT 500;";
	private static final String SQL_GET_BY_ID = "SELECT `id`,`nombre`,`apellido1`,`apellido2`,`edad`,`email`,`dni`,`puesto`,`password`,`imagen` FROM `usuario` WHERE `id` = ?;";
	private static final String SQL_GET_BY_EMAIL = "SELECT `id`,`nombre`,`apellido1`,`apellido2`,`edad`,`email`,`dni`,`puesto`,`password`,`imagen` FROM `usuario` WHERE `email` = ?;";
	private static final String SQL_COUNT = "SELECT COUNT(`id`) FROM `usuario`;";
	private static final String SQL_UPDATE = "UPDATE `usuario` SET `nombre` = ?, `email` = ?, `imagen` = ? WHERE `id` = ?;";
	private static final String SQL_CREATE = "INSERT INTO `usuario` (`nombre`, `apellido1`, `apellido2`, `edad`, `email`, `dni`, `puesto`, `password`, `imagen`) VALUES ( ? , ? , ? , ? , ? , ? , ? , ? , ? );";
	private static final String SQL_FILTER_BY_STR = "SELECT `id`,`nombre`,`apellido1`,`apellido2`,`edad`,`email`,`dni`,`puesto`,`password`,`imagen` FROM `usuario` WHERE `nombre` LIKE '%?%' OR `apellido1` LIKE '%?%' OR `apellido2` LIKE '%?%' ORDER BY `id` DESC LIMIT 500;";
	private static final String SQL_DELETE = "DELETE FROM `usuario` WHERE `id` = ?";

	private UsuarioDAO() {
		db = DataBaseConnectionImpl.getInstance();
	}

	public static UsuarioDAO getInstance() {
		if (INSTANCE == null) {
			createInstance();
		}
		return INSTANCE;
	}

	private synchronized static void createInstance() {
		if (INSTANCE == null) {
			INSTANCE = new UsuarioDAO();
		}
	}

	@Override
	public List<Usuario> getAll() {
		ArrayList<Usuario> list = null;

		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			list = new ArrayList<Usuario>();
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
	public Usuario getById(long id) {
		Usuario u = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			conn = db.getConexion();
			pst = conn.prepareStatement(SQL_GET_BY_ID);
			pst.setLong(1, id);

			rs = pst.executeQuery();
			while (rs.next()) {
				u = mapear(rs);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.desconectar();
		}
		return u;
	}

	@Override
	public boolean create(Usuario u) {
		boolean resul = false;
		PreparedStatement pst = null;
		try {
			conn = db.getConexion();
			pst = conn.prepareStatement(SQL_CREATE, Statement.RETURN_GENERATED_KEYS);
			pst.setString(1, u.getNombre());
			pst.setString(2, u.getApellido1());
			pst.setString(3, u.getApellido2());
			pst.setInt(4, u.getEdad());
			pst.setString(5, u.getEmail());
			pst.setString(6, u.getDni());
			pst.setString(7, u.getPuesto());
			pst.setString(8, u.getPassword());
			pst.setString(9, u.getImagen());

			// insertamos usuario
			int affectedRows = pst.executeUpdate();

			if (affectedRows == 1) {
				// buscamos el ID generado
				ResultSet generatedKeys = pst.getGeneratedKeys();
				if (generatedKeys.next()) {
					u.setId(generatedKeys.getLong(1));
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
	public boolean update(Usuario u) {
		boolean resul = false;
		PreparedStatement pst = null;
		try {
			conn = db.getConexion();
			pst = conn.prepareStatement(SQL_UPDATE);
			pst.setString(1, u.getNombre());
			pst.setString(2, u.getEmail());
			pst.setString(3, u.getImagen());
			pst.setFloat(4, u.getId());

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

	public Usuario getByEmail(String email) {

		Usuario u = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			conn = db.getConexion();
			pst = conn.prepareStatement(SQL_GET_BY_EMAIL);
			pst.setString(1, email);

			rs = pst.executeQuery();
			while (rs.next()) {
				u = mapear(rs);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.desconectar();
		}
		return u;
	}

	public Usuario existe(String email, String password) {
		Usuario resul = null;
		Usuario u = new Usuario();
		u = getByEmail(email);
		if (u.getPassword().equals(password)) {
			resul = u;
		}
		return resul;
	}

	/**
	 * Cuenta los usuario totales de la tabla
	 * 
	 * @return <code>int </code>numero entero de registros
	 */
	public int count() {
		int resul = -1;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			conn = db.getConexion();
			pst = conn.prepareStatement(SQL_COUNT);
			rs = pst.executeQuery();
			while (rs.next()) {
				resul = rs.getInt(1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.desconectar();
		}
		return resul;
	}

	private Usuario mapear(ResultSet rs) throws SQLException {
		Usuario u = new Usuario();
		u.setId(rs.getLong("id"));
		u.setNombre(rs.getString("nombre"));
		u.setApellido1(rs.getString("apellido1"));
		u.setApellido2(rs.getString("apellido2"));
		u.setEdad(rs.getInt("edad"));
		u.setEmail(rs.getString("email"));
		u.setDni(rs.getString("dni"));
		u.setPuesto(rs.getString("puesto"));
		u.setPassword(rs.getString("password"));
		u.setImagen(rs.getString("imagen"));

		return u;
	}

}
