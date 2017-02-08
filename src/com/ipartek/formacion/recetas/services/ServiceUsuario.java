package com.ipartek.formacion.recetas.services;

import java.util.List;

import com.ipartek.formacion.recetas.pojo.Usuario;

public interface ServiceUsuario {
	
	List<Usuario> listar();
	
	Usuario buscarPorid(long id);
	
	Usuario buscarPoremail(String email);
	
	boolean darDeBaja(long id);
	
	boolean modificar(Usuario u);
	
	boolean darDeAlta(Usuario u);
	
	Usuario existe(String email, String password);
	
	int usuariosTotales();

}
