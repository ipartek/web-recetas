package com.ipartek.formacion.recetas.ejercicios.herencia;
/** Interfaz para demostrar herencia*/
import java.util.ArrayList;

import com.ipartek.formacion.recetas.pojo.Ingrediente;

public interface ICocinable {

	ArrayList<Ingrediente> getIngredientes();

	String getDescripcionReceta();

}
