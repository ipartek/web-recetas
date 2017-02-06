package com.ipartek.formacion.recetas.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.recetas.ejercicios.exception.VehiculoException;
import com.ipartek.formacion.recetas.ejercicios.herencia.pojo.Vehiculo;
import com.ipartek.formacion.recetas.model.DataBaseConnectionImpl;
import com.ipartek.formacion.recetas.model.Persistable;


public class VehiculoDAO implements Persistable<Vehiculo>{
	private static VehiculoDAO INSTANCE = null;
	private static DataBaseConnectionImpl db;
	private Connection conn;
	
	private VehiculoDAO() {
		db = DataBaseConnectionImpl.getInstance();
	}

	public static VehiculoDAO getInstance() {
		if (INSTANCE == null) {
			createInstance();
		}
		return INSTANCE;
	}

	private synchronized static void createInstance() {
		if (INSTANCE == null) {
			INSTANCE = new VehiculoDAO();
		}
	}

	@Override
	public List<Vehiculo> getAll() {
		String sql = "";
		PreparedStatement pst = null;
		ResultSet rs = null;
		ArrayList<Vehiculo> vehiculos = null;
		
		try {
			sql = "SELECT `id`, `modelo`, `plazas`, `potencia` FROM `vehiculo` ORDER BY `id` DESC LIMIT 100";
			vehiculos = new ArrayList<Vehiculo>();
			
			conn = db.getConexion();
			pst= conn.prepareStatement(sql);
			rs = pst.executeQuery();
			
			while (rs.next()) {
				vehiculos.add(mapear(rs));
						
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
			
		} catch (VehiculoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}finally{
			db.desconectar();
		}
		return vehiculos;
	}

	@Override
	public Vehiculo getById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean create(Vehiculo objeto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Vehiculo objeto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(long id) {
		// TODO Auto-generated method stub
		return false;
	}
	
	private Vehiculo mapear (ResultSet rs) throws SQLException, VehiculoException{
		Vehiculo v = new Vehiculo();
		
		v.setId(rs.getLong("id"));
		v.setModelo(rs.getString("modelo"));
		//v.setDimensiones(rs.getInt("dimensiones"));
		v.setPlazas(rs.getInt("Plazas"));
		v.setPotencia(rs.getFloat("potencia"));
		
		return v;
	}

}
