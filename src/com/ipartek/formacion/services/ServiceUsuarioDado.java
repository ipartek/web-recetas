package com.ipartek.formacion.services;

import java.util.List;

import com.ipartek.formacion.pojo.Usuario;

public interface ServiceUsuarioDado {

	
	List<Usuario> getAll();


	Usuario getById(long id);


	boolean delete(long id);


	boolean update(Usuario u);


	boolean create(Usuario u);

	int getNumeroUsuarios();
	
	Usuario getByPos(int id);
}
