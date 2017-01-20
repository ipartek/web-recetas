package com.ipartek.formacion.recetas.ejercicios.herencia;

import java.util.ArrayList;

import com.ipartek.formacion.recetas.pojo.Ingrediente;

public interface Cocinable {

	ArrayList<Ingrediente> getIngredientes();

	String getDescripcionReceta();

}
