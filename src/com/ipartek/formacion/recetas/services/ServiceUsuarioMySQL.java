package com.ipartek.formacion.recetas.services;

import java.util.List;

import com.ipartek.formacion.recetas.model.dao.UsuarioDAO;
import com.ipartek.formacion.recetas.pojo.Usuario;

public class ServiceUsuarioMySQL implements ServiceUsuario{
	private static ServiceUsuarioMySQL INSTANCE;
	private static UsuarioDAO daoUsuario;

	private ServiceUsuarioMySQL() {
		daoUsuario = UsuarioDAO.getInstance();
	}

	private synchronized static void createInstance() {
		if (INSTANCE == null) {
			INSTANCE = new ServiceUsuarioMySQL();
		}
	}

	public static ServiceUsuarioMySQL getInstance() {
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
		return daoUsuario.count() ;
	}

	@Override
	public Usuario buscarPorDni(String dni) {
		return daoUsuario.getByDni(dni);
	}

	@Override
	public List<Usuario> buscarPorNombreOApellido(String busqueda) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Usuario> buscarPorEdad(int edadMin, int edadMax) {
		// TODO Auto-generated method stub
		return null;
	}

}
