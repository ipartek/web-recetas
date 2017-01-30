package com.ipartek.formacion.recetas.model;

import java.util.List;

/**
 * 
 * operaciones básicas de CRUD:
 * <ol>
 * <li>Create</li>
 * <li>Read</li>
 * <li>Update</li>
 * <li>Delete</li>
 * </ol>
 * 
 * * @author Curso
 * @param<T> tabla
 *               que vamos a persistir
 *
 */
public interface Persistable<T> {

	List<T> getAll();

	T getId(long id);

	boolean create(T objeto);

	boolean update(T objeto);

	boolean delete(long id);

}
