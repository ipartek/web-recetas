package com.ipartek.formacion.recetas.model;

import java.util.List;

/**
 * Operaciones basicas de CRUD:
 * <ol>
 * 		<li>Create</li>
 * 		<li>Read</li>
 * 		<li>Update</li>
 * 		<li>Delete</li>
 * </ol>
 * @author Curso
 * @param <T> Tabla que vamos a persistir
 *
 */

public interface Persistable<T> {

	List<T> getAll();
	
	T getById(long id);
	
	boolean create(T objeto);

	boolean update(T objeto);
	
	boolean delete(long id);
}
