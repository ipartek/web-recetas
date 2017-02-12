package com.ipartek.formacion.recetas.services;

import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.recetas.pojo.Usuario;

public class ServiceUsuarioArrayList implements ServiceUsuario {

	private static ServiceUsuarioArrayList INSTANCE;
	private static ArrayList<Usuario> usuarios = null;

	// Private constructor suppresses
	private ServiceUsuarioArrayList() {

		usuarios = new ArrayList<Usuario>();

		// TODO introducir usuarios a manija?
		usuarios.add(new Usuario());
	}

	// creador sincronizado para protegerse de posibles problemas multi-hilo
	// otra prueba para evitar instanciación múltiple
	private synchronized static void createInstance() {
		if (INSTANCE == null) {
			INSTANCE = new ServiceUsuarioArrayList();
		}
	}

	public static ServiceUsuarioArrayList getInstance() {
		if (INSTANCE == null) {
			createInstance();
		}
		return INSTANCE;
	}

	@Override
	public List<Usuario> listar() {
		return usuarios;
	}

	@Override
	public Usuario buscarPorId(long id) {
		Usuario resul = null;
		for (Usuario u : usuarios) {
			if (id == u.getId()) {
				resul = u;
				break;
			}
		}
		return resul;
	}

	@Override
	public Usuario buscarPorEmail(String email) {
		Usuario resul = null;
		for (Usuario u : usuarios) {
			if (u.getEmail().equals(email)) {
				resul = u;
				break;
			}
		}
		return resul;
	}

	@Override
	public boolean darDeBaja(long id) {
		boolean resul = false;
		for (Usuario u : usuarios) {
			if (id == u.getId()) {
				usuarios.remove(u);
				resul = true;
				break;
			}
		}
		return resul;
	}

	@Override
	public boolean darDeAlta(Usuario u) {
		boolean resul = true;
		for (Usuario user : usuarios) {
			if (user.getNombre().equals(u.getNombre())) {
				resul = false;
				break;
			}
		}
		if (resul) {
			usuarios.add(u);
		}
		return resul;
	}

	@Override
	public boolean modificar(Usuario u) {
		boolean resul = false;
		for (Usuario user : usuarios) {
			if (u.getId() == user.getId()) {
				resul = true;
				int pos = usuarios.indexOf(user);
				usuarios.remove(user);
				usuarios.add(pos, u);
				break;
			}
		}
		return resul;
	}

	@Override
	public Usuario existe(String email, String password) {
		Usuario resul = null;
		for (Usuario u : usuarios) {
			if (u.getEmail().equals(email) && u.getPassword().equals(password)) {
				resul = u;
			}
		}
		return resul;
	}

	@Override
	public int usuariosTotales() {
		return usuarios.size();
	}

	@Override
	public Usuario buscarPorDni(String dni) {
		// TODO Auto-generated method stub
		return null;
	}

}
