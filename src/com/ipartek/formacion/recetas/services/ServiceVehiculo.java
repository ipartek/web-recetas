package com.ipartek.formacion.recetas.services;

import java.util.List;

import com.ipartek.formacion.recetas.ejercicios.herencia.Vehiculo;

public interface ServiceVehiculo {
	/**
	 * Obtener todos los Vehiculos, limitado a 500
	 * @return Coleccion de Vehiculos, si no coleccion vacia pero no nula
	 */
	List<Vehiculo> getAll();
	/**
	 * Obtenemos el vehiculo por su identificador en la base datos
	 * @param id identificador
	 * @return Vehiculo, null si no existe
	 */
	Vehiculo getById(long id);
	/**
	 * Elimina vehiculo por su identificador
	 * @param id identificador
	 * @return true si elimina, false en caso contrario
	 */
	boolean delete(long id);
	/**
	 * Modifica un vehiculo existente
	 * @param v Vehiculo con los datos a modificar
	 * @return True si modifica, false en caso contrario
	 */
	boolean update(Vehiculo v);
	/**
	 * Crea un nuevo Vehiculo y le asigna un identificador
	 * @param v Vehiculo
	 * @return true si lo crea, false en caso contrario
	 */
	boolean create(Vehiculo v);
}
