package com.ipartek.formacion.recetas.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MigrarController
 */
@WebServlet("/migracion")
public class MigrarController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	String linea = null;
	String[] arrayLinea = null;
	ArrayList<String[]> arrayTabla = new ArrayList<String[]>();

	// parametros conexion
	private static final String URL = "jdbc:mysql://localhost:3306/concesionario";
	private static final String DB_USER = "root";
	private static final String DB_PASS = "";
	private static final String DRIVER = "com.mysql.jdbc.Driver";

	private Connection conn = null;
	private PreparedStatement pst = null;
	private ResultSet rs = null;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			leerArchivo();
			abrirConexionBD();
			insertarArchivo();
			cerrarConexionBD();

		} catch (Exception e) {
			// handle Exception FileNotFound, IOException, ClassNotFound,
			// SQLException
			e.printStackTrace();

		}

		request.getRequestDispatcher("ejercicios/validar-migracion.jsp").forward(request, response);
	}

	private void cerrarConexionBD() throws Exception {
		rs.close();
		pst.close();
		conn.close();

	}

	private void insertarArchivo() throws Exception {
		// String sql = "INSERT INTO `persona` (`id`, `nombre`,
		// `apellido1`,`apellido2`, `edad`, `email`, `dni`, `puesto`) VALUES
		// (NULL, ? , ? , ? , ? , ? , ? , ?);";
		String sql = "INSERT INTO `persona` (`id`, `nombre`) VALUES (NULL, ?);";

		for (String[] strings : arrayTabla) {
			if (strings.length != 7) {
				guardarArchivo(strings);
			} else {
				pst = conn.prepareStatement(sql);
				pst.setString(1, strings[1]);
				// pst.setString(2, strings[2]);
				// pst.setString(3, strings[3]);
				// pst.setInt(4, Integer.parseInt(strings[4]));
				// pst.setString(5, strings[5]);
				// pst.setString(6, strings[6]);
				// pst.setString(7, strings[7]);

			}
		}

	}

	private void guardarArchivo(String[] strings) throws Exception {
		FileWriter fw = new FileWriter("C:/desarrollo/workspace/web-recetas/data/personas-incompletas.txt");
		for (String string : strings) {
			fw.write(string);
		}

		fw.close();

	}

	private void abrirConexionBD() throws Exception {
		// comprobar driver o libreria
		Class.forName(DRIVER);
		// establecer conexion
		conn = DriverManager.getConnection(URL, DB_USER, DB_PASS);

	}

	private void leerArchivo() throws Exception {

		FileReader fr = new FileReader("C:/desarrollo/workspace/web-recetas/data/personas.txt");
		BufferedReader bf = new BufferedReader(fr);

		while ((linea = bf.readLine()) != null) {
			arrayLinea = linea.split(",");
			arrayTabla.add(arrayLinea);
			arrayLinea = null;
		}

		bf.close();
		fr.close();

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
