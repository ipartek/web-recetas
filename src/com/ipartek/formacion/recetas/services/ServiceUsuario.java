package com.ipartek.formacion.recetas.services;

import java.util.List;

import com.ipartek.formacion.recetas.pojo.Usuario;

public interface ServiceUsuario {

	List<Usuario> listar();

	Usuario buscarPorId(long id);

	Usuario buscarPorEmail(String email);

	boolean darDeAlta(long id);

	boolean darDeBaja(long id);

	boolean modificar(Usuario u);

	Usuario existe(String email, String password);

	int usuarioTotales();

}
