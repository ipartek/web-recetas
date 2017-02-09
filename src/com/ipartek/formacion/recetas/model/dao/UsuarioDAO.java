package com.ipartek.formacion.recetas.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.recetas.ejercicios.herencia.Vehiculo;
import com.ipartek.formacion.recetas.model.DataBaseConnectionImpl;
import com.ipartek.formacion.recetas.model.Persistable;
import com.ipartek.formacion.recetas.pojo.Usuario;
import com.ipartek.formacion.recetas.pojo.VehiculoException;

public class UsuarioDAO implements Persistable<Usuario> {

	private static UsuarioDAO INSTANCE = null;
	private static DataBaseConnectionImpl db;
	private Connection conn;

	static final private String SQL_GET_ALL = "SELECT `id`,`nombre`,`apellido1`,`apellido2`,`edad`,`email`,`dni`,`puesto`,`password`,`imagen` FROM `usuario` ORDER BY `id` DESC LIMIT 500;";
	static final private String SQL_GET_BY_ID = "SELECT `id`,`nombre`,`apellido1`,`apellido2`,`edad`,`email`,`dni`,`puesto`,`password`,`imagen` FROM `usuario` WHERE `id` = ?;";
	static final private String SQL_GET_BY_EMAIL = "SELECT `id`,`nombre`,`apellido1`,`apellido2`,`edad`,`email`,`dni`,`puesto`,`password`,`imagen` FROM `usuario` WHERE `email` = ?;";
	static final private String SQL_COUNT = "SELECT COUNT(`id`) FROM `usuario`;";

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
		// TODO Auto-generated method stub
		ArrayList<Usuario> list = null;

		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			list = new ArrayList<Usuario>();
			conn = db.getConexion();
			pst = conn.prepareStatement(SQL_GET_ALL); //Mirar SQL
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean create(Usuario objeto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Usuario objeto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(long id) {
		// TODO Auto-generated method stub
		return false;
	}

	public Usuario getByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	Usuario existe(String email, String password) {
		return null;
	}

	/**
	 * Cuenta los usuario totales de la tabla
	 * 
	 * @return <code>int </code>numero entero de registros
	 */
	int count() {
		return 0;
	}
	
	private Vehiculo mapear(ResultSet rs) throws SQLException, VehiculoException {
		Vehiculo v = new Vehiculo();
		v.setId(rs.getLong("id"));
		v.setModelo(rs.getString("modelo"));
		// TODO dimensiones
		// v.setDimensiones(dimensiones);
		v.setPlazas(rs.getInt("plazas"));
		v.setPotencia(rs.getFloat("potencia"));
		return v;
	}

}
