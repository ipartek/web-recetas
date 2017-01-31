package com.ipartek.formacion.recetas.services;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.recetas.ejercicios.herencia.Vehiculo;

public class VehiculoServiceObjectStream implements ServiceVehiculo {
	File fichero = new File(PATH);
	private static VehiculoServiceObjectStream INSTANCE;
	private static ArrayList<Vehiculo> vehiculos = null;
	// TODO patron Singleton
	// TODO Cuidado hay que comprobar que el fichero existe, si no existe
	// crearlo
	// TODO PATH relativo al proyecto
	public static final String PATH = "C:\\desarrollo\\workspace\\web-recetas\\data\\vehiculo.txt";

	@Override
	public List<Vehiculo> getAll() {

		if (fichero.exists()) {

		}

		return null;
	}

	@Override
	public Vehiculo getById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(long id) {
		fichero.delete();
		System.out.println("el fichero ha sido eliminado");
		return false;
	}

	@Override
	public boolean update(Vehiculo v) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean create(Vehiculo v) {
		try {
			if (fichero.createNewFile() == true) {
				System.out.println("El fichero se ha creado correctamente");
				vehiculos = new ArrayList<>();
				vehiculos.add(new Vehiculo("VehiculoServiceObjectStream", 2));
				vehiculos.add(new Vehiculo("Lamborgini", 4));
				vehiculos.add(new Vehiculo("Ford K2", 1));
				vehiculos.add(new Vehiculo("Citoren Shara", 12));
				vehiculos.add(new Vehiculo("Ferrari", 500));
				vehiculos.add(new Vehiculo("Tesla", 23));
				System.out.println(vehiculos);
			}
		} catch (IOException e) {
			System.out.println("el fichero ya existía");
			e.printStackTrace();
		}

		return true;
	}

	private synchronized static void createInstance() {
		if (INSTANCE == null) {
			INSTANCE = new VehiculoServiceObjectStream();
		}
	}

	public static VehiculoServiceObjectStream getInstance() {
		if (INSTANCE == null) {
			createInstance();
		}
		return INSTANCE;
	}
}