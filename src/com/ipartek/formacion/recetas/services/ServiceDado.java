package com.ipartek.formacion.recetas.services;

import java.util.List;

import com.ipartek.formacion.recetas.pojo.DadoAlumno;

public interface ServiceDado {

	List<DadoAlumno> getAll();

	DadoAlumno getById(long id);

	// boolean create (DadoAlumno d);

	// boolean update (DadoAlumno d);

	// boolean delete (long id);
}
