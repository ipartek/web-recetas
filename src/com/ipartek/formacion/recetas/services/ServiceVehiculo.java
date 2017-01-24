package com.ipartek.formacion.recetas.services;

import java.util.List;

import com.ipartek.formacion.recetas.ejercicios.herencia.Vehiculo;

public interface ServiceVehiculo {

	/**
	 * Obtener todos los Vehiculos, limitado a 500.
	 * 
	 * @return Colección de Vehiculos. Si no existen, colección vacía pero no
	 *         nula.
	 */

	List<Vehiculo> getAll();

	/**
	 * Obtenemos Vehiculo por su identificados en la Base Datos
	 * 
	 * @param id
	 *            identificador
	 * @return Vehiculo, null si no existe
	 */

	Vehiculo getById(long id);

	/**
	 * Elimina Vehiculo por su identificados
	 * 
	 * @param id
	 *            identificador
	 * @return true si elimina, false en caso contrario
	 */

	boolean delete(long id);

	/**
	 * 
	 * Modifica un vehiculo existente
	 * 
	 * @param v
	 *            vehiculo con los datos a modificar
	 * @return true si modifica, false en caso contrario
	 */

	boolean update(Vehiculo v);

	/**
	 * 
	 * Crea un nuevo vehículo no existente y le asugna un identificador
	 * 
	 * @param v
	 *            vehiculo a crear
	 * @return true si lo crea, false en caso contrario
	 */

	boolean create(Vehiculo v);

}
