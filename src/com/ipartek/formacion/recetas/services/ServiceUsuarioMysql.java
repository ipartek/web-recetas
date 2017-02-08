package com.ipartek.formacion.recetas.services;

import java.util.List;

import com.ipartek.formacion.recetas.model.dao.UsuarioDAO;
import com.ipartek.formacion.recetas.pojo.Usuario;

public class ServiceUsuarioMysql implements ServiceUsuario {

	private static ServiceUsuarioMysql INSTANCE;
	private static UsuarioDAO daoUsuario;

	private ServiceUsuarioMysql() {
		daoUsuario = UsuarioDAO.getInstance();
	}

	private synchronized static void createInstance() {
		if (INSTANCE == null) {
			INSTANCE = new ServiceUsuarioMysql();
		}
	}

	public static ServiceUsuarioMysql getInstance() {
		if (INSTANCE == null) {
			createInstance();
		}
		return INSTANCE;
	}

	@Override
	public List<Usuario> listar() {
		return daoUsuario.getAll();
	}

	@Override
	public Usuario buscarPorId(long id) {
		return daoUsuario.getById(id);
	}

	@Override
	public Usuario buscarPorEmail(String email) {

		return daoUsuario.getByEmail(email);
	}

	@Override
	public boolean darDeBaja(long id) {
		return daoUsuario.delete(id);
	}

	@Override
	public boolean darDeAlta(Usuario u) {
		return daoUsuario.create(u);
	}

	@Override
	public boolean modificar(Usuario u) {
		return daoUsuario.update(u);
	}

	@Override
	public Usuario existe(String email, String password) {

		return daoUsuario.existe(email, password);
	}

	@Override
	public int usuarioTotales() {

		return daoUsuario.count();
	}

}
