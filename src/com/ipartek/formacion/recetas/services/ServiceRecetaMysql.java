package com.ipartek.formacion.recetas.services;

import java.util.List;

import com.ipartek.formacion.recetas.model.dao.RecetaDAO;
import com.ipartek.formacion.recetas.pojo.Receta;

public class ServiceRecetaMysql implements ServiceReceta {

	private static ServiceRecetaMysql INSTANCE;
	private static RecetaDAO daoReceta;

	private ServiceRecetaMysql() {
		daoReceta = RecetaDAO.getInstance();
	}

	private synchronized static void createInstance() {
		if (INSTANCE == null) {
			INSTANCE = new ServiceRecetaMysql();
		}
	}

	public static ServiceRecetaMysql getInstance() {
		if (INSTANCE == null) {
			createInstance();
		}
		return INSTANCE;
	}

	@Override
	public List<Receta> getAll() {
		return daoReceta.getAll();
	}

	@Override
	public Receta getById(long id) {
		return daoReceta.getById(id);
	}

	@Override
	public boolean delete(long id) {
		return daoReceta.delete(id);
	}

	@Override
	public boolean update(Receta r) {
		return daoReceta.update(r);
	}

	@Override
	public boolean create(Receta r) {
		return daoReceta.create(r);
	}

}
