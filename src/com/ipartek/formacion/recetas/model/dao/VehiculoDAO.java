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
import com.mysql.jdbc.Statement;


public class VehiculoDAO implements Persistable<Vehiculo>{
	private static VehiculoDAO INSTANCE = null;
	private static DataBaseConnectionImpl db;
	private Connection conn;
	
	private PreparedStatement pst = null;
	private ResultSet rs = null;
	private static String SQL_DELETE = "DELETE FROM `vehiculo` WHERE `id` = ?";
	private static String SQL_GET_ALL = "SELECT `id`, `modelo`, `plazas`, `potencia` FROM `vehiculo` ORDER BY `id` DESC LIMIT 100";
	private static String SQL_GET_BY_ID = "SELECT `id`, `modelo`, `plazas`, `potencia` FROM `vehiculo` WHERE `id` = ?";
	private static String SQL_UPDATE = "UPDATE `vehiculo` SET `modelo` = ?, `plazas` = ?, `potencia` = ? WHERE `id` = ?";
	private static String SQL_CREATE = "INSERT INTO `vehiculo` (`modelo`, `plazas`, `potencia`) VALUES ( ?, ?, ?)";
	
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
		ArrayList<Vehiculo> vehiculos = null;
		
		try {
			vehiculos = new ArrayList<Vehiculo>();
			
			conn = db.getConexion();
			pst= conn.prepareStatement(SQL_GET_ALL);
			rs = pst.executeQuery();
			while (rs.next()) {
				vehiculos.add(mapear(rs));
						
			}
		} catch (SQLException e) {
			e.printStackTrace();
			
		} catch (VehiculoException e) {
			e.printStackTrace();
			
		}finally{
			db.desconectar();
		}
		return vehiculos;
	}

	@Override
	public Vehiculo getById(long id) {
		Vehiculo v = null;
		
		try {
			conn = db.getConexion();
			pst = conn.prepareStatement(SQL_GET_BY_ID);
			pst.setLong(1, id);
			rs = pst.executeQuery();
			while (rs.next()){
				v = mapear(rs);
			}
					
		} catch (Exception e) {
			e.printStackTrace();
			
		}finally{
			db.desconectar();
			
		}
		return v;
	}

	@Override
	public boolean create(Vehiculo v) {
		boolean resul = false;
		try {
			conn = db.getConexion();
			pst = conn.prepareStatement(SQL_CREATE, Statement.RETURN_GENERATED_KEYS);
			pst.setString(1, v.getModelo());
			pst.setInt(2, v.getPlazas());
			pst.setFloat(3, v.getPotencia());
			
			if (pst.executeUpdate() == 1) {
				rs = pst.getGeneratedKeys();
				if (rs.next()) {
					v.setId(rs.getLong("id"));
					resul = true;
				}
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}finally{
			db.desconectar();
		}
		return resul;
	}

	@Override
	public boolean update(Vehiculo v) {
		boolean resul = false;
		try {
			conn = db.getConexion();
			pst = conn.prepareStatement(SQL_UPDATE);
			pst.setString(1, v.getModelo());
			pst.setInt(2, v.getPlazas());
			pst.setFloat(3, v.getPotencia());
			pst.setLong(4, v.getId());
			
			if( pst.executeUpdate() == 1 ){
				resul= true;
			}

			
		} catch (Exception e) {
			e.printStackTrace();
			
		}finally{
			db.desconectar();
		}
		return resul;
	}

	@Override
	public boolean delete(long id) {
		boolean resul = false;
		try {
			conn = db.getConexion();
			pst = conn.prepareStatement(SQL_DELETE);
			pst.setLong(1, id);
			if( pst.executeUpdate() == 1 ){
				resul= true;
			}

			
		} catch (Exception e) {
			e.printStackTrace();
			
		}finally{
			db.desconectar();
		}
		return resul;
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
