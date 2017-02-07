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
		ArrayList<Receta> list = null;
		//Buscamos los 100 ultimos vehiculos por id descendente
		String sql="SELECT `id`,`nombre`,`imagen`,`tiempo`,`dificultad`,`comensales`,`descripcion` FROM `receta` ORDER BY `id` DESC LIMIT 100";
		PreparedStatement pst = null;
		ResultSet rs = null;
		Receta r = null;
		try{
			list = new ArrayList<Receta>();
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
	public Receta getbyId(long id) {
		Receta r = new Receta();
		String sql = "SELECT `id`,`nombre`,`imagen`,`tiempo`,`dificultad`,`comensales`,`descripcion` FROM `receta` WHERE id=?";
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try {
			conn = db.getConexion();			
			pst = conn.prepareStatement(sql);
			pst.setString(1, String.valueOf(id));
			rs = pst.executeQuery();
			while(rs.next()) {			
				r = mapear(rs);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.desconectar();
		}
		
		return r;
	}


	@Override
	public boolean create(Receta r) {
		String sql = "INSERT INTO `receta`(`id`,`nombre`,`imagen`,`tiempo`,`dificultad`,`comensales`,`descripcion`) VALUES (NULL,?,?,?,?,?,?)";
		Boolean resul = false;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try {
			conn = db.getConexion();			
			pst = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pst.setString(1, r.getTitulo());
			pst.setString(2, r.getImagen());
			pst.setInt(3, r.getTiempo());
			pst.setString(4, r.getDificultad());
			pst.setInt(5, r.getComensales());
			pst.setString(6, r.getDescripcion());
			//insertamos vehiculo
			int affectedRows = pst.executeUpdate();

			if( affectedRows == 1){
				//buscamos el id generado
				ResultSet generatedKeys = pst.getGeneratedKeys();
				if(generatedKeys.next()){
					r.setId(generatedKeys.getLong(1));
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
	public boolean update(Receta r) {
		String sql = "UPDATE `receta` SET `nombre`=?,`imagen`=?,`tiempo`=?,`dificultad`=?,`comensales`=?,`descripcion`=?  WHERE id = ?";
		Boolean resul = false;
		PreparedStatement pst = null;

		
		try {
			conn = db.getConexion();			
			pst = conn.prepareStatement(sql);
			pst.setString(1, r.getTitulo());
			pst.setString(2, r.getImagen());
			pst.setInt(3, r.getTiempo());
			pst.setString(4, r.getDificultad());
			pst.setInt(5, r.getComensales());
			pst.setString(6, r.getDescripcion());
			pst.setString(7, String.valueOf(r.getId()));
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
		String sql = "DELETE FROM `receta` WHERE id = ?";
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

	
	private Receta mapear(ResultSet rs) throws SQLException, VehiculoException{
		Receta r = new Receta();
		
		r.setId(rs.getLong("id"));
		r.setTitulo(rs.getString("nombre"));
		r.setImagen(rs.getString("imagen"));
		r.setTiempo(rs.getInt("tiempo"));
		r.setDificultad(rs.getString("dificultad"));
		r.setComensales(rs.getInt("comensales"));
		r.setDescripcion(rs.getString("descripcion"));
		
		return r;
		
	}



}
