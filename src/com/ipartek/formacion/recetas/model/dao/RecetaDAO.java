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

		// buscamos los ultimos 100 vehiculos ordenados por 'id' en orden
		// descendiente
		String sql = "SELECT `id`, `nombre` FROM `receta` ORDER BY `id` DESC LIMIT 100";
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {

			list = new ArrayList<Receta>();
			conn = db.getConexion();
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();

			while (rs.next()) {

				list.add(mapear(rs));

			}

		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			db.desconectar();

		}

		return list;
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
	public boolean update(Receta onjeto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(long id) {
		// TODO Auto-generated method stub
		return false;
	}

	private Receta mapear(ResultSet rs) throws SQLException {
		Receta r = new Receta(null);

		r.setId(rs.getLong("id"));
		r.setTitulo(rs.getString("titulo"));

		return r;
	}

}
