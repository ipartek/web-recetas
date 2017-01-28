package com.ipartek.formacion.recetas.ejercicios.herencia.pojo;

public class VehiculoDiesel extends Vehiculo {

	//Declaracion
	private static final long serialVersionUID = 1L;
	private float capacidadCombustible =0;
	public final float MIN_CAPACIDAD_COMBUSTIBLE = 70;

	//Constructor
	public VehiculoDiesel() {
		super();
		this.capacidadCombustible = MIN_CAPACIDAD_COMBUSTIBLE;
	}

	//Constructor 1 parametro
	public VehiculoDiesel(String modelo) {
		super(modelo);
		this.capacidadCombustible = MIN_CAPACIDAD_COMBUSTIBLE;
	}

	//Getter &Setter
	public float getCapacidadCombustible() {
		return capacidadCombustible;
	}

	public void setCapacidadCombustible(float capacidadCombustible) {
		this.capacidadCombustible = capacidadCombustible;
	}

	//IConducible
	@Override
	public void arrancar() {
		// super.arrancar();
		System.out.println("arrancado -> Super Velocidad");
	}

	//toString()
	@Override
	public String toString() {
		return "VehiculoDiesel [capacidadCombustible=" + capacidadCombustible + "] extends " + super.toString();
	}
}