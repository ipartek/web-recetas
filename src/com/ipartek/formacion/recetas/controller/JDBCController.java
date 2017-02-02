package com.ipartek.formacion.recetas.controller;

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

import com.ipartek.formacion.recetas.ejercicios.herencia.Vehiculo;
import com.ipartek.formacion.recetas.pojo.Mensaje;

/**
 * Servlet implementation class JDBCController
 */
@WebServlet("/jdbc")
public class JDBCController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// parametros conexion
	final String url = "jdbc:mysql://localhost:3306/concesionario";
	final String dbUser = "root";
	final String dbPass = "";
	final String driver = "com.mysql.jdbc.Driver";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Mensaje msj = null;
		ArrayList<Vehiculo> vehiculos = null;
		Connection conn = null;

		try {
			msj = new Mensaje();
			vehiculos = new ArrayList<Vehiculo>();

			// comprobar driver o libreria
			Class.forName(driver);

			// establecer conexion
			conn = DriverManager.getConnection(url, dbUser, dbPass);

			// crear sentencia SQL y preparar Statement
			String sql = "SELECT * FROM `vehiculo`";
			PreparedStatement pst = conn.prepareStatement(sql);

			// ejecutar SQL y recuperar resultados ( ResultSet )
			ResultSet rs = pst.executeQuery();

			// iterar sobre ResultSEt y cargar array vehiculos
			Vehiculo v = null;
			while (rs.next()) {

				v = new Vehiculo();

				v.setId(rs.getLong("id"));
				v.setModelo(rs.getString("modelo"));

				vehiculos.add(v);

			}

			// cerrar conexiones

			// mensaje usuario
			msj.setClase(Mensaje.CLASE_INFO);
			msj.setDescripcion("conexion establecida");

		} catch (SQLException e) {
			e.printStackTrace();
			msj.setDescripcion(e.getMessage());

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			msj.setDescripcion("No existe el Driver: " + driver + " ¿ seguro que has incluido la libreria .jar?");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			request.setAttribute("msj", msj);
			request.setAttribute("vehiculos", vehiculos);
			request.getRequestDispatcher("ejercicios/jdbc/consulta-bbdd.jsp").forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}