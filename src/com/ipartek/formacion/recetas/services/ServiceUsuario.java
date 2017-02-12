package com.ipartek.formacion.recetas.services;

import java.util.List;

import com.ipartek.formacion.recetas.pojo.Usuario;

public interface ServiceUsuario {

	List<Usuario> listar();

	Usuario buscarPorId(long id);

	Usuario buscarPorEmail(String email);

	Usuario buscarPorDni(String dni);

	boolean darDeBaja(long id);

	boolean darDeAlta(Usuario u);

	boolean modificar(Usuario u);

	Usuario existe(String email, String password);

	int usuariosTotales();

}
