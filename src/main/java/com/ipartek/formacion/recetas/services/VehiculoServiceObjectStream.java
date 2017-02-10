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

	private static VehiculoServiceObjectStream INSTANCE;
	private static ArrayList<Vehiculo> vehiculos = null;
	public static final String PATH = "C:\\desarrollo\\workspace\\web-recetas\\data\\vehiculo.txt";

	private VehiculoServiceObjectStream() {

		vehiculos = new ArrayList<Vehiculo>();
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

	private void guardarFichero(ArrayList<Vehiculo> vehiculos) {

		ObjectOutputStream oos = null;

		try {
			oos = new ObjectOutputStream(new FileOutputStream(PATH));
			oos.writeObject(vehiculos);
			oos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

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

	@Override
	public List<Vehiculo> getAll() {
		vehiculos = leerFichero();
		return vehiculos;
	}

	@Override
	public Vehiculo getById(long id) {
		Vehiculo resul = null;
		vehiculos = leerFichero();
		for (Vehiculo vehiculo : vehiculos) {
			if (id == vehiculo.getId()) {
				resul = vehiculo;
				break;
			}
		}
		return resul;
	}

	@Override
	public boolean delete(long id) {
		boolean resul = false;
		vehiculos = leerFichero();
		for (Vehiculo vehiculo : vehiculos) {
			if (id == vehiculo.getId()) {
				vehiculos.remove(vehiculo);
				resul = true;
				break;
			}
		}

		// guarda cambios si encuentra
		if (resul) {
			guardarFichero(vehiculos);
		}

		return resul;
	}

	@Override
	public boolean update(Vehiculo vAcambiar) {
		boolean resul = false;
		vehiculos = leerFichero();
		for (Vehiculo vehiculo : vehiculos) {
			if (vAcambiar.getId() == vehiculo.getId()) {
				int pos = vehiculos.indexOf(vehiculo);
				vehiculos.remove(vehiculo);
				vehiculos.add(pos, vAcambiar);
				resul = true;
				break;
			}
		}

		// guarda cambios si encuentra
		if (resul) {
			guardarFichero(vehiculos);
		}

		return resul;
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

}
