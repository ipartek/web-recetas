package com.ipartek.formacion.recetas.model.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.recetas.model.DataBaseConnectionImpl;
import com.ipartek.formacion.recetas.model.Persistable;
import com.ipartek.formacion.recetas.pojo.Usuario;
import com.ipartek.formacion.recetas.pojo.VehiculoException;

public class UsuarioDAO implements Persistable<Usuario> {

	private static UsuarioDAO INSTANCE = null;
	private static DataBaseConnectionImpl db;
	private Connection conn;


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
		// TODO Auto-generated method stub
		ArrayList<Usuario> list = null;
		CallableStatement cst = null;
		String sql= "{call getAll()}";
		ResultSet rs = null;
		try {
			list = new ArrayList<Usuario>();
			conn = db.getConexion();
			cst = conn.prepareCall(sql);
			rs=cst.executeQuery();
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
		// TODO Auto-generated method stu
		Usuario u = null;
		CallableStatement cst = null;
		String sql= "{call usuarioBuscarById(?)}";
		ResultSet rs = null;
		try {
			conn = db.getConexion();
			cst = conn.prepareCall(sql);
			cst.setLong(1, id);
			rs=cst.executeQuery();
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
		// TODO Auto-generated method stub
		boolean resul = false;
		CallableStatement cst = null;
		String sql= "{call createUsuario(?,?,?,?,?,?,?,?,?)}";
		try {
			conn = db.getConexion();
			cst = conn.prepareCall(sql);
			cst.setString(1, u.getNombre());
			cst.setString(2, u.getApellido1());
			cst.setString(3, u.getApellido2());
			cst.setInt(4, u.getEdad());
			cst.setString(5, u.getEmail());
			cst.setString(6, u.getDni());
			cst.setString(7, u.getPuesto());
			cst.setString(8, u.getPassword());
			cst.setString(9, u.getImagen());
			// insertamos Usuario
			int affectedRows =cst.executeUpdate();
			resul = true;
			if (affectedRows == 1) {
				// buscamos el ID generado
				ResultSet generatedKeys = cst.getGeneratedKeys();
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
		// TODO Auto-generated method stub
		boolean resul = false;
		CallableStatement cst = null;
		String sql= "{call updateUsuarioById(?,?,?,?,?,?,?,?,?,?)}";
		try {
			conn = db.getConexion();
			cst = conn.prepareCall(sql);
			cst.setString(1, u.getNombre());
			cst.setString(2, u.getApellido1());
			cst.setString(3, u.getApellido2());
			cst.setInt(4, u.getEdad());
			cst.setString(5, u.getEmail());
			cst.setString(6, u.getDni());
			cst.setString(7, u.getPuesto());
			cst.setString(8, u.getPassword());
			cst.setString(9, u.getImagen());
			cst.setLong(10, u.getId());
			// insertamos Usuario
			if (cst.executeUpdate() == 1) {
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
		// TODO Auto-generated method stub
		boolean resul = false;
		CallableStatement cst = null;
		String sql= "{call deleteUsuarioById(?)}";
		try {
			conn = db.getConexion();
			cst = conn.prepareCall(sql);
			cst.setLong(1, id);

			if (cst.executeUpdate() == 1) {
				resul = true;
			}
			cst.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.desconectar();
		}
		return resul;
	}

	public Usuario getByEmail(String email) {
		// TODO Auto-generated method stub
		Usuario u = null;
		CallableStatement cst = null;
		String sql= "{call getUsuarioByEmail(?)}";
		ResultSet rs = null;
		try {
			conn = db.getConexion();
			cst = conn.prepareCall(sql);
			cst.setString(1, email);
			rs=cst.executeQuery();
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
		Usuario u = null;
		CallableStatement cst = null;
		String sql= "{call existUsuario(?,?)}";
		ResultSet rs = null;
		try {
			conn = db.getConexion();
			cst = conn.prepareCall(sql);
			cst.setString(1, email);
			cst.setString(2, password);
			rs = cst.executeQuery();
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

	/**
	 * Cuenta los usuario totales de la tabla
	 * 
	 * @return <code>int </code>numero entero de registros
	 */
	public int count() {
		int resul = -1;
		CallableStatement cst = null;
		String sql= "{call countUsuarios(?)}";
		ResultSet rs = null;
		try {
			conn = db.getConexion();
			cst = conn.prepareCall(sql);
			cst.registerOutParameter("total",java.sql.Types.INTEGER);
			rs = cst.executeQuery();
			if (rs.next()) {
				resul = rs.getInt("total");
			}
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			db.desconectar();
		}
		return resul;
	}
	
	public ArrayList<Usuario> getAllByName(String opcion) {
		// TODO Auto-generated method stub
		ArrayList<Usuario> list = null;
		CallableStatement cst = null;
		String sql= "{call usuarioBuscarAllByNombre(?)}";
		ResultSet rs = null;
		try {
			list = new ArrayList<Usuario>();
			conn = db.getConexion();
			cst = conn.prepareCall(sql);
			String rsText="%" + opcion + "%";
			cst.setString(1, rsText); 
			rs = cst.executeQuery();
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
	
	public Usuario getByDNI(String opcion) {
		// TODO Auto-generated method stub
		Usuario u = null;
		CallableStatement cst = null;
		String sql= "{call usuarioBuscarByDni(?)}";
		ResultSet rs = null;
		try {
			conn = db.getConexion();
			cst = conn.prepareCall(sql);
			cst.setString(1, opcion);
			rs=cst.executeQuery();
			while (rs.next()) {
				u=mapear(rs);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.desconectar();
		}
		return u;

	}
	

	public ArrayList<Usuario> getAllByEmail(String opcion) {
		// TODO Auto-generated method stub
		ArrayList<Usuario> list = null;
		CallableStatement cst = null;
		String sql= "{call usuarioBuscarAllByEmail(?)}";
		ResultSet rs = null;
		try {
			list = new ArrayList<Usuario>();
			conn = db.getConexion();
			cst = conn.prepareCall(sql);
			String rsText="%" + opcion + "%";
			cst.setString(1, rsText); 
			rs = cst.executeQuery();
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
	
	public boolean comprobarIntegridad(String dni,String email,long id)
	{
		boolean existe=true;
		CallableStatement cst = null;
		String sql= "{call comprobarIntegridad(?,?,?)}";
		ResultSet rs = null;
		try {
			conn = db.getConexion();
			cst = conn.prepareCall(sql);
			cst.setLong(1, id); 
			cst.setString(2, dni); 
			cst.setString(3, email); 
			rs = cst.executeQuery();
			if (rs.next()) {
				existe=false;
			}
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			db.desconectar();
		}
		return existe;
	}

	private Usuario mapear(ResultSet rs) throws SQLException, VehiculoException {
		Usuario u = new Usuario();
		u.setId(rs.getLong("id"));
		u.setNombre(rs.getString("nombre"));
		u.setApellido1(rs.getString("apellido1"));
		u.setApellido2(rs.getString("apellido2"));
		u.setEdad(rs.getInt("edad"));
		u.setEmail(rs.getString("email"));
		u.setDni(rs.getString("dni"));
		u.setPuesto(rs.getString("puesto"));
		u.setPassword(rs.getString("password"));
		u.setImagen(rs.getString("imagen"));
		return u;
	}






}
