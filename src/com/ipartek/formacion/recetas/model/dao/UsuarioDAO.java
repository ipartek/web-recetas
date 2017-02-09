package com.ipartek.formacion.recetas.model.dao;

import java.sql.Connection;
import java.util.List;

import com.ipartek.formacion.recetas.model.DataBaseConnectionImpl;
import com.ipartek.formacion.recetas.model.Persistable;
import com.ipartek.formacion.recetas.pojo.Usuario;

public class UsuarioDAO implements Persistable<Usuario> {

	static final private String SQL_GET_ALL = "SELECT `id`,`nombre`,`apellido1`,`apellido2`,`edad`,`email`,`dni`,`puesto`,`password`,`imagen` FROM `usuario` ORDER BY `id` DESC LIMIT 500;";
	static final private String SQL_GET_BY_ID = "SELECT `id`,`nombre`,`apellido1`,`apellido2`,`edad`,`email`,`dni`,`puesto`,`password`,`imagen` FROM `usuario` WHERE `id` = ?;";
	static final private String SQL_GET_BY_EMAIL = "SELECT `id`,`nombre`,`apellido1`,`apellido2`,`edad`,`email`,`dni`,`puesto`,`password`,`imagen` FROM `usuario` WHERE `email` = ?;";
	static final private String SQL_COUNT = "SELECT COUNT(`id`) FROM `usuario`;";

	private static UsuarioDAO INSTANCE = null;
	private static DataBaseConnectionImpl db = null;
	private Connection conn = null;

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
		return null;
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

}
