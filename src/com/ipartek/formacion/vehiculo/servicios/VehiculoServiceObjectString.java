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
		vehiculos = new ArrayList<>();
		vehiculos.add(new Vehiculo("Seat Panda", 1));
		vehiculos.add(new Vehiculo("Ford K2", 2));
		vehiculos.add(new Vehiculo("Lamborgini", 3));
		vehiculos.add(new Vehiculo("Citroen Shara", 4));
		vehiculos.add(new Vehiculo("Ferrari", 5));
		vehiculos.add(new Vehiculo("Tesla", 6));

	}

	private synchronized static void createInstance() {
		if (INSTANCE == null) {
			INSTANCE = new VehiculoServiceObjectString();
			fileExist();

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

		return vehiculos;
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

		for (Vehiculo v : vehiculos) {
			if (id == v.getId()) {

				vehiculos.remove(v);
				break;
			}
		}
		return escribir();
	}

	@Override
	public boolean update(Vehiculo vMod) {

		for (Vehiculo v : vehiculos) {
			if (vMod.getId() == v.getId()) {

				int pos = vehiculos.indexOf(v);
				vehiculos.remove(v);
				vehiculos.add(pos, vMod);
				create(v);
				break;
			}
		}

		return escribir();
	}

	@Override
	public boolean create(Vehiculo v) {
		indice = vehiculos.get(vehiculos.size() - 1).getId();
		v.setId(++indice);

		boolean resul = vehiculos.add(v);
		escribir();

		return resul;
	}

	private static boolean fileExist() {

		File fichero = null;
		BufferedWriter bw = null;
		boolean resul = false;

		try {
			fichero = new File(PATH);
			if (!fichero.exists()) {
				// crear Fichero
				bw = new BufferedWriter(new FileWriter(PATH));

				resul = true;

			} else {
				leer();
				resul = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				bw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return resul;
	}

	private boolean escribir() {
		boolean resul = false;
		// escribe el fichero
		ObjectOutputStream oos = null;
		FileOutputStream fout = null;
		try {
			fout = new FileOutputStream(PATH, true);
			oos = new ObjectOutputStream(fout);
			oos.writeObject(vehiculos);
			oos.writeObject(null);

			resul = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (oos != null) {
				try {
					oos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return resul;
	}

	private static ArrayList<Vehiculo> leer() {
		ObjectInputStream objectinputstream = null;
		ArrayList<Vehiculo> readCase = null;
		try {
			FileInputStream streamIn = new FileInputStream(PATH);
			objectinputstream = new ObjectInputStream(streamIn);

			do {
				readCase = (ArrayList<Vehiculo>) objectinputstream.readObject();

			} while (readCase != null);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (objectinputstream != null) {
				try {
					objectinputstream.close();
				} catch (IOException e) {

					e.printStackTrace();
				}
			} // end if

		} // end finally
		vehiculos = readCase;
		return vehiculos;
	}// end leer()
}
