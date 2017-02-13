package com.ipartek.formacion.recetas.ejercicios.herencia;

import java.io.Serializable;

public interface Conducible extends Serializable, Cloneable {

	final String DERECHA = "giro derecha";
	final String IZQUIERDA = "giro izquierda";

	void arrancar();

	void detener();

	void girar(String direccion);
}
