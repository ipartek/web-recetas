package com.ipartek.formacion.recetas.services;

import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.recetas.pojo.Usuario;

public class ServiceDadoArrayList {

	private static ServiceDadoArrayList INSTANCE;
	private static ArrayList<Usuario> usuarios = null;
	// simular el indice en la BaseDatos
	private static long indice = 500;

	// Private constructor suppresses
	private ServiceDadoArrayList() {

		usuarios = new ArrayList<>();
		usuarios.add(new Usuario("Aaron"));
		usuarios.add(new Usuario("Eneko"));
		usuarios.add(new Usuario("Itsaso"));
		usuarios.add(new Usuario("Ivan"));
		usuarios.add(new Usuario("Guillermo"));
		usuarios.add(new Usuario("Lozoya"));
		usuarios.add(new Usuario("Josu"));
		usuarios.add(new Usuario("Ignacio"));
		usuarios.add(new Usuario("Gomez"));
		usuarios.add(new Usuario("Nerea"));
		usuarios.add(new Usuario("Nagore"));
		usuarios.add(new Usuario("Garbieñe"));
		usuarios.add(new Usuario("Egoitz"));
		usuarios.add(new Usuario("Pavel"));
		usuarios.add(new Usuario("Pérez"));
	}

	// creador sincronizado para protegerse de posibles problemas multi-hilo
	// otra prueba para evitar instanciación múltiple
	private synchronized static void createInstance() {
		if (INSTANCE == null) {
			INSTANCE = new ServiceDadoArrayList();
		}
	}

	public static ServiceDadoArrayList getInstance() {
		if (INSTANCE == null) {
			createInstance();
		}
		return INSTANCE;
	}

	public List<Usuario> getAll() {
		return this.usuarios;
	}

	public Usuario getById(long id) {
		Usuario resul = null;
		for (Usuario u : usuarios) {
			if (id == u.getId()) {
				resul = u;
				break;
			}
		}
		return resul;
	}

	public boolean delete(long id) {
		boolean resul = false;
		for (Usuario u : usuarios) {
			if (id == u.getId()) {
				resul = true;
				usuarios.remove(u);
				break;
			}
		}
		return resul;
	}

	public boolean update(Usuario uModificar) {
		boolean resul = false;
		for (Usuario v : usuarios) {
			if (uModificar.getId() == v.getId()) {
				resul = true;
				int pos = usuarios.indexOf(v);
				usuarios.remove(v);
				usuarios.add(pos, uModificar);
				break;
			}
		}
		return resul;
	}

	public boolean create(Usuario u) {
		u.setId(++indice);
		return usuarios.add(u);
	}

	public int getNumeroUsuarios() {
		// TODO Auto-generated method stub
		return usuarios.size();
	}

	public Usuario getByPos(int index) {
		// TODO Auto-generated method stub
		return usuarios.get(index);
	}

}
