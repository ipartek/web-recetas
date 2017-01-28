package com.ipartek.formacion.recetas.ejercicios.herencia;

import java.util.ArrayList;

import com.ipartek.formacion.recetas.ejercicios.exception.VehiculoException;
import com.ipartek.formacion.recetas.ejercicios.herencia.pojo.Vehiculo;
import com.ipartek.formacion.recetas.ejercicios.herencia.pojo.VehiculoDiesel;
import com.ipartek.formacion.recetas.ejercicios.herencia.pojo.VehiculoElectrico;

public class EjercicioVehiculos {

	public static void main(String[] args) throws VehiculoException {

		//Declaracion
		Vehiculo v1;
		Vehiculo v2;
		Vehiculo v3;
		VehiculoElectrico ve1;
		VehiculoDiesel vd1;
		VehiculoDiesel vd2;
		ArrayList<Vehiculo> vehiculos;
		
		//Instanciar y asignar
		v1 = new Vehiculo("Prius");
		v2 = new Vehiculo("Ibiza");
		v3 = new Vehiculo("Ford Fiesta");
		v1.setPlazas(5);
		v2.setPlazas(5);
		v3.setPlazas(4);
		v1.setPotencia(300);
		v2.setPotencia(500);
		v3.setPotencia(100);
		vd1 = new VehiculoDiesel("Citroen Sara");
		vd2 = new VehiculoDiesel("Opel Astra");
		vd1.setPlazas(5);
		vd2.setPlazas(5);
		vd1.setPotencia(100);
		vd2.setPotencia(120);
		vd1.setCapacidadCombustible(95);
		vd2.setCapacidadCombustible(98);
		ve1 = new VehiculoElectrico("Tesla");
		ve1.setPlazas(5);
		ve1.setPotencia(150);
		ve1.setCapacidadBaterias(500);

		//Añadir a ArrayList()
		vehiculos = new ArrayList<Vehiculo>();
		vehiculos.add(v1);
		vehiculos.add(v2);
		vehiculos.add(v3);
		vehiculos.add(ve1);
		vehiculos.add(vd1);
		vehiculos.add(vd2);

		//Syso
		for (Vehiculo v : vehiculos) {
			System.out.println();
			System.out.println("---------------------------------");
			System.out.println(v.getModelo());
			System.out.println("---------------------------------");
			System.out.println("Plazas: " + v.getPlazas());
			System.out.println("Potencia: " + v.getPotencia());

			//VehiculoElectrico
			if (v instanceof VehiculoElectrico) {
				System.out.println("Capacidad bateria: " + ((VehiculoElectrico) v).getCapacidadBaterias());

			//Vehiculo diesel
			} else if (v instanceof VehiculoDiesel) {
				System.out.println("Combustible: " + ((VehiculoDiesel) v).getCapacidadCombustible());
			}
		}
	}
}
