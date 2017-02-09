package com.ipartek.formacion.recetas.services;

import java.util.List;

import com.ipartek.formacion.recetas.pojo.Usuario;

public interface ServiceUsuario {

	List<Usuario> listar();

	Usuario buscarPorId(long id);

	Usuario buscarPorEmail(String email);
		
	Usuario buscarPorDni(String dni);
	
	/**
	 * Busca cualquier coincidencia en los nombre o apellidos, ignorecase
	 * @param busqueda 
	 * @return
	 */
	List<Usuario> buscarPorNombreOApellido(String busqueda);
	
	List<Usuario> buscarPorEdad(int edadMin, int edadMax);
	

	boolean darDeBaja(long id);

	boolean darDeAlta(Usuario u);

	boolean modificar(Usuario u);

	Usuario existe(String email, String password);

	int usuarioTotales();

}
