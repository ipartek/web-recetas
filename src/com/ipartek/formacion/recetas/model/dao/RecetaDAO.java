package com.ipartek.formacion.recetas.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.recetas.model.DataBaseConnectionImpl;
import com.ipartek.formacion.recetas.model.Persistable;
import com.ipartek.formacion.recetas.pojo.Receta;
import com.mysql.jdbc.Statement;

public class RecetaDAO implements Persistable<Receta> {
	private static RecetaDAO INSTANCE = null;
	private static DataBaseConnectionImpl db;
	private Connection conn;
	
	private PreparedStatement pst = null;
	private ResultSet rs = null;
	private static String SQL_GET_ALL ="SELECT `id`, `nombre` FROM `receta` ORDER BY `id` DESC LIMIT 100";
	private static String SQL_GET_BY_ID = "SELECT `id`, `nombre` FROM `receta` WHERE `id` = ?";
	private static String SQL_UPDATE = "UPDATE `receta` SET `nombre` = ? WHERE `id` = ?";
	private static String SQL_CREATE = "INSERT INTO `receta` (`nombre`) VALUES ( ? )";
	private static String SQL_DELETE = "DELETE FROM `receta` WHERE `id` = ?";
	
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

		ArrayList<Receta> recetas = null;
		
		try {
			recetas = new ArrayList<Receta>();
			
			conn = db.getConexion();
			pst= conn.prepareStatement(SQL_GET_ALL);
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
		Receta r= null;
		
		try {
			conn = db.getConexion();
			pst = conn.prepareStatement(SQL_GET_BY_ID);
			pst.setLong(1, id);
			rs = pst.executeQuery();
			while (rs.next()){
				r = mapear(rs);
			}
					
		} catch (Exception e) {
			e.printStackTrace();
			
		}finally{
			db.desconectar();
			
		}
		return r;
	}

	@Override
	public boolean create(Receta r) {
		boolean resul = false;
		try {
			conn = db.getConexion();
			pst = conn.prepareStatement(SQL_CREATE, Statement.RETURN_GENERATED_KEYS);
			pst.setString(1, r.getTitulo());
			
			if (pst.executeUpdate() == 1) {
				rs = pst.getGeneratedKeys();
				if (rs.next()) {
					r.setId(rs.getLong("id"));
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
	public boolean update(Receta r) {
		boolean resul = false;
		try {
			conn = db.getConexion();
			pst = conn.prepareStatement(SQL_UPDATE);
			pst.setString(1, r.getTitulo());
			pst.setLong(2, r.getId());
			
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

	private Receta mapear (ResultSet rs) throws SQLException  {
		Receta r = new Receta();
		
		r.setId(rs.getLong("id"));
		r.setTitulo(rs.getString("nombre"));
		
		return r;
	}
}
