package com.ipartek.formacion.recetas.ejercicios.herencia.pojo;

public class VehiculoElectrico extends Vehiculo {

	//Declaracion
	private static final long serialVersionUID = 1L;
	public final float MIN_CAPACIDAD_BATERIA = 100;
	private float capacidadBaterias;

	
	//Constructor
	public VehiculoElectrico() {
		super();
		this.capacidadBaterias = MIN_CAPACIDAD_BATERIA;
	}

	//Constructor 1 parametro
	public VehiculoElectrico(String modelo) {
		super(modelo);
		this.capacidadBaterias = MIN_CAPACIDAD_BATERIA;
	}

	//Getter & Setter
	public float getCapacidadBaterias() {
		return capacidadBaterias;
	}

	public void setCapacidadBaterias(float capacidadBaterias) {
		this.capacidadBaterias = capacidadBaterias;
	}

	//IConducible
	@Override
	public void arrancar() {
		System.out.println("Bateria enchufada ya toda maquina");
	}

	//toString()
	@Override
	public String toString() {
		return "VehiculoElectrico [capacidadBaterias=" + capacidadBaterias + "] extends " + super.toString();
	}
}