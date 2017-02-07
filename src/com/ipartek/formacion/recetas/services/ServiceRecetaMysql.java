package com.ipartek.formacion.recetas.services;

import java.util.List;

import com.ipartek.formacion.recetas.model.dao.RecetaDAO;
import com.ipartek.formacion.recetas.pojo.Receta;

public class ServiceRecetaMysql {
	private static ServiceRecetaMysql INSTANCE;
	private static RecetaDAO daoReceta;

	private ServiceRecetaMysql() {
		daoReceta = RecetaDAO.getInstance();

	}

	public static RecetaDAO getDaoReceta() {
		return daoReceta;
	}

	public static void setDaoReceta(RecetaDAO daoReceta) {
		ServiceRecetaMysql.daoReceta = daoReceta;
	}

	public static ServiceRecetaMysql getInstance() {
		if (INSTANCE == null) {
			createInstance();
		}
		return INSTANCE;
	}

	private synchronized static void createInstance() {
		if (INSTANCE == null) {
			INSTANCE = new ServiceRecetaMysql();
		}
	}

	public List<Receta> getAll() {
		return daoReceta.getAll();
	}

	public Receta getById(int id) {
		// TODO Auto-generated method stub
		return daoReceta.getById(id);
	}

	public boolean delete(int id) {
		return daoReceta.delete(id);
	}

	public boolean update(Receta r) {
		// TODO Auto-generated method stub
		return daoReceta.update(r);
	}

	public boolean create(Receta r) {
		// TODO Auto-generated method stub
		return daoReceta.create(r);
	}

}
