package com.ipartek.formacion.recetas.services;

import java.util.List;

import com.ipartek.formacion.recetas.pojo.Receta;

public interface ServiceReceta {
	/**
	 * Obtener todos los recetas,limitado a 500
	 * 
	 * @return Coleccion de recetas, si no coleccion vacia pero no nula.
	 */
	List<Receta> getAll();

	/**
	 * Obtenemos Receta por su identificador en la Base Datos
	 * 
	 * @param id
	 *            identificador
	 * @return Receta, null si no existe
	 */
	Receta getById(long id);

	/**
	 * Elimina Receta por su identificador
	 * 
	 * @param id
	 *            identificador
	 * @return true si elimina, false en caso contrario.
	 */
	boolean delete(long id);

	/**
	 * Modifica un Receta existente.
	 * 
	 * @param v
	 *            Receta
	 * @return true si modifica, false en caso contrario.
	 */
	boolean update(Receta r);

	/**
	 * Crea un nuevo Receta y le asigna un identificador
	 * 
	 * @param v
	 *            Receta
	 * @return true si crea, no en caso contrario
	 */
	boolean create(Receta r);
}
