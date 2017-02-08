package com.ipartek.formacion.recetas.model.dao;

import java.util.List;

import com.ipartek.formacion.recetas.model.Persistable;
import com.ipartek.formacion.recetas.pojo.Usuario;

public class UsuarioDAO implements Persistable<Usuario>{
	
	private static final String SQL_GET_ALL = "SELECT `id`, `nombre`, `apellido1`, `apellido2`, `edad`, `email`, `dni`,`puesto`, `password`, `imagen` FROM `usuario` ORDER BY `id` DESC LIMIT 500;";
	private static final String SQL_BY_ID = "SELECT `id`, `nombre`, `apellido1`, `apellido2`, `edad`, `email`, `dni`,`puesto`, `password`, `imagen` FROM `usuario` WHERE `id` = ?;";
	private static final String SQL_BY_EMAIL = "SELECT `id`, `nombre`, `apellido1`, `apellido2`, `edad`, `email`, `dni`,`puesto`, `password`, `imagen` FROM `usuario` WHERE `email` = ?;";
	private static final String SQL_COUNT = "SELECT COUNT(`id`) FROM `usuario`;";
	private static final String SQL_DELETE = "DELETE FROM `usuario` WHERE `id` = ?";
	private static final String SQL_UPDATE = "UPDATE `usuario` SET `nombre` = ?, `apellido1` = ?, `apellido2` = ?, `edad`, = ? `email` = ?, `dni` = ?,`puesto` = ?, `password` = ?, `imagen` = ? WHERE `id` = ? ;";
	private static final String SQL_CREATE = "INSERT INTO `usuario` (`nombre`, `apellido1`, `apellido2`, `edad`, `email`, `dni`,`puesto`, `password`, `imagen`) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?);";
	
	
	@Override
	public List<Usuario> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario getById(long id) {
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
	
	public Usuario getByEmail(long id) {
		return null;
	}
	
	Usuario existe(String email, String password){
		return null;
		
	}
	
	/**
	 * Cuenta los usuarios totales de la tabla
	 * @return int numero de registros
	 */
	int count(){
		return 0;
		
	}

}
