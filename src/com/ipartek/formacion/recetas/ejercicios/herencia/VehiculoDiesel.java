package com.ipartek.formacion.recetas.ejercicios.herencia;

public class VehiculoDiesel extends Vehiculo {

	public final float MIN_CAPACIDAD_COMBUSTIBLE = 70;

	private float capacidadCombustible;

	public VehiculoDiesel() {
		super();
		this.capacidadCombustible = MIN_CAPACIDAD_COMBUSTIBLE;
	}

	public VehiculoDiesel(String modelo) {
		super(modelo);
		this.capacidadCombustible = MIN_CAPACIDAD_COMBUSTIBLE;
	}

	public float getCapacidadCombustible() {
		return capacidadCombustible;
	}

	public void setCapacidadCombustible(float capacidadCombustible) {
		this.capacidadCombustible = capacidadCombustible;
	}

	@Override
	public void arrancar() {
		// super.arrancar();
		System.out.println("arrancado -> Super Velocidad");
	}

	@Override
	public String toString() {
		return "VehiculoDiesel [capacidadCombustible=" + capacidadCombustible + "] extends " + super.toString();
	}
}
