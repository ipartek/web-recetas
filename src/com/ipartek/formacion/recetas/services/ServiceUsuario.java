package com.ipartek.formacion.recetas.services;

import java.util.List;

import com.ipartek.formacion.recetas.pojo.Usuario;

public interface ServiceUsuario {

	List<Usuario> listar();

	Usuario buscarPorId(long id);

	Usuario buscarPorEmail(String email);

	boolean darDeBaja(long id);

	boolean darDeAlta(Usuario u);

	boolean modificar(Usuario u);

	Usuario existe(String email, String password);

	int usuarioTotales();

	List<Usuario> fiterPersona(String nombre, String apellido1, String apellido2, String email, String dni, int edadMin,
			int edadMax);
}
