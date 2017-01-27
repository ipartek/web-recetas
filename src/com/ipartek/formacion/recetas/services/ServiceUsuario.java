package com.ipartek.formacion.recetas.services;

import java.util.List;

import com.ipartek.formacion.recetas.pojo.Usuario;

public interface ServiceUsuario {

	/**
	 * Optener todos los Vehiculos, limitado a 500
	 * 
	 * @return Coleccion de Vehiculos, si no colecion vacia pero no nula
	 */
	List<Usuario> getAll();


	Usuario getById(long id);


	boolean delete(long id);


	boolean update(Usuario u);


	boolean create(Usuario u);

	int getNumeroUsuarios();
	
	Usuario getByPos(int id);
}
