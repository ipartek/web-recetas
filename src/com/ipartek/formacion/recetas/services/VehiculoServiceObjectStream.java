package com.ipartek.formacion.recetas.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.recetas.ejercicios.herencia.Vehiculo;

public class VehiculoServiceObjectStream implements ServiceVehiculo {

	// Patron Singleton
	private static VehiculoServiceObjectStream INSTANCE;

	private ArrayList<Vehiculo> vehiculos = null;
	private Vehiculo vehiculo = null;

	// Simular el indice en BBDD.
	private static long indice = 500;

	// TODO PATH relativo al proyecto
	public static final String PATH = "C:\\desarrollo\\workspace\\web-recetas\\data\\vehiculo.txt";

	// Private constructor suppresses
	private VehiculoServiceObjectStream() {

		// Inicializar varios Vehiculos
		vehiculos = new ArrayList<>();
		vehiculos.add(new Vehiculo("Seat Panda", 2));
		vehiculos.add(new Vehiculo("Lamborgini", 4));
		vehiculos.add(new Vehiculo("Ford K2", 1));
		vehiculos.add(new Vehiculo("Citroen Sara", 12));
		vehiculos.add(new Vehiculo("Ferrari", 23));
		vehiculos.add(new Vehiculo("Tesla", 500));
		existeFichero(vehiculos);

	}

	// creador sincronizado para protegerse de posibles problemas multi-hilo
	// otra prueba para evitar instanciación múltiple
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

	@Override
	public List<Vehiculo> getAll() {

		vehiculos = leerFichero();

		return vehiculos;
	}

	@Override
	public Vehiculo getById(long id) {

		vehiculos = leerFichero();

		for (Vehiculo v : vehiculos) {
			if (v.getId() == id) {
				vehiculo = v;
			}
		}

		return vehiculo;
	}

	@Override
	public boolean delete(long id) {
		boolean resul = false;

		vehiculos = leerFichero();

		for (Vehiculo v : vehiculos) {
			if (id == v.getId()) {
				vehiculos.remove(v);
				resul = true;
				break;
			}
		}

		resul = escribirFichero(vehiculos);

		return resul;
	}

	@Override
	public boolean update(Vehiculo v) {
		boolean resul = false;

		vehiculos = leerFichero();

		// update un objeto
		for (Vehiculo v_old : vehiculos) {
			if (v_old.getId() == v.getId()) {
				int pos = vehiculos.indexOf(v_old);
				vehiculos.remove(v_old);
				vehiculos.add(pos, v);
				break;
			}
		}

		resul = escribirFichero(vehiculos);
		return resul;
	}

	@Override
	public boolean create(Vehiculo v) {
		boolean resul = false;

		vehiculos = leerFichero();

		vehiculo = vehiculos.get(vehiculos.size() - 1);
		indice = vehiculo.getId();

		v.setId(++indice);
		vehiculos.add(v);

		resul = escribirFichero(vehiculos);

		return resul;
	}

	// Comprobar que el fichero existe, si no existe crearlo
	public void existeFichero(ArrayList<Vehiculo> v) {

		File fichero = new File(PATH);

		// ver si existe el fichero
		if (!fichero.exists()) {
			// crear fichero
			FileWriter fw;
			try {
				fw = new FileWriter(PATH);

				// Incluir en el fichero un array de vehiculos para inicializar.
				boolean resul = escribirFichero(v);

				// Cerrar todo
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} // end if
	}

	// Leer del fichero y sacar a un ArrayList<Vehiculo>
	public ArrayList<Vehiculo> leerFichero() {
		vehiculos = null;

		try {
			FileInputStream fis = new FileInputStream(PATH);
			ObjectInputStream ois = new ObjectInputStream(fis);
			vehiculos = (ArrayList<Vehiculo>) ois.readObject();

			// cerrar todo
			ois.close();
			fis.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return vehiculos;
	}

	// Escribir en el fichero un ArrayList<Vehiculo>
	public boolean escribirFichero(ArrayList<Vehiculo> vehiculos) {
		boolean resul = false;

		try {
			FileOutputStream fout = new FileOutputStream(PATH);
			ObjectOutputStream oos = new ObjectOutputStream(fout);
			oos.writeObject(vehiculos);
			oos.writeObject(null);

			// cerrar todo
			oos.close();
			fout.close();
			resul = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resul;
	}

}
