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
import com.ipartek.formacion.recetas.pojo.VehiculoException;
import com.mysql.jdbc.Statement;

public class RecetaDAO implements Persistable<Receta> {

	private static RecetaDAO INSTANCE = null;
	private static DataBaseConnectionImpl db;
	private Connection conn;

	private static String SQL_DELETE = "DELETE FROM `receta` WHERE `receta`.`id` = ?";
	private static String SQL_GET_ALL = "SELECT `id`,`titulo` FROM `receta` ORDER BY `id` DESC LIMIT 100";
	private static String SQL_GET_BY_ID = "SELECT `id`,`titulo` FROM `receta` WHERE `id`=? ";
	private static String SQL_UPDATE = "UPDATE `receta` SET `titulo` = ? WHERE `id` = ?;";
	private static String SQL_CREATE = "INSERT INTO `receta` (`titulo`) VALUES ( ? );";

	// CONSTRUCTOR PRIVADO SINGLETON
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

	// METODOS

	@Override
	public List<Receta> getAll() {
		ArrayList<Receta> list = null;

		PreparedStatement pst = null;
		ResultSet rs = null;
		Receta v = null;

		try {
			list = new ArrayList<Receta>();
			conn = db.getConexion();
			pst = conn.prepareStatement(SQL_GET_ALL);

			rs = pst.executeQuery();
			// mientras haya un resultado iteramos sobre el
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
			// Statement.return_generate-keys es para recoger el ultimo id
			pst = conn.prepareStatement(SQL_CREATE, Statement.RETURN_GENERATED_KEYS);

			pst.setString(1, r.getTitulo());

			// insertamos vehiculo y buscamos el ID generado
			int affectedRows = pst.executeUpdate();
			if (affectedRows == 1) {
				ResultSet generatedKeys = pst.getGeneratedKeys();
				if (generatedKeys.next()) {
					r.setId(generatedKeys.getLong(1));
					resul = true;
				}
			}

		} catch (

		Exception e) {
			e.printStackTrace();
		} finally

		{
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
			// le paso a la sentencia SQL el id como parametro
			pst.setString(1, r.getTitulo());

			pst.setLong(2, r.getId());

			// compruebo que haya borrado solo una fila y devuelvo true
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
			// le paso a la sentencia SQL el id como parametro
			pst.setLong(1, id);
			// compruebo que haya borrado solo una fila y devuelvo true
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

	private Receta mapear(ResultSet rs) throws SQLException, VehiculoException {
		Receta r = new Receta();
		r.setId(rs.getLong("id"));
		r.setTitulo(rs.getString("titulo"));

		return r;

	}

}
