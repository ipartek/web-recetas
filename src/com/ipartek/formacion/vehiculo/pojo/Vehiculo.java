package com.ipartek.formacion.vehiculo.pojo;

import com.ipartek.formacion.recetas.ejercicios.collection.InterfazEstupida;
import com.ipartek.formacion.recetas.ejercicios.herencia.Conducible;

public class Vehiculo implements Conducible, InterfazEstupida {

	private String modelo;
	private int plazas;
	private float dimensiones;
	private float potencia;
	private long id;

	public Vehiculo() {
		super();
		this.modelo = "";
		this.plazas = 1;
		this.dimensiones = 0;
		this.potencia = 100;
		this.id = -1;
	}

	public Vehiculo(String modelo) {
		this();
		this.modelo = modelo;
	}

	public Vehiculo(String modelo, long id) {
		super();
		this.modelo = modelo;
		this.id = id;
	}

	boolean isNew() {
		return (this.id == -1) ? true : false;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getPlazas() {
		return plazas;
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

	public void setPotencia(float potencia) {
		this.potencia = potencia;
	}

	@Override
	public String toString() {
		return "Vehiculo [modelo=" + modelo + ", plazas=" + plazas + ", dimensiones=" + dimensiones + ", potencia="
				+ potencia + ", id=" + id + "]";
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

	public void setPlazas(int plazas) throws VehiculoException {
		if (plazas < 0) {
			throw new VehiculoException(VehiculoException.MSG_ERROR_PLAZAS);
		} else {
			this.plazas = plazas;
		}
	}
}