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

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Mensaje msj = null;
		ArrayList<Vehiculo> vehiculos = null;
		Connection con = null;
		final String driver = "com.mysql.jdbc.Driver";

		try {
			msj = new Mensaje();
			vehiculos = new ArrayList<Vehiculo>();

			// parametros conexion

			final String url = "jdbc:mysql://localhost:3306/concesionario";
			final String dbUser = "root";
			final String dbPas = "";

			// comprobar driver o librería
			Class.forName(driver);

			// establecer conexion

			con = DriverManager.getConnection(url, dbUser, dbPas);

			// crear sentencia SQL y preparar statement

			String sql = "SELECT * FROM `vehiculo`";
			PreparedStatement pst = con.prepareStatement(sql);

			// ejecutar SQL y recuperar los resultados (ResultSet)

			ResultSet rs = pst.executeQuery();

			// interar sobre ResultSet y cargar array vehiculos

			Vehiculo v = null;
			while (rs.next()) {

				v = new Vehiculo();
				v.setId(rs.getLong("id"));
				v.setModelo(rs.getString("modelo"));

				vehiculos.add(v);
			}

			// cerrar conexiones

			// mensajes
			msj.setClase(Mensaje.CLASE_INFO);
			msj.setDescripcion("conexión establecida");

		} catch (SQLException e) {
			e.printStackTrace();
			msj.setDescripcion(e.getMessage());

		} catch (ClassNotFoundException e) { // verificar que esté el driver
			e.printStackTrace();
			msj.setDescripcion("No existe el driver" + driver + "¿Seguro que has incluido la librería .jar?");

		} catch (Exception e) {

		} finally {

			request.setAttribute("vehiculos", new ArrayList<Vehiculo>());

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
