package com.ipartek.formacion.recetas.ejercicios.herencia;

import java.util.ArrayList;

/**
 * Listar todos los Vehiculos del concesionario
 * 
 * @author ur00
 *
 */
public class EjercicioConcesionario {

	public static void main(String[] args) {

		Vehiculo v1 = new Vehiculo("Prius");
		Vehiculo v2 = new Vehiculo("Ibiza");
		Vehiculo v3 = new Vehiculo("Ford Fiesta");
		v1.setPlazas(5);
		v1.setPotencia(300);

		v2.setPlazas(5);
		v2.setPotencia(500);

		v3.setPlazas(4);
		v3.setPotencia(100);

		VehiculoElectrico ve1 = new VehiculoElectrico("Tesla");
		ve1.setPlazas(5);
		ve1.setPotencia(150);
		ve1.setCapacidadBaterias(500);

		VehiculoDiesel vd1 = new VehiculoDiesel("Citroen Sara");
		VehiculoDiesel vd2 = new VehiculoDiesel("Opel Astra");
		vd1.setPlazas(5);
		vd1.setPotencia(100);
		vd1.setCapacidadCombustible(95);

		vd2.setPlazas(5);
		vd2.setPotencia(120);
		vd2.setCapacidadCombustible(98);

		ArrayList<Vehiculo> stock = new ArrayList<Vehiculo>();
		stock.add(v1);
		stock.add(v2);
		stock.add(v3);
		stock.add(ve1);
		stock.add(vd1);
		stock.add(vd2);

		// mostrar por pantalla
		for (Vehiculo vehiculo : stock) {
			System.out.println();
			System.out.println("---------------------------------");
			System.out.println(vehiculo.getModelo());
			System.out.println("---------------------------------");
			System.out.println("Plazas: " + vehiculo.getPlazas());
			System.out.println("Potencia: " + vehiculo.getPotencia());

			if (vehiculo instanceof VehiculoElectrico) {
				System.out.println("Capacidad bateria: " + ((VehiculoElectrico) vehiculo).getCapacidadBaterias());

			} else if (vehiculo instanceof VehiculoDiesel) {
				System.out.println("Combustible: " + ((VehiculoDiesel) vehiculo).getCapacidadCombustible());
			}

		}

	}

}
