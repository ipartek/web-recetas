package com.ipartek.formacion.recetas.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.recetas.ejercicios.herencia.pojo.Vehiculo;
import com.ipartek.formacion.recetas.model.DataBaseConnectionImpl;
import com.ipartek.formacion.recetas.model.Persistable;
import com.ipartek.formacion.recetas.pojo.Receta;

public class RecetaDAO implements Persistable<Receta> {
	private static RecetaDAO INSTANCE = null;
	private static DataBaseConnectionImpl db;
	private Connection conn;
	
	private RecetaDAO() {
		db = DataBaseConnectionImpl.getInstance();
	}

	public static RecetaDAO getInstance() {
		if (INSTANCE == null) {
			createInstance();
		}
		return INSTANCE;
	}

	private synchronized static void createInstance() {
		if (INSTANCE == null) {
			INSTANCE = new RecetaDAO();
		}
	}
	@Override
	public List<Receta> getAll() {
		String sql = "";
		PreparedStatement pst = null;
		ResultSet rs = null;
		Vehiculo v = null;
		ArrayList<Receta> recetas = null;
		
		try {
			sql = "SELECT `nombre` FROM `receta` ORDER BY `id` DESC LIMIT 100";
			recetas = new ArrayList<Receta>();
			
			conn = db.getConexion();
			pst= conn.prepareStatement(sql);
			rs = pst.executeQuery();
			
			while (rs.next()) {
				recetas.add(mapear(rs));
						
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		
		}finally{
			db.desconectar();
		}
		return recetas;
	}

	@Override
	public Receta getById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean create(Receta objeto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Receta objeto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(long id) {
		// TODO Auto-generated method stub
		return false;
	}

	private Receta mapear (ResultSet rs) throws SQLException  {
		Receta r = new Receta();
		
		r.setTitulo(rs.getString("nombre"));
		
		return r;
	}
}
