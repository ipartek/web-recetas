package com.ipartek.formacion.recetas.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.recetas.ejercicios.herencia.Vehiculo;

public class VehiculoServiceObjectStream implements ServiceVehiculo {

	public static final String PATH = "C:\\Desarrollo\\Workspace\\web-recetas\\data\\vehiculo.txt";
	private static VehiculoServiceObjectStream INSTANCE;
	private File fichero = new File(PATH);
	private ArrayList<Vehiculo> vehiculos = null;
	private static long indice = 500;

	// Constructor
	private VehiculoServiceObjectStream() {

		// Buscar ficheros en PATH
		if (fichero.exists()) {
			try {
				ObjectInputStream out = new ObjectInputStream(new FileInputStream(PATH));
				{
					vehiculos = (ArrayList<Vehiculo>) out.readObject();

					out.close();
				}

			} catch (Exception e) {

			}

		} else {
			try {
				ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(PATH));
				{
					vehiculos = new ArrayList<>();
					vehiculos.add(new Vehiculo("Seat Panda", 2));
					vehiculos.add(new Vehiculo("Lamborgini", 4));
					vehiculos.add(new Vehiculo("Ford K2", 1));
					vehiculos.add(new Vehiculo("Citroen Xsara", 12));
					vehiculos.add(new Vehiculo("Ferrari", 500));
					vehiculos.add(new Vehiculo("Tesla", 23));
					out.writeObject(vehiculos);

					out.close();
				}
			} catch (Exception e) {
				e.printStackTrace();

			}
		}

	}

	// Patron Singleton
	private synchronized static void createInstance() {
		if (INSTANCE == null)
			INSTANCE = new VehiculoServiceObjectStream();

	}

	public static VehiculoServiceObjectStream getInstance() {
		if (INSTANCE == null)
			createInstance();
		return INSTANCE;
	}

	// TODO Cuidado hay que comprobar que el fichero existe, si no existe,
	// crearlo.
	// TODO PATH relativo al proyecto.

	private boolean archivoExiste() {
		return false;
	}

	@Override
	public List<Vehiculo> getAll() {
		return this.vehiculos;
	}

	@Override
	public Vehiculo getById(long id) {
		Vehiculo resul = null;
		for (Vehiculo v : vehiculos) {
			if (id == v.getId()) {
				resul = v;
				break;
			}
		}
		return resul;
	}

	@Override
	public boolean delete(long id) {
		boolean resul = false;
		for (Vehiculo v : vehiculos) {
			if (id == v.getId()) {
				resul = true;
				vehiculos.remove(v);
				break;
			}
		}
		return resul;
	}

	@Override
	public boolean update(Vehiculo vModificar) {
		boolean resul = false;
		for (Vehiculo v : vehiculos) {
			if (vModificar.getId() == v.getId()) {
				resul = true;
				int pos = vehiculos.indexOf(v);
				vehiculos.remove(v);
				vehiculos.add(pos, vModificar);
				break;
			}
		}
		return resul;
	}

	@Override
	public boolean create(Vehiculo v) {
		boolean resul = false;
		v.setId(++indice);
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(PATH));
			if (vehiculos.add(v)) {
				resul = true;
			} else {
				resul = false;
			}
			out.writeObject(vehiculos);
			out.close();

		} catch (Exception e) {

		} finally {
		}

		return resul;
	}
}
