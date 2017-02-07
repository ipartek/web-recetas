package com.ipartek.formacion.recetas.services;

import java.util.List;

import com.ipartek.formacion.recetas.model.dao.RecetaDAO;
import com.ipartek.formacion.recetas.pojo.Receta;

public class ServiceRecetaMySql implements ServiceReceta {

	private static ServiceRecetaMySql INSTANCE;
	private static RecetaDAO daoReceta;
	
	private ServiceRecetaMySql(){
		daoReceta = RecetaDAO.getInstance();
	}
	
	private synchronized static void createInstance(){
		if (INSTANCE == null){
			INSTANCE = new ServiceRecetaMySql();
		}		
	}
	
	public static ServiceRecetaMySql getInstance() {
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
