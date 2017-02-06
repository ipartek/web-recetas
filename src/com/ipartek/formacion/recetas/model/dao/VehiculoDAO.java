package com.ipartek.formacion.recetas.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.recetas.ejercicios.herencia.Vehiculo;
import com.ipartek.formacion.recetas.model.DataBaseConnectionImpl;
import com.ipartek.formacion.recetas.model.Persistable;
import com.ipartek.formacion.recetas.pojo.VehiculoException;

public class VehiculoDAO implements Persistable<Vehiculo> {

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
		ArrayList<Vehiculo> list = null;
		// buscamos los ultimos 100 vehiculos por id ordenacion descendiente
		String sql = "SELECT `id`,`modelo`,`plazas`,`potencia` FROM `vehiculo` ORDER BY `id` DESC LIMIT 100";
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			list = new ArrayList<Vehiculo>();
			conn = db.getConexion();			
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()) {			
				list.add(mapear(rs));
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.desconectar();
		}
		return list;
	}

	@Override
	public Vehiculo getById(long id) {
		Vehiculo v = new Vehiculo();
		String sql = "SELECT `id`,`modelo`,`plazas`,`potencia` FROM `vehiculo` WHERE id=?";
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try {
			conn = db.getConexion();			
			pst = conn.prepareStatement(sql);
			pst.setString(1, String.valueOf(id));
			rs = pst.executeQuery();
			while(rs.next()) {			
				v = mapear(rs);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.desconectar();
		}
		
		return v;
	}

	@Override
	public boolean create(Vehiculo v) {
		String sql = "INSERT INTO `vehiculo`(`id`, `modelo`, `plazas`, `potencia`) VALUES (NULL,?,?,?)";
		Boolean resul = false;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try {
			conn = db.getConexion();			
			pst = conn.prepareStatement(sql);
			pst.setString(1, v.getModelo());
			pst.setString(2, String.valueOf(v.getPlazas()));
			pst.setString(3, String.valueOf(v.getPotencia()));
			if (pst.executeUpdate() == 1) {
				resul = true;
			} 

			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.desconectar();
		}
		
		
		return resul;
	}

	@Override
	public boolean update(Vehiculo v) {
		String sql = "UPDATE `vehiculo` SET `modelo`=?,`plazas`=?,`potencia`=? WHERE id = ?";
		Boolean resul = false;
		PreparedStatement pst = null;

		
		try {
			conn = db.getConexion();			
			pst = conn.prepareStatement(sql);
			pst.setString(1, v.getModelo());
			pst.setString(2, String.valueOf(v.getPlazas()));
			pst.setString(3, String.valueOf(v.getPotencia()));
			pst.setString(4, String.valueOf(v.getId()));
			if (pst.executeUpdate() == 1) {
				resul = true;
			} 

			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.desconectar();
		}
		
		
		return resul;
	}

	@Override
	public boolean delete(long id) {
		String sql = "DELETE FROM `vehiculo` WHERE id = ?";
		Boolean resul = false;
		PreparedStatement pst = null;
		
		try {
			conn = db.getConexion();			
			pst = conn.prepareStatement(sql);
			pst.setString(1, String.valueOf(id));
			if (pst.executeUpdate() == 1) {
				resul = true;
			} 

			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.desconectar();
		}
		
		
		return resul;
	}
	
	private Vehiculo mapear(ResultSet rs) throws SQLException, VehiculoException{
		Vehiculo v = new Vehiculo();
		
		v.setId(rs.getLong("id"));
		v.setModelo(rs.getString("modelo"));
		// TODO dimensiones
		v.setPlazas(rs.getInt("plazas"));
		v.setPotencia(rs.getFloat("potencia"));
		
		return v;		
	}

}
