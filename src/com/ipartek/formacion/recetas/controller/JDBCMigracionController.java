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

import com.ipartek.formacion.recetas.pojo.Mensaje;
import com.ipartek.formacion.recetas.pojo.PersonaBBDD;

/**
 * Servlet implementation class JDBCController
 */
@WebServlet("/migracionbd")
public class JDBCMigracionController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// parametros conexion
	static final String URL = "jdbc:mysql://localhost:3306/concesionario";
	static final String DB_USER = "root";
	static final String DB_PASS = "";
	static final String DRIVER = "com.mysql.jdbc.Driver";

	private Connection conn = null;
	private PreparedStatement pst = null;
	private ResultSet rs = null;
	private ArrayList<PersonaBBDD> personas = null;
	private StringBuilder msjDescripcion = null;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Mensaje msj = null;

		try {
			msjDescripcion = new StringBuilder();
			msj = new Mensaje();
			personas = new ArrayList<PersonaBBDD>();

			// comprobar driver o libreria
			Class.forName(DRIVER);

			// establecer conexion
			conn = DriverManager.getConnection(URL, DB_USER, DB_PASS);

			if (request.getMethod().equalsIgnoreCase("POST")) {
				insertar(request);
			}

			listar();

			// mensaje usuario
			msj.setClase(Mensaje.CLASE_INFO);
			msjDescripcion.append("Consultado todos los vehiculos <br>");
			msj.setDescripcion(msjDescripcion.toString());

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
			request.setAttribute("personas", personas);

		}

	}

	private void insertar(HttpServletRequest request) throws SQLException {
		String sql = "INSERT INTO `vehiculo` (`id`, `modelo`, `plazas`, `potencia`) VALUES (NULL, ?, '5', '1500')";
		String pModelo = request.getParameter("modelo");

		pst = conn.prepareStatement(sql);
		pst.setString(1, pModelo); // para sustituir los interrogantes con el
									// modelo

		if (pst.executeUpdate() != 1) {
			throw new SQLException("Algo hemos programado mal, executeUpdate deberia retornar 1");
		}

		pst = null;

		msjDescripcion.append("insertado nuevo vehiculo <br>");

	}

	private void listar() throws SQLException {
		// crear sentencia SQL y preparar Statement
		String sql = "SELECT * FROM `persona`";
		pst = conn.prepareStatement(sql);

		// ejecutar SQL y recuperar resultados ( ResultSet )
		rs = pst.executeQuery();

		// iterar sobre ResultSEt y cargar array vehiculos
		PersonaBBDD p = null;
		while (rs.next()) {

			p = new PersonaBBDD();

			p.setId(rs.getInt("id"));
			p.setNombre(rs.getString("nombre"));
			p.setApellido1(rs.getString("apellido1"));
			p.setApellido2(rs.getString("apellido2"));
			p.setEdad(rs.getInt("edad"));
			p.setEmail(rs.getString("email"));
			p.setDni(rs.getString("dni"));
			p.setPuesto(rs.getString("puesto"));

			personas.add(p);

		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("ejercicios/jdbc/migracion-bbdd.jsp").forward(request, response);
	}

}
