package com.ipartek.formacion.recetas.services;

import java.util.List;

import com.ipartek.formacion.recetas.ejercicios.herencia.Vehiculo;
import com.ipartek.formacion.recetas.pojo.Receta;

public interface ServiceReceta {
	
	List<Receta> getAll();
	
	Receta getById(long id);
	
	boolean delete(long id);
	
	boolean update(Receta r);
	
	boolean create(Receta r);

}
