package com.ipartek.formacion.recetas.model.DAO;

import java.util.List;

import com.ipartek.formacion.recetas.model.Persistable;
import com.ipartek.formacion.recetas.pojo.Usuario;

public class UsuarioDAO implements Persistable<Usuario> {
	
	static final private String SQL_GET_ALL = "SELECT `id`,`nombre`,`apellido1`,`apelido2`,`edad`,`email`,`dni`,`puesto`,`password`,`imagen` FROM `usuario` ORDER BY `id` DESC LIMIT 500";
	static final private String SQL_GET_BY_ID = "SELECT `id`,`nombre`,`apellido1`,`apelido2`,`edad`,`email`,`dni`,`puesto`,`password`,`imagen` FROM `usuario` WHERE `id`=?";
	static final private String SQL_GET_BY_EMAIL = "SELECT `id`,`nombre`,`apellido1`,`apelido2`,`edad`,`email`,`dni`,`puesto`,`password`,`imagen` FROM `usuario` WHERE `email`=?";
	static final private String SQL_COUNT = "SELECT COUNT(`id`) FROM `usuario`";
	@Override
	public List<Usuario> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario getbyId(long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Usuario getbyEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean create(Usuario objeto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Usuario objeto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(long id) {
		// TODO Auto-generated method stub
		return false;
	}
	
	Usuario existe(String email, String password) {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * Cuenta los usuarios totales de la tabla
	 * @return <code>int</code> numero entero de registros
	 */
	int countUsers(){
		return 0;
		
	}

}
