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
	static final String URL = "jdbc:mysql://localhost:3306/concesionario";
	static final String DB_USER = "root";
	static final String DB_PASS = "";
	static final String DRIVER = "com.mysql.jdbc.Driver";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Mensaje msj = null;
		ArrayList<Vehiculo> vehiculos = null;
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			msj = new Mensaje();
			vehiculos = new ArrayList<Vehiculo>();

			// comprobar driver o libreria
			Class.forName(DRIVER);

			// establecer conexion
			conn = DriverManager.getConnection(URL, DB_USER, DB_PASS);

			// crear sentencia SQL y preparar Statement
			String sql = "SELECT * FROM `vehiculo`";
			pst = conn.prepareStatement(sql);

			// ejecutar SQL y recuperar resultados ( ResultSet )
			rs = pst.executeQuery();

			// iterar sobre ResultSEt y cargar array vehiculos
			Vehiculo v = null;
			while (rs.next()) {

				v = new Vehiculo();

				v.setId(rs.getLong("id"));
				v.setModelo(rs.getString("modelo"));

				vehiculos.add(v);

			}

			// mensaje usuario
			msj.setClase(Mensaje.CLASE_INFO);
			msj.setDescripcion("conexion establecida");

		} catch (SQLException e) {
			e.printStackTrace();
			msj.setDescripcion(e.getMessage());

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			msj.setDescripcion("No existe el Driver: " + DRIVER + " ¿ seguro que has incluido la libreria .jar?");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			// cerrar conexiones y objetos asociados
			try {
				rs.close();
				pst.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

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
