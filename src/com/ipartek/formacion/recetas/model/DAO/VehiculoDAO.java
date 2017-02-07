package com.ipartek.formacion.recetas.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.recetas.ejercicios.herencia.Vehiculo;
import com.ipartek.formacion.recetas.ejercicios.herencia.VehiculoException;
import com.ipartek.formacion.recetas.model.DataBaseConnectionImpl;
import com.ipartek.formacion.recetas.model.Persistable;

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
		//Buscamos los 100 ultimos vehiculos por id descendente
		String sql="SELECT `id`,`modelo`,`plazas`,`potencia`,`dimensiones` FROM `vehiculo` ORDER BY `id` DESC LIMIT 100";
		PreparedStatement pst = null;
		ResultSet rs = null;
		Vehiculo v = null;
		try{
			list = new ArrayList<Vehiculo>();
			conn = db.getConexion();
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()){
				list.add(mapear(rs));
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			db.desconectar();
			
		}
		return list;
	}

	@Override
	public Vehiculo getbyId(long id) {
		Vehiculo v = new Vehiculo();
		String sql = "SELECT `id`,`modelo`,`plazas`,`potencia`,`dimensiones` FROM `vehiculo` WHERE id=?";
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
		String sql = "INSERT INTO `vehiculo`(`id`, `modelo`, `plazas`, `potencia`,`dimensiones`) VALUES (NULL,?,?,?,?)";
		Boolean resul = false;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try {
			conn = db.getConexion();			
			pst = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pst.setString(1, v.getModelo());
			pst.setString(2, String.valueOf(v.getPlazas()));
			pst.setString(3, String.valueOf(v.getPotencia()));
			pst.setString(4, String.valueOf(v.getDimensiones()));
			//insertamos vehiculo
			int affectedRows = pst.executeUpdate();

			if( affectedRows == 1){
				//buscamos el id generado
				ResultSet generatedKeys = pst.getGeneratedKeys();
				if(generatedKeys.next()){
					v.setId(generatedKeys.getLong(1));
					resul = true;
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
		String sql = "UPDATE `vehiculo` SET `modelo`=?,`plazas`=?,`potencia`=?,`dimensiones`=? WHERE id = ?";
		Boolean resul = false;
		PreparedStatement pst = null;

		
		try {
			conn = db.getConexion();			
			pst = conn.prepareStatement(sql);
			pst.setString(1, v.getModelo());
			pst.setString(2, String.valueOf(v.getPlazas()));
			pst.setString(3, String.valueOf(v.getPotencia()));
			pst.setString(4, String.valueOf(v.getDimensiones()));
			pst.setString(5, String.valueOf(v.getId()));
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
		v.setPlazas(rs.getInt("plazas"));
		v.setPotencia(rs.getFloat("potencia"));
		v.setDimensiones(rs.getFloat("dimensiones"));
		
		return v;
		
	}
}
