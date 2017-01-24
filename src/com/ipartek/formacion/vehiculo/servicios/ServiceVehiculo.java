package com.ipartek.formacion.vehiculo.servicios;

import java.util.List;

import com.ipartek.formacion.vehiculo.pojo.Vehiculo;

public interface ServiceVehiculo {

	/**
	 * Obtener todos los vehiculos,Limitado a 500
	 *
	 * @return Coleccion de <code>Vehiculo</code> Si no existe Coleccion vacia
	 *         (no nula)
	 */

	List<Vehiculo> getAll();

	/**
	 *
	 * @param id
	 *            identifier
	 * @return Vehiculo null si no existe
	 */
	Vehiculo getById(long id);

	/**
	 * Elimina <code>Vehiculo</code> por su identificador
	 *
	 * @param id
	 * @return true if sucess <br>
	 *         false if not
	 */
	boolean delete(long id);

	/**
	 * Modifica un vehiculo existente
	 *
	 * @param v
	 *            <code>Vehiculo</code>
	 * @return true if sucess <br>
	 *         false if not
	 */
	boolean update(Vehiculo v);

	/**
	 * Crea un nuevo <code>Vehiculo</code> y le asigna un <code>Id</code>
	 *
	 * @param v
	 *            <code>Vehiculo</code>
	 * @return true if sucess <br>
	 *         false if not
	 */
	boolean create(Vehiculo v);

}
