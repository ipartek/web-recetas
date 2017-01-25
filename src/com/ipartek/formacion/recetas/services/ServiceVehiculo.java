package com.ipartek.formacion.recetas.services;

import java.util.List;

import com.ipartek.formacion.recetas.ejercicios.herencia.Vehiculo;

public interface ServiceVehiculo {

	/**
	 * Obtener todos los Vehiculos, limitado a 500
	 * @return Coleccion de Vehiculos, si no existen coleccion vacia pero no nula
	 */
	List<Vehiculo> getAll();
	
	/**
	 * Otenemos Vehiculo por su identificador en la Base Datos
	 * @param id identificador
	 * @return Vehiculo, null si no existe
	 */
	Vehiculo getById(long id);
	
	/**
	 * Elimina Vehiculo por su identificador
	 * @param id identificado
	 * @return true si elimina, false si no
	 */
	boolean delete(long id);
	
	/**
	 * Modifica un Vehiculo Existente
	 * @param v Vehiculo
	 * @return true si modifica, false si no
	 */
	boolean update(Vehiculo v);
	
	/**
	 * Añade un Vehiculo a la lista y le asigna un identificador
	 * @param v Vehiculo a crear
	 * @return true si añade, false si no
	 */
	boolean create(Vehiculo v);
	
	
}
