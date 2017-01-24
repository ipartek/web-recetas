package com.ipartek.formacion.recetas.services;

import java.util.List;

import com.ipartek.formacion.recetas.ejercicios.herencia.Vehiculo;

public interface ServiceVehiculo {

	/**
	 * Obtener todos los vehiculos, limitado a 500.
	 * 
	 * @return Coleccion de vehiculos, si no existen coleccion vacia pero no
	 *         nula.
	 */
	List<Vehiculo> getAll();

	/**
	 * Obtenemos Vehiculo por su identificador en la BBDD.
	 * 
	 * @param id
	 *            identificador.
	 * @return Vehiculo, null si no existe.
	 */
	Vehiculo getById(long id);

	/**
	 * Elmina Vehiculo por su identificador.
	 * 
	 * @param id
	 *            identificador.
	 * @return true si elimina, false en caso contrario.
	 */
	boolean delete(long id);

	/**
	 * Modifica un Vehiculo existente.
	 * 
	 * @param v
	 *            Vehiculo con los datos a modificar.
	 * @return true si modifica, false en caso contrario.
	 */
	boolean update(Vehiculo v);

	/**
	 * Crea un nuevo Vehiculo y le asigna un identificador.
	 * 
	 * @param v
	 *            Vehiculo a crear.
	 * @return true si crea, false en caso contrario.
	 */
	boolean create(Vehiculo v);
}
