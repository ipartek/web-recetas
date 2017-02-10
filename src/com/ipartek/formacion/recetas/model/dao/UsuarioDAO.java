package com.ipartek.formacion.recetas.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.recetas.model.DataBaseConnectionImpl;
import com.ipartek.formacion.recetas.model.Persistable;
import com.ipartek.formacion.recetas.pojo.Usuario;
import com.mysql.jdbc.Statement;

public class UsuarioDAO implements Persistable<Usuario> {

	private static UsuarioDAO INSTANCE = null;
	private static DataBaseConnectionImpl db;
	private Connection conn;
	
	
	static final private String SQL_GET_ALL = "SELECT `id`,`nombre`,`apellido1`,`apellido2`,`edad`,`email`,`dni`,`puesto`,`password`,`imagen` FROM `usuario` ORDER BY `id` DESC LIMIT 500;";
	static final private String SQL_GET_BY_ID = "SELECT `id`,`nombre`,`apellido1`,`apellido2`,`edad`,`email`,`dni`,`puesto`,`password`,`imagen` FROM `usuario` WHERE `id` = ?;";
	static final private String SQL_GET_BY_EMAIL = "SELECT `id`,`nombre`,`apellido1`,`apellido2`,`edad`,`email`,`dni`,`puesto`,`password`,`imagen` FROM `usuario` WHERE `email` = ?;";
	static final private String SQL_COUNT = "SELECT COUNT(`id`) as 'total' FROM `usuario`;";
	static final private String SQL_CREATE = "INSERT INTO `usuario`(`id`, `nombre`, `apellido1`, `apellido2`, `edad`, `email`, `dni`, `puesto`, `password`, `imagen`) VALUES (NULL,?,?,?,?,?,?,?,?,?)";
	static final private String SQL_UPDATE = "UPDATE `usuario` SET `nombre`=?,`apellido1`=?,`apellido2`=?,`edad`=?,`email`=?,`dni`=?,`puesto`=?,`password`=?,`imagen`=? WHERE `id` = ?;";
	static final private String SQL_DELETE = "DELETE FROM `usuario` WHERE `id` = ?;";
	
	static final private String SQL_GET_BY_DNI = "SELECT `id`,`nombre`,`apellido1`,`apellido2`,`edad`,`email`,`dni`,`puesto`,`password`,`imagen` FROM `usuario` WHERE `dni` = ?;";
	static final private String SQL_GET_NOMBREAPELLIDO = "SELECT `id`,`nombre`,`apellido1`,`apellido2`,`edad`,`email`,`dni`,`puesto`,`password`,`imagen` FROM `usuario` WHERE `nombre` LIKE ? OR `apellido1` LIKE ? OR `apellido2` LIKE ? LIMIT 500;";
	static final private String SQL_GET_RANGO_EDAD = "SELECT `id`,`nombre`,`apellido1`,`apellido2`,`edad`,`email`,`dni`,`puesto`,`password`,`imagen` FROM `usuario` WHERE `edad` BETWEEN ? AND ? LIMIT 500;";
	
	private UsuarioDAO() {
		db = DataBaseConnectionImpl.getInstance();
	}

	public static UsuarioDAO getInstance() {
		if (INSTANCE == null) {
			createInstance();
		}
		return INSTANCE;
	}

	private synchronized static void createInstance() {
		if (INSTANCE == null) {
			INSTANCE = new UsuarioDAO();
		}
	}
	
	@Override
	public List<Usuario> getAll() {
		ArrayList<Usuario> list = null;

		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			list = new ArrayList<Usuario>();
			conn = db.getConexion();
			pst = conn.prepareStatement(SQL_GET_ALL);
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
	public Usuario getById(long id) {
		Usuario u = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			conn = db.getConexion();
			pst = conn.prepareStatement(SQL_GET_BY_ID);
			pst.setLong(1, id);

			rs = pst.executeQuery();
			while (rs.next()) {
				u = mapear(rs);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.desconectar();
		}
		return u;
	}

	@Override
	public boolean create(Usuario u) {
		boolean resul = false;
		PreparedStatement pst = null;
		try {
			conn = db.getConexion();
			pst = conn.prepareStatement(SQL_CREATE, Statement.RETURN_GENERATED_KEYS);
			pst.setString(1, u.getNombre() );
			pst.setString(2, u.getApellido1());
			pst.setString(3, u.getApellido2());
			pst.setInt(4, u.getEdad());
			pst.setString(5, u.getEmail());
			pst.setString(6, u.getDni());
			pst.setString(7, u.getPuesto());
			pst.setString(8, u.getPassword());
			pst.setString(9, u.getImagen());
			
			
			int affectedRows = pst.executeUpdate();

			if (affectedRows == 1) {
				// buscamos el ID generado
				ResultSet generatedKeys = pst.getGeneratedKeys();
				if (generatedKeys.next()) {
					u.setId(generatedKeys.getLong(1));
					resul = true;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.desconectar();
		}
		return resul;
	}

	@Override
	public boolean update(Usuario u) {
		boolean resul = false;
		PreparedStatement pst = null;
		try {
			conn = db.getConexion();
			pst = conn.prepareStatement(SQL_UPDATE);
			pst.setString(1, u.getNombre() );
			pst.setString(2, u.getApellido1());
			pst.setString(3, u.getApellido2());
			pst.setInt(4, u.getEdad());
			pst.setString(5, u.getEmail());
			pst.setString(6, u.getDni());
			pst.setString(7, u.getPuesto());
			pst.setString(8, u.getPassword());
			pst.setString(9, u.getImagen());
			pst.setLong(10, u.getId());
			
			if (pst.executeUpdate() == 1) {
				resul = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.desconectar();
		}
		return resul;
	}

	@Override
	public boolean delete(long id) {
		boolean resul = false;
		PreparedStatement pst = null;
		try {
			conn = db.getConexion();
			pst = conn.prepareStatement(SQL_DELETE);
			pst.setLong(1, id);

			if (pst.executeUpdate() == 1) {
				resul = true;
			}

			pst.close();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.desconectar();
		}
		return resul;
	}

	public Usuario getByEmail(String email) {
		Usuario u = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			conn = db.getConexion();
			pst = conn.prepareStatement(SQL_GET_BY_EMAIL);
			pst.setString(1, email);

			rs = pst.executeQuery();
			while (rs.next()) {
				u = mapear(rs);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.desconectar();
		}
		return u;
	}

	public Usuario existe(String email, String password) {
		Usuario u = new Usuario();
		String pass = "";
		u = getByEmail(email);
		if (u!= null) {
			pass = u.getPassword();
		}
		if (!password.equals(pass)) {
			u = null;
		}
		
		return u;
	}

	/**
	 * Cuenta los usuario totales de la tabla
	 * 
	 * @return <code>int </code>numero entero de registros
	 */
	public int count() {
		int c = 0;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
		
			conn = db.getConexion();
			pst = conn.prepareStatement(SQL_COUNT);
			rs = pst.executeQuery();
			while (rs.next()) {
				c = rs.getInt("total");
			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			db.desconectar();
		}
		return c;
	}
	
	public Usuario getByDni(String dni) {
		Usuario u = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			conn = db.getConexion();
			pst = conn.prepareStatement(SQL_GET_BY_DNI);
			pst.setString(1, dni);

			rs = pst.executeQuery();
			while (rs.next()) {
				u = mapear(rs);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.desconectar();
		}
		return u;
	}
	
	public List<Usuario> getNombreApellido(String busqueda) {
		ArrayList<Usuario> list = null;

		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			list = new ArrayList<Usuario>();
			conn = db.getConexion();
			pst = conn.prepareStatement(SQL_GET_NOMBREAPELLIDO);
			pst.setString(1, "%" + busqueda + "%");
			pst.setString(2, "%" + busqueda + "%");
			pst.setString(3, "%" + busqueda + "%");
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
	
	public List<Usuario> getRangoEdad(int rangoMin, int rangoMax) {
		ArrayList<Usuario> list = null;

		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			list = new ArrayList<Usuario>();
			conn = db.getConexion();
			pst = conn.prepareStatement(SQL_GET_RANGO_EDAD);
			pst.setInt(1, rangoMin);
			pst.setInt(2, rangoMax);
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
	
	private Usuario mapear(ResultSet rs) throws SQLException{
		Usuario u = new Usuario();
		
		u.setId(rs.getLong("id"));
		u.setNombre(rs.getString("nombre"));
		u.setApellido1(rs.getString("apellido1"));
		u.setApellido2(rs.getString("apellido2"));
		u.setDni(rs.getString("dni"));
		u.setEdad(rs.getInt("edad"));
		u.setEmail(rs.getString("email"));
		u.setPassword(rs.getString("password"));
		u.setImagen(rs.getString("imagen"));
		u.setPuesto(rs.getString("puesto"));
		
		return u;
	}
	
}
