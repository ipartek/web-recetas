package com.ipartek.formacion.recetas.model.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.recetas.model.DataBaseConnectionImpl;
import com.ipartek.formacion.recetas.model.Persistable;
import com.ipartek.formacion.recetas.pojo.Receta;

public class RecetaDAO implements Persistable<Receta> {

	private static RecetaDAO INSTANCE = null;
	private static DataBaseConnectionImpl db;
	private Connection conn;
	
	private static String SQL_GET_ALL = "SELECT `id`,`nombre`,`imagen`,`tiempo`,`dificultad`,`comensales`,`descripcion` FROM `receta` ORDER BY `id` DESC LIMIT 100";
	private static String SQL_GET_BY_ID = "SELECT `id`,`nombre`,`imagen`,`tiempo`,`dificultad`,`comensales`,`descripcion` FROM `receta` WHERE id=?";
	private static String SQL_CREATE = "INSERT INTO `receta`(`id`,`nombre`,`imagen`,`tiempo`,`dificultad`,`comensales`,`descripcion`) VALUES (NULL,?,?,?,?,?,?)";
	private static String SQL_UPDATE = "UPDATE `receta` SET `nombre`=?,`imagen`=?,`tiempo`=?,`dificultad`=?,`comensales`=?,`descripcion`=? WHERE id = ?";
	private static String SQL_DELETE = "DELETE FROM `receta` WHERE id = ?";
	
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
		// buscamos los ultimos 100 vehiculos por id ordenacion descendiente
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			list = new ArrayList<Receta>();
			conn = db.getConexion();			
			pst = conn.prepareStatement(SQL_GET_ALL);
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
	public Receta getById(long id) {
		Receta v = new Receta();
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
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.desconectar();
		}
		
		return v;
	}

	@Override
	public boolean create(Receta r) {
		Boolean resul = false;
		PreparedStatement pst = null;
		ResultSet conseguirId = null; 
		try {
			conn = db.getConexion();			
			pst = conn.prepareStatement(SQL_CREATE,Statement.RETURN_GENERATED_KEYS);
			pst.setString(1, r.getTitulo());
			pst.setString(2, r.getImagen());
			pst.setInt(3, r.getTiempo());
			pst.setString(4, r.getDificultad());
			pst.setInt(5, r.getComensales());
			pst.setString(6, r.getDescripcion());
			
			if (pst.executeUpdate() == 1) {
				resul = true;
				conseguirId = pst.getGeneratedKeys();
				if ( conseguirId.next()) {
					//Buscamos la ID en la columna 1
					r.setId(conseguirId.getLong(1));
				}
			} 			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.desconectar();
		}
		
		
		return resul;
	}

	@Override
	public boolean update(Receta r) {
		Boolean resul = false;
		PreparedStatement pst = null;

		
		try {
			conn = db.getConexion();			
			pst = conn.prepareStatement(SQL_UPDATE);
			pst.setString(1, r.getTitulo());
			pst.setString(2, r.getImagen());
			pst.setInt(3, r.getTiempo());
			pst.setString(4, r.getDificultad());
			pst.setInt(5, r.getComensales());
			pst.setString(6, r.getDescripcion());
			pst.setLong(7, r.getId());
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
	
	private Receta mapear(ResultSet rs) throws SQLException{
		Receta r = new Receta();
		
		r.setId(rs.getLong("id"));
		r.setTitulo(rs.getString("nombre"));
		r.setImagen(rs.getString("imagen"));
		r.setTiempo(rs.getInt("tiempo"));
		r.setDescripcion(rs.getString("descripcion"));
		r.setDificultad(rs.getString("dificultad"));
		r.setComensales(rs.getInt("comensales"));
		
		
		return r;		
	}

}
