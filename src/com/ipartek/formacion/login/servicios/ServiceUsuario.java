package com.ipartek.formacion.login.servicios;

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

	public List<Usuario> listar() {
		return daoLogin.getAll();
	}

	public Login buscarPorID(long id) {
		return daoLogin.getByID(id);
	}

	public Login buscarPorEmail(String mail) {
		return daoLogin.getByID(id);
	}

	public boolean darDeBaja(long id) {
		// TODO Auto-generated method stub
		return daoLogin.delete(id);
	}

	public boolean darDeBaja(Usuario u) {
		// TODO Auto-generated method stub
		return daoLogin.update(u);
	}

	public boolean darDeAlta(Usuario u) {
		// TODO Auto-generated method stub
		return daoLogin.update(u);
	}

	/**
	 * Si existe devuelve un usuario no existe devuelve null
	 * 
	 * @param mail
	 * @param pass
	 * @return
	 */
	public Usuario existe(String mail, String pass) {
		// TODO Auto-generated method stub
		return daoLogin.update(v);
	}

}
