package com.ipartek.formacion.recetas.ejercicios.herencia;

import com.ipartek.formacion.recetas.ejercicios.collection.InterfazEstupida;

public class Vehiculo implements Conducible, InterfazEstupida {

	private long id;
	private String modelo;
	private int plazas;
	private float dimensiones;
	private float potencia;

	public Vehiculo() {
		super();
		this.id = -1;
		this.modelo = "";
		this.plazas = 1;
		this.dimensiones = 0;
		this.potencia = 100;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Vehiculo(String modelo) {
		this();
		this.modelo = modelo;
	}

	public Vehiculo(String modelo, long id) {
		this();
		this.id = id;
		this.modelo = modelo;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) throws VehiculoException {
		if (modelo == "")
			throw new VehiculoException(VehiculoException.MSG_ERROR_MODELO);
		this.modelo = modelo;
	}

	public int getPlazas() {
		return plazas;
	}

	public void setPlazas(int plazas) throws VehiculoException {
		if (plazas < 0) {
			throw new VehiculoException(VehiculoException.MSG_ERROR_PLAZAS);
		} else {

			this.plazas = plazas;
		}
	}

	public float getDimensiones() {
		return dimensiones;
	}

	public void setDimensiones(float dimensiones) {
		this.dimensiones = dimensiones;
	}

	public float getPotencia() {
		return potencia;
	}

	public void setPotencia(float potencia) throws VehiculoException {
		if (potencia < 0) {
			throw new VehiculoException(VehiculoException.MSG_ERROR_POTENCIA);
		}
		this.potencia = potencia;
	}

	@Override
	public void arrancar() {
		System.out.println("Arrancado vehiculo brung brung....");
	}

	/**
	 * Al ser un metodo final, no puede ser sobreescrito por lo hijos
	 */
	@Override
	final public void detener() {
		System.out.println("Estoy parado");
	}

	@Override
	public void girar(String direccion) {
		System.out.println("gira a " + direccion);

	}

	@Override
	public int getPeso() {
		return (int) this.potencia;
	}

	@Override
	public String toString() {
		return "Vehiculo [id=" + id + ", modelo=" + modelo + ", plazas=" + plazas + ", dimensiones=" + dimensiones
				+ ", potencia=" + potencia + "]";
	}

}
