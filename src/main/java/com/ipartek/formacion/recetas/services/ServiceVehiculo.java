package com.ipartek.formacion.recetas.services;

import java.util.List;

import com.ipartek.formacion.recetas.ejercicios.herencia.Vehiculo;

public interface ServiceVehiculo {

	/**
	 * Optener todos los Vehiculos, limitado a 500
	 * 
	 * @return Coleccion de Vehiculos, si no colecion vacia pero no nula
	 */
	List<Vehiculo> getAll();

	/**
	 * Obtenemos Vehiculo por su identificador en la Base Datos
	 * 
	 * @param id
	 *            identificador
	 * @return Vehiculo, null si no existe
	 */
	Vehiculo getById(long id);

	/**
	 * Elimina Vehiculo por su identificador
	 * 
	 * @param id
	 *            identificador
	 * @return true si elimina, false en caso contrario
	 */
	boolean delete(long id);

	/**
	 * Modifica un vehiculo existente
	 * 
	 * @param v
	 *            Vehiculo con los datos a modificar
	 * @return true si modifica, false en caso contrario
	 */
	boolean update(Vehiculo v);

	/**
	 * Crea un nuevo Vehiculo y le asigna un identificador
	 * 
	 * @param v
	 *            Vehiculo a crear
	 * @return true si crea, false en caso contrario
	 */
	boolean create(Vehiculo v);

}
