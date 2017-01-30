package com.ipartek.formacion.model;

import java.util.List;

/**
 * Operaciones Basicas de crud
 *
 * @author Curso
 *
 * @param <T>
 *            Tabla que vamos a persistir
 */
public interface Persistable<T> {

	List<T> getAll();

	T getByID(long id);

	boolean create(T obj);

	boolean update(T obj);

	boolean delete(long id);
}
