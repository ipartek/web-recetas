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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario buscarPorId(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario buscarPorEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean darDeBaja(long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean darDeAlta(Usuario u) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modificar(Usuario u) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Usuario existe(String email, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int usuarioTotales() {
		// TODO Auto-generated method stub
		return 0;
	}

}
