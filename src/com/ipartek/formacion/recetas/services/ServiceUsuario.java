package com.ipartek.formacion.recetas.services;

import java.util.List;

import com.ipartek.formacion.recetas.pojo.Usuario;

public interface ServiceUsuario {
	/**
	 * 
	 * @return
	 */

	List<Usuario> listar();

	/**
	 * 
	 * @param id
	 * @return
	 */

	Usuario buscarPorId(long id);

	/**
	 * 
	 * @param email
	 * @return
	 */

	Usuario buscarPorEmail(String email);

	/**
	 * 
	 * @param id
	 * @return
	 */

	boolean darDeBaja(long id);

	/**
	 * 
	 * @param u
	 * @return
	 */

	boolean modificar(Usuario u);

	/**
	 * 
	 * @param u
	 * @return
	 */

	boolean darDeAlta(Usuario u);

	/**
	 * 
	 * @param email
	 * @param password
	 * @return
	 */
	Usuario existe(String email, String password);

	/**
	 * 
	 * @return
	 */

	int usuariosTotales();

}
