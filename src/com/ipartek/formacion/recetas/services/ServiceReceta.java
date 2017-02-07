package com.ipartek.formacion.recetas.services;

import java.util.List;

import com.ipartek.formacion.recetas.pojo.Receta;

public interface ServiceReceta {

	/**
	 * Obtener todas las Recetas, limitado a 500
	 * 
	 * @return Coleccion de Recetas, si no coleccion vacia pero no nula
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
	 * @return true si elimina, false en caso contrario
	 */
	boolean delete(long id);

	/**
	 * Modifica una receta existente
	 * 
	 * @param r
	 *            Receta con los datos a modificar
	 * @return true si modifica, false en caso contrario
	 */
	boolean update(Receta r);

	/**
	 * Crea un nuevo Receta y le asigna un identificador
	 * 
	 * @param r
	 *            Receta a crear
	 * @return true si crea, false en caso contrario
	 */
	boolean create(Receta r);

}
