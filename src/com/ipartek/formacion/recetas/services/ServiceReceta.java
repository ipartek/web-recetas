package com.ipartek.formacion.recetas.services;

import java.util.List;

import com.ipartek.formacion.recetas.model.dao.RecetaDAO;
import com.ipartek.formacion.recetas.pojo.Receta;

public class ServiceReceta {
	private static ServiceReceta INSTANCE = null;
	private static RecetaDAO daoReceta;
	// Simular indice

	// Private constructor suppresses
	private ServiceReceta() {

		daoReceta = RecetaDAO.getInstance();

	}

	// creador sincronizado para protegerse de posibles problemas multi-hilo
	// otra prueba para evitar instanciación múltiple
	private synchronized static void createInstance() {
		if (INSTANCE == null) {
			INSTANCE = new ServiceReceta();
		}
	}

	public static ServiceReceta getInstance() {
		if (INSTANCE == null) {
			createInstance();
		}
		return INSTANCE;
	}

	public List<Receta> getAll() {

		return daoReceta.getAll();

	}

	public Receta getById(long id) {

		return daoReceta.getByID(id);
	}

	public boolean delete(long id) {

		return daoReceta.delete(id);
	}

	public boolean update(Receta vMod) {

		return daoReceta.update(vMod);
	}

	public boolean create(Receta v) {

		return daoReceta.create(v);
	}

}
