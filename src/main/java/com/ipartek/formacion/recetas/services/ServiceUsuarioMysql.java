package com.ipartek.formacion.recetas.services;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
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
		return daoUsuario.getAll();
	}

	@Override
	public Usuario buscarPorId(long id) {
		// TODO Auto-generated method stub
		return daoUsuario.getById(id);
	}

	@Override
	public Usuario buscarPorEmail(String email) {
		// TODO Auto-generated method stub
		return daoUsuario.getByEmail(email);
	}

	@Override
	public boolean darDeBaja(long id) {
		// TODO Auto-generated method stub
		return daoUsuario.delete(id);
	}

	@Override
	public boolean darDeAlta(Usuario u) {
		// TODO Auto-generated method stub
		return daoUsuario.create(u);
	}

	@Override
	public boolean modificar(Usuario u) {
		// TODO Auto-generated method stub
		return daoUsuario.update(u);
	}

	@Override
	public Usuario existe(String email, String password) {
		// TODO Auto-generated method stub
		return daoUsuario.existe(email, password);
	}

	@Override
	public int usuarioTotales() {
		// TODO Auto-generated method stub
		return daoUsuario.count();
	}

	@Override
	public ArrayList<Usuario> filtrarPorNombre(String opcion) {
		// TODO Auto-generated method stub
		return daoUsuario.getAllByName(opcion);
	}

	@Override
	public ArrayList<Usuario> filtrarPorDni(String opcion) {
		// TODO Auto-generated method stub
		return daoUsuario.getAllByDNI(opcion);
	}

	@Override
	public ArrayList<Usuario> filtrarPorEmail(String opcion) {
		// TODO Auto-generated method stub
		return daoUsuario.getAllByEmail(opcion);
	}

}
