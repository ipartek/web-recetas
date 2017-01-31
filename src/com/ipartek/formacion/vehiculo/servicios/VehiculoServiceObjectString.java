package com.ipartek.formacion.vehiculo.servicios;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.vehiculo.pojo.Vehiculo;

public class VehiculoServiceObjectString implements ServiceVehiculo {
	// TODO hay que comprobar que el fichero existe y si no existe crearlo

	private static final String PATH = "C:\\desarrollo\\workspace\\web-recetas\\data\\vehiculo.dat";
	private static ArrayList<Vehiculo> vehiculos = null;
	public static File fichero = null;
	private static VehiculoServiceObjectString INSTANCE = null;
	private static long indice;

	// Private constructor suppresses
	private VehiculoServiceObjectString() {
		if (!existeFile()) {

			vehiculos = new ArrayList<>();
			vehiculos.add(new Vehiculo("Seat Panda", 0));
			vehiculos.add(new Vehiculo("Lamborgini", 1));
			vehiculos.add(new Vehiculo("Ford K2", 2));
			vehiculos.add(new Vehiculo("Citoren Shara", 3));
			vehiculos.add(new Vehiculo("Ferrari", 4));
			vehiculos.add(new Vehiculo("Tesla", 5));

			guardarFichero(vehiculos);

		}

	}

	private synchronized static void createInstance() {
		if (INSTANCE == null) {
			INSTANCE = new VehiculoServiceObjectString();
		}
	}

	public static VehiculoServiceObjectString getInstance() {
		if (INSTANCE == null) {
			createInstance();
		}
		return INSTANCE;
	}

	@Override
	public List<Vehiculo> getAll() {
		vehiculos = leerFichero();
		return vehiculos;
	}

	@Override
	public Vehiculo getById(long id) {
		vehiculos = leerFichero();

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
		
		vehiculos = leerFichero();
		for (Vehiculo v : vehiculos) {
			if (id == v.getId()) {

				vehiculos.remove(v);
				break;
			}
		}
		return guardarFichero(vehiculos);
	}

	@Override
	public boolean update(Vehiculo vMod) {
		vehiculos = leerFichero();
		for (Vehiculo v : vehiculos) {
			if (vMod.getId() == v.getId()) {

				int pos = vehiculos.indexOf(v);
				vehiculos.remove(v);
				vehiculos.add(pos, vMod);
				break;
			}
		}

		return guardarFichero(vehiculos);
	}

	@Override
	public boolean create(Vehiculo v) {
		boolean resul = false;
		try {
			vehiculos = leerFichero();
			// identificador
			v.setId((vehiculos.get(vehiculos.size() - 1).getId() + 1));
			// añadir
			vehiculos.add(v);
			// guardar
			guardarFichero(vehiculos);
			resul = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resul;

	}

	private boolean existeFile() {
		boolean resul = false;
		try {
			resul = new File(PATH).exists();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resul;
	}

	private ArrayList<Vehiculo> leerFichero() {
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new FileInputStream(PATH));
			vehiculos = (ArrayList<Vehiculo>) ois.readObject();
			ois.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vehiculos;
	}

	private boolean guardarFichero(ArrayList<Vehiculo> vehiculos) {

		ObjectOutputStream oos = null;
		boolean result = false;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(PATH));
			oos.writeObject(vehiculos);
			oos.close();
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
