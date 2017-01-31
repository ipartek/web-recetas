package com.ipartek.formacion.recetas.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.recetas.ejercicios.herencia.pojo.Vehiculo;

public class VehiculoServiceObjectStream implements ServiceVehiculo {
	public static final String PATH = "C:\\desarrollo\\workspace\\web-recetas\\data\\vehiculo.txt";
	private ArrayList<Vehiculo> vehiculos = null;
	private static VehiculoServiceObjectStream INSTANCE;
	private FileOutputStream fichero = null;

	// Constructor
	private VehiculoServiceObjectStream() {

		ObjectOutputStream out;
		try {

			if (!existe()) {
				fichero = new FileOutputStream(PATH);
				out = new ObjectOutputStream(fichero);

				vehiculos = new ArrayList<>();
				vehiculos.add(new Vehiculo("Seat Panda", 4));
				vehiculos.add(new Vehiculo("Lamborghini", 2));
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

	private boolean existe() {
		boolean resul = false;

		try {
			File f = new File(PATH);
			resul = f.exists();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return resul;
	}

	// Patron Singleton
	private synchronized static void createInstance() {
		if (INSTANCE == null) {
			INSTANCE = new VehiculoServiceObjectStream();

		}
	}

	public static VehiculoServiceObjectStream getInstance() {
		if (INSTANCE == null)
			createInstance();
		return INSTANCE;
	}

	// Cuidado hay que comprobar q el fichero existe
	// si no existe crearlo
	// PATH relativo al proyecto

	// ServiceVehiculo
	@Override
	public List<Vehiculo> getAll() {
		ArrayList<Vehiculo> resul = new ArrayList<Vehiculo>();
		try {
			FileInputStream fin = new FileInputStream(PATH);
			ObjectInputStream ois = new ObjectInputStream(fin);

			resul.addAll((ArrayList<Vehiculo>) ois.readObject());

			ois.close();
			fin.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return resul;

	}

	@Override
	public Vehiculo getById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Vehiculo v) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean create(Vehiculo v) {
		// TODO Auto-generated method stub
		return false;
	}

}
