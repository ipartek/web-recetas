package com.ipartek.formacion.recetas.ejercicios.herencia.pojo;

import com.ipartek.formacion.recetas.ejercicios.comparator.IComparator;
import com.ipartek.formacion.recetas.ejercicios.exception.VehiculoException;
import com.ipartek.formacion.recetas.ejercicios.herencia.IConducible;

public class Vehiculo implements IConducible, IComparator {

	//Declaracion
	private static final long serialVersionUID = 1L;
	private long id;
	private String modelo;
	private int plazas;
	private float dimensiones;
	private float potencia;

	//Constructor
	public Vehiculo() {
		super();
		this.id = -1;
		this.modelo = "";
		this.plazas = 1;
		this.dimensiones = 0;
		this.potencia = 100;
	}

	//Constructor con 1 parametro
	public Vehiculo(String modelo) {
		this();
		this.modelo = modelo;
	}

	//Constructor con 2 parametros
	public Vehiculo(String modelo, long id) {
		this();
		this.id = id;
		this.modelo = modelo;
	}

	//Getter & Setter
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

	//VehiculoException
	public void setPlazas(int plazas) throws VehiculoException {

		if (plazas < 0) {
			//Instancia y lanza la CustomException
			throw new VehiculoException(VehiculoException.MSG_ERROR_PLAZAS);
		
		} else {
			this.plazas = plazas;
		}
	}

	public float getDimensiones() {
		return dimensiones;
	}

	public void setDimensiones(float dimensiones) throws VehiculoException {
		if (dimensiones < 0) {
			throw new VehiculoException(VehiculoException.MSG_ERROR_DIMENSIONES);
		} else {

			this.dimensiones = dimensiones;
		}
	}

	public float getPotencia() {
		return potencia;
	}

	public void setPotencia(float potencia) throws VehiculoException {
		if (potencia < 0) {
			throw new VehiculoException(VehiculoException.MSG_ERROR_POTENCIA);
		} else {

			this.potencia = potencia;
		}
	}

	//IConducible
	@Override
	public void arrancar() {
		System.out.println("Arrancado vehiculo brung brung....");
	}

	@Override
	final public void detener() {
		System.out.println("Estoy parado");
	}

	@Override
	public void girar(String direccion) {
		System.out.println("gira a " + direccion);

	}

	//IComprobator
	@Override
	public int getPeso() {
		return (int) this.potencia;
	}
	
	//toString()
		@Override
		public String toString() {
			return "Vehiculo [id=" + id + ", modelo=" + modelo + ", plazas=" + plazas + ", dimensiones=" + dimensiones
					+ ", potencia=" + potencia + "]";
		}
}