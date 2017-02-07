package com.ipartek.formacion.login.servicios;

import java.util.List;

import com.ipartek.formacion.login.model.dao.UsuarioDAO;
import com.ipartek.formacion.pojo.Usuario;

public class ServiceUsuario {
	private static ServiceUsuario INSTANCE;
	private static UsuarioDAO daoLogin;

	private ServiceUsuario() {

		daoLogin = UsuarioDAO.getInstance();
	}

	private synchronized static void createInstance() {
		if (INSTANCE == null) {
			INSTANCE = new ServiceUsuario();
		}
	}

	public static ServiceUsuario getInstance() {
		if (INSTANCE == null) {
			createInstance();
		}
		return INSTANCE;
	}

	public List<Usuario> getAll() {
		return daoLogin.getAll();
	}

	public Login getById(long id) {
		return daoLogin.getByID(id);
	}

	public boolean delete(long id) {
		// TODO Auto-generated method stub
		return daoLogin.delete(id);
	}

	public boolean update(Usuario v) {
		// TODO Auto-generated method stub
		return daoLogin.update(v);
	}

	public boolean create(Usuario v) {
		// TODO Auto-generated method stub
		return daoLogin.create(v);
	}

}
