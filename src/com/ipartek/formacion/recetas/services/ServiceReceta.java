package com.ipartek.formacion.recetas.services;

import java.util.List;

import com.ipartek.formacion.recetas.model.dao.RecetaDAO;
import com.ipartek.formacion.recetas.pojo.Receta;

public class ServiceReceta {

	private static ServiceReceta INSTANCE;
	private static RecetaDAO daoReceta;
	
	private ServiceReceta() {
		daoReceta = RecetaDAO.getInstance();
	}

	public static ServiceReceta getInstance() {
		if (INSTANCE == null) {
			createInstance();
		}
		return INSTANCE;
	}

	private synchronized static void createInstance() {
		if (INSTANCE == null) {
			INSTANCE = new ServiceReceta();
		}
	}
	public List<Receta> getAll() {
		return daoReceta.getAll();}
	
}
