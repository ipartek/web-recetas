package com.ipartek.formacion.recetas.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
	
	private static String SQL_GET_ALL = "SELECT `id`,`modelo`,`plazas`,`potencia`,`dimensiones` FROM `vehiculo` ORDER BY `id` DESC LIMIT 100";
	private static String SQL_GET_BY_ID = "SELECT `id`,`modelo`,`plazas`,`potencia`,`dimensiones` FROM `vehiculo` WHERE id=?";
	private static String SQL_CREATE = "INSERT INTO `vehiculo`(`id`, `modelo`, `plazas`, `potencia`, `dimensiones`) VALUES (NULL,?,?,?,?)";
	private static String SQL_UPDATE = "UPDATE `vehiculo` SET `modelo`=?,`plazas`=?,`potencia`=?,`dimensiones`=? WHERE id = ?";
	private static String SQL_DELETE = "DELETE FROM `vehiculo` WHERE id = ?";
	
	
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
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			list = new ArrayList<Vehiculo>();
			conn = db.getConexion();			
			pst = conn.prepareStatement(SQL_GET_ALL);
			rs = pst.executeQuery();
			while(rs.next()) {			
				list.add(mapear(rs));
			}			
			rs.close();
			pst.close();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {			
			db.desconectar();
		}
		return list;
	}

	@Override
	public Vehiculo getById(long id) {
		Vehiculo v = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try {
			conn = db.getConexion();			
			pst = conn.prepareStatement(SQL_GET_BY_ID);
			pst.setLong(1, id);
			rs = pst.executeQuery();
			while(rs.next()) {			
				v = mapear(rs);
			}			
			rs.close();
			pst.close();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {			
			db.desconectar();
		}
		
		return v;
	}

	@Override
	public boolean create(Vehiculo v) {
		Boolean resul = false;
		PreparedStatement pst = null;
		ResultSet conseguirId = null;
		try {
			conn = db.getConexion();			
			pst = conn.prepareStatement(SQL_CREATE,Statement.RETURN_GENERATED_KEYS);
			pst.setString(1, v.getModelo());
			pst.setInt(2, v.getPlazas());
			pst.setFloat(3, v.getPotencia());
			pst.setFloat(4, v.getDimensiones());
			if (pst.executeUpdate() == 1) {
				resul = true;
				conseguirId = pst.getGeneratedKeys();
				if ( conseguirId.next()) {
					//Buscamos la ID en la columna 1
					v.setId(conseguirId.getLong(1));
				}
			} 
			
			pst.close();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {			
			db.desconectar();
		}
		
		
		return resul;
	}

	@Override
	public boolean update(Vehiculo v) {
		Boolean resul = false;
		PreparedStatement pst = null;

		
		try {
			conn = db.getConexion();			
			pst = conn.prepareStatement(SQL_UPDATE);
			pst.setString(1, v.getModelo());
			pst.setInt(2, v.getPlazas());
			pst.setFloat(3, v.getPotencia());
			pst.setFloat(4, v.getDimensiones());
			pst.setLong(5, v.getId());
			if (pst.executeUpdate() == 1) {
				resul = true;
			} 
			pst.close();	
		} catch(Exception e) {
			e.printStackTrace();
		} finally {		
			db.desconectar();
		}
		
		
		return resul;
	}

	@Override
	public boolean delete(long id) {
		Boolean resul = false;
		PreparedStatement pst = null;
		
		try {
			conn = db.getConexion();			
			pst = conn.prepareStatement(SQL_DELETE);
			pst.setLong(1, id);
			if (pst.executeUpdate() == 1) {
				resul = true;
			} 
			pst.close();;
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
		v.setDimensiones(rs.getFloat("dimensiones"));
		v.setPlazas(rs.getInt("plazas"));
		v.setPotencia(rs.getFloat("potencia"));
		
		return v;		
	}

}
