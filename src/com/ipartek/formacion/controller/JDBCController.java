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

/**
 * Servlet implementation class JDBCController
 */
@WebServlet("/jdbc")
public class JDBCController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<Vehiculo> vehiculos = null;
		Connection conn = null;
		Mensaje msj = null;
		// Parametros conexion
		final String url = "jdbc:mysql://localhost:3306/concesionario";
		final String pass = "";
		final String user = "root";
		final String driver = "com.mysql.jdbc.Driver";
		try {
			msj = new Mensaje();
			vehiculos = new ArrayList<Vehiculo>();

			// comprobar driver
			Class.forName(driver);
			// establecer conexion
			conn = DriverManager.getConnection(url, user, pass);

			// Crear sentencia SQL
			String sql = "SELECT * FROM `vehiculo`";
			PreparedStatement pst = conn.prepareStatement(sql);
			// Ejecutar Sql y recuperar resultados(ResulSet)
			ResultSet rs = pst.executeQuery();

			// Iterar sobre result set y cargar array de vehiculos
			Vehiculo v = null;
			while (rs.next()) {
				v = new Vehiculo();
				v.setId(rs.getLong("id"));
				v.setModelo(rs.getString("modelo"));
				v.setPlazas(rs.getInt("plazas"));

				vehiculos.add(v);
			}
			// cerrar conexiones

		} catch (SQLException e) {
			e.printStackTrace();
			msj.setDescripcion("Error Establecer conexion" + driver);
			msj.setClase(Mensaje.CLASE_DANGER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			msj.setDescripcion("no existe el driver" + driver);
			msj.setClase(Mensaje.CLASE_DANGER);

		} catch (Exception e) {
			e.printStackTrace();

			msj.setClase(Mensaje.CLASE_DANGER);

		} finally {
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

}
