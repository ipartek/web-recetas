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
	private static long indice = 500;

	private File fichero = new File(PATH);

	// Constructor
	private VehiculoServiceObjectStream() {

		if (fichero.exists()) {
				leerArchivo();
				
		} else {
				vehiculos = new ArrayList<>();
				vehiculos.add(new Vehiculo("Seat Panda", 4));
				vehiculos.add(new Vehiculo("Lamborghini", 2));
				vehiculos.add(new Vehiculo("Ford K2", 1));
				vehiculos.add(new Vehiculo("Citroen Xsara", 12));
				vehiculos.add(new Vehiculo("Ferrari", 500));
				vehiculos.add(new Vehiculo("Tesla", 23));
				guardarArchivo(vehiculos);

		}

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

	// ServiceVehiculo
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
		guardarArchivo(vehiculos);
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
		guardarArchivo(vehiculos);
		return resul;
	}

	@Override
	public boolean create(Vehiculo v) {
		boolean resul = false;
		v.setId(++indice);

		if (vehiculos.add(v)) {
			resul = true;
		} else {
			resul = false;
		}
		guardarArchivo(vehiculos);
		return resul;
	}

	// Metodos
	private void guardarArchivo(List<Vehiculo> vehiculos) {
		try {
			FileOutputStream fon = new FileOutputStream(PATH);
			ObjectOutputStream oos = new ObjectOutputStream(fon);
			
			oos.writeObject(vehiculos);
			
			oos.close();
			fon.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private List<Vehiculo> leerArchivo() {
		try {
			FileInputStream fin = new FileInputStream(PATH);
			ObjectInputStream ois = new ObjectInputStream(fin);

			vehiculos = (ArrayList<Vehiculo>) ois.readObject();

			ois.close();
			fin.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	return vehiculos;
	}

}
