package com.ipartek.formacion.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.vehiculo.pojo.Mensaje;
import com.ipartek.formacion.vehiculo.pojo.Vehiculo;
import com.ipartek.formacion.vehiculo.pojo.VehiculoException;

/**
 * Servlet implementation class JDBCController
 */
@WebServlet("/jdbc")
public class JDBCController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArrayList<Vehiculo> vehiculos = null;
	// Parametros conexion
	static final String URL = "jdbc:mysql://localhost:3306/concesionario";
	final static String dPASS = "";
	final static String dUSER = "root";
	final static String dDRIVER = "com.mysql.jdbc.Driver";
	// variables de trabajo

	private Connection conn = null;
	private ResultSet rs = null;
	private PreparedStatement pst = null;
	private StringBuilder msjDescripcion = null;

	private Mensaje msj = null;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			msj = new Mensaje();
			msjDescripcion = new StringBuilder();
			vehiculos = new ArrayList<Vehiculo>();

			// comprobar driver
			Class.forName(dDRIVER);
			// establecer conexion
			conn = DriverManager.getConnection(URL, dUSER, dPASS);

			// Seleccionamos la operacion segun de donde venga
			if (request.getMethod().equalsIgnoreCase("POST")) {
				insertar(request);
			}
			listar();

			// Clase general del mensaje usuario
			msj.setClase(Mensaje.CLASE_INFO);
			msjDescripcion.append("Consultado todos los vehiculos<br>");
			msj.setDescripcion(msjDescripcion.toString());

		} catch (SQLException e) {
			e.printStackTrace();
			msj.setDescripcion("Error Establecer conexion" + dDRIVER);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			msj.setDescripcion("no existe el driver" + dDRIVER);

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			// cerrar conexiones y objetos asociados(Orden inverso)
			try {
				rs.close();
				pst.close();
				conn.close();
			} catch (SQLException e) {

				e.printStackTrace();
			} catch (Exception e) {

				e.printStackTrace();
			}
			// mensaje usuario

			request.setAttribute("msj", msj);
			request.setAttribute("vehiculos", vehiculos);
			request.getRequestDispatcher("ejercicios/jdbc/consulta-bbdd.jsp").forward(request, response);

		}

	}// doGet fin

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

	/**
	 *
	 * @throws SQLException
	 * @throws VehiculoException
	 */
	private void listar() throws SQLException, VehiculoException {
		// Crear sentencia SQL
		String sql = "SELECT * FROM `vehiculo`";
		pst = conn.prepareStatement(sql);
		// Ejecutar Sql y recuperar resultados(ResulSet)
		rs = pst.executeQuery();

		// Iterar sobre result set y cargar array de vehiculos
		Vehiculo v = null;
		while (rs.next()) {
			v = new Vehiculo();
			v.setId(rs.getLong("id"));
			v.setModelo(rs.getString("modelo"));
			v.setPlazas(rs.getInt("plazas"));
			v.setPotencia(rs.getFloat("potencia"));

			vehiculos.add(v);
		} // end while

	}

	private void insertar(HttpServletRequest request) throws SQLException {
		String sql = "INSERT INTO `vehiculo` (`id`, `modelo`, `plazas`, `potencia`) VALUES (NULL, ? , '5', '1500');";
		String pModelo = request.getParameter("modelo");

		pst = conn.prepareStatement(sql);
		pst.setString(1, pModelo);

		if (pst.executeUpdate() != 1) {
			throw new SQLException("Algo hemos programado mal, deberia retornar 1");
		}

		pst = null;

		msjDescripcion.append("Insertado nuevo Vechiculo.<br>");

	}

}
