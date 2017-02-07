package com.ipartek.formacion.recetas.services;

import java.util.List;

import com.ipartek.formacion.recetas.model.DAO.RecetaDAO;
import com.ipartek.formacion.recetas.model.DAO.VehiculoDAO;
import com.ipartek.formacion.recetas.pojo.Receta;

public class ServiceRecetasMysql implements ServiceReceta {

	private static ServiceRecetasMysql INSTANCE;
	private static RecetaDAO daoReceta;
	
	private ServiceRecetasMysql(){
		daoReceta = RecetaDAO.getInstance();
	}
	
	public static ServiceRecetasMysql getInstance() {
		if (INSTANCE == null) {
			createInstance();
		}
		return INSTANCE;
	}

	private synchronized static void createInstance() {
		if (INSTANCE == null) {
			INSTANCE = new ServiceRecetasMysql();
		}
	}
	
	@Override
	public List<Receta> getAll() {
		
		return daoReceta.getAll();
	}

	@Override
	public Receta getById(long id) {
		return daoReceta.getbyId(id);
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
