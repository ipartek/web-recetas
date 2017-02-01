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

	// TODO patron Singleton
	// TODO hay que comprobar que el fichero existe, si no existe crearlo
	// TODO PATCH relativo al protecto
	public static final String PATH = "C:\\desarrollo\\workspace\\web-recetas\\data\\vehiculo.txt";
	private static VehiculoServiceObjectStream INSTANCE;
	static File archivo = new File(PATH);
	List<Vehiculo> vehiculos = new ArrayList<Vehiculo>();
	private static long indice = 500;
	private synchronized static void createInstance() {
	    if (INSTANCE == null) { 
	       INSTANCE = new VehiculoServiceObjectStream();
	    }
	}

	public static VehiculoServiceObjectStream getInstance() {
	    if (INSTANCE == null) {
	    	createInstance();
	    	checkExiste();
	    }
	    return INSTANCE;
	}
	
	public static void checkExiste() {
		if (!archivo.exists()) {
			try {

		         // create a new file with an ObjectOutputStream
		         FileOutputStream out = new FileOutputStream(PATH);
		         ObjectOutputStream oout = new ObjectOutputStream(out);
		         // Creamos array
		         ArrayList<Vehiculo> vehiculos = new ArrayList<>();
		 		 vehiculos.add( new Vehiculo("Seat Panda",1));
		 		 vehiculos.add( new Vehiculo("Lamborgini",2));
		 		 vehiculos.add( new Vehiculo("Ford K2",3));
		 		 vehiculos.add( new Vehiculo("Citroen Shara",4));
		 		 vehiculos.add( new Vehiculo("Ferrari",5));
		 		 vehiculos.add( new Vehiculo("Tesla",6));
		         // write something in the file
		         for (Vehiculo v : vehiculos) {
		        	 oout.writeObject(v);
				} 
		         oout.writeObject(null);
		         oout.flush();
		    } catch (Exception ex) {
		         ex.printStackTrace();
		    }
		}
		
	}
	
	@Override
	public List<Vehiculo> getAll() {
		vehiculos.clear();
		try {
			
			ObjectInputStream objIn = new ObjectInputStream(new FileInputStream(PATH));
			Object object;
			while ( (object = objIn.readObject()) != null) {
				
				vehiculos.add((Vehiculo) object);
			       
			}
			objIn.close();
			
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			return vehiculos;
		}
	}

	@Override
	public Vehiculo getById(long id) {
		Vehiculo v1 = null;
		
		try {
			
			ObjectInputStream objIn = new ObjectInputStream(new FileInputStream(PATH));
			Object object;
			while ( (object = objIn.readObject()) != null) {
				v1 = (Vehiculo) object;
				if (v1.getId() == id) {
					
					break;
				}
				
			       
			}
			objIn.close();
			
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			return v1;
		}
	}

	@Override
	public boolean delete(long id) {
		boolean resul = false;
		for(Vehiculo v:vehiculos) {
			if (v.getId()==id) {
				archivo.delete();
				vehiculos.remove(v);
				try {

			         // create a new file with an ObjectOutputStream
					 archivo = new File(PATH);
			         FileOutputStream out = new FileOutputStream(PATH);
			         ObjectOutputStream oout = new ObjectOutputStream(out);
			         // Creamos array
			         for (Vehiculo v1 : vehiculos) {
			        	 oout.writeObject(v1);
					 } 
			         oout.writeObject(null);
			         oout.flush();
			         resul = true;
			         break;
			    } catch (Exception ex) {
			         ex.printStackTrace();
			    }
			}
		}
		return resul;
	}

	@Override
	public boolean update(Vehiculo v) {
		boolean resul = false;
		for(Vehiculo v1:vehiculos) {
			if (v.getId()==v1.getId()) {
				archivo.delete();
				int pos =vehiculos.indexOf(v1);
				vehiculos.remove(v1);
				vehiculos.add(pos, v);
				
				break;
			}
		}
		return escribir(vehiculos);
	


	}

	@Override
	public boolean create(Vehiculo v) {

		v.setId(vehiculos.size()+1);
		archivo.delete();
		vehiculos.add(v);
		
				
		
		return escribir(vehiculos);
	}
	
	private void leer() {
		
	}

	private boolean escribir(List<Vehiculo> aV) {
		boolean resul = false;
		try {
			archivo = new File(PATH);
	        FileOutputStream out = new FileOutputStream(PATH);
	        ObjectOutputStream oout = new ObjectOutputStream(out);
	
	        for (Vehiculo v : aV) {
	        	oout.writeObject(v);
			} 
	        oout.writeObject(null);
	        oout.flush();
	        resul = true;
		} catch (Exception ex) {
	         ex.printStackTrace();
	    } finally{
	    	return resul;
	    }
	}
}
