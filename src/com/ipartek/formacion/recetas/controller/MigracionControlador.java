package com.ipartek.formacion.recetas.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.recetas.pojo.Mensaje;

/**
 * Servlet implementation class MigracionControlador
 */
@WebServlet("/migration")
public class MigracionControlador extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// parametros conexion
	static final String URL = "jdbc:mysql://localhost:3306/concesionario";
	static final String DB_USER = "root";
	static final String DB_PASS = "";
	static final String DRIVER = "com.mysql.jdbc.Driver";

	/* variables del ejercicio del profe */
	private static final String PATH = "C:\\Desarrollo\\workspace\\web-recetas\\data\\personas.txt";
	private int contadorLineas = 0;
	private int contadorLineasOK = 0;
	private int contadorLineasError = 0;
	// La ? en estas sentencias SQL otorga el valor que se encuentre en la BD en
	// vez de introducirlo nosotros en el ejercicio
	private String sql = "INSERT INTO `persona` (`id`, `nombre`, `apellido1`, `apellido2`, `edad`, `email`, `dni`, `puesto`) VALUES (NULL, ? , 'gorriti', 'zubiri', '56', 'a@a.com', '1111111H', 'jefe');";

	/* fin ejercicio variables del profe */

	private Connection conn = null;
	private PreparedStatement pst = null;
	// private ResultSet rs = null; no es necesario, es para consultas

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("ejercicios/jdbc/migrationProcess.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Mensaje msj = null;

		/* comienzo codigo profe */

		StringBuffer sbMensaje = null;
		long tiempo = 0;

		/* fin codigo profe */

		try {

			/* Comienzo código profe */

			tiempo = System.currentTimeMillis();

			/* fin codigo profe */

			msj = new Mensaje();

			/* codigo profe */

			sbMensaje = new StringBuffer();

			/* fin codigo profe */

			msj.setDescripcion("Proceso terminado");
			// comprobar driver o libreria
			Class.forName(DRIVER);

			// establecer conexion
			conn = DriverManager.getConnection(URL, DB_USER, DB_PASS);

			/* principio codigo profe */

			conn.setAutoCommit(false);

			// Abrir fichero de personas
			FileReader file = new FileReader(PATH);
			BufferedReader bf = new BufferedReader(file);

			// recorerr fichero hasta fin y leer linea a linea
			String linea = "";
			while ((linea = bf.readLine()) != null) {

				/*
				 * if (contadorLineas == 100) { throw new Exception(
				 * "Peta en la linea 100"); }
				 */

				// comprobar campos en linea == 7 y el dni longitud == 9
				String[] aCampos = linea.split(",");
				if (aCampos.length == 7 && aCampos[5].length() == 9) {

					// insertara en bbdd la linea
					pst = conn.prepareStatement(sql);
					pst.setString(1, aCampos[0]);
					pst.executeUpdate();

					contadorLineasOK++;

				} else {
					contadorLineasError++;
				}

				contadorLineas++;
			}

			sbMensaje.append("Numero de lineas leidas: " + contadorLineas + "<br>");
			sbMensaje.append("lineas correctas: " + contadorLineasOK + "<br>");
			sbMensaje.append("lineas erroneas: " + contadorLineasError + "<br>");

			// comitar cambios
			conn.commit();

			// cerrar fichero
			bf.close();
			file.close();

			msj.setClase(Mensaje.CLASE_INFO);
			msj.setDescripcion(sbMensaje.toString());

			/* fin codigo profe */

		} catch (Exception e) {
			e.printStackTrace();

			/* codigo profe */
			try {
				conn.rollback();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
			msj.setDescripcion(e.getMessage());

			/* fin codigo profe */

		} finally {

			/* codigo profe */

			if (conn != null) {
				try {
					/* fin codigo profe */

					conn.close();
					/*
					 * con el codigo del profe esto no funciona:
					 * 
					 * pst.close();
					 * 
					 * 
					 */

				} catch (SQLException e) {
					e.printStackTrace();
				}

				/* codigo profe - fin del if + tiempo */
			}

			tiempo = System.currentTimeMillis() - tiempo;
			request.setAttribute("tiempo", "Duracion: " + tiempo + " ms");

			/* fin del código del profe - fin del if + tiempo */

			// respuesta usuario

			request.setAttribute("msj", msj);
			// al final del doGet(), ponemos la dirección a donde va el
			// controlador
			// (jsp etc)
			request.getRequestDispatcher("ejercicios/jdbc/migrationProcess.jsp").forward(request, response);
		}
	}

}
