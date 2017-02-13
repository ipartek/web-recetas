package com.ipartek.formacion.recetas.services;

import java.util.List;

import com.ipartek.formacion.recetas.pojo.Usuario;

public interface ServiceUsuario {

	List<Usuario> listar();

	Usuario buscarPorId(long id);

	Usuario buscarPorEmail(String email);

	/**
	 * Buscamos un Usuario por su DNI
	 * 
	 * @param dni
	 *            String con 8 numeros y 1 letra ( sin guiones sin espacios, ej:
	 *            12345678L )
	 * @return Usuario si lo encuentra, null si no encuentra
	 */
	Usuario buscarPorDni(String dni);

	boolean darDeBaja(long id);

	boolean darDeAlta(Usuario u);

	boolean modificar(Usuario u);

	Usuario existe(String email, String password);

	int usuarioTotales();

	boolean comprobarIntegridad(String dni, String email);

}
