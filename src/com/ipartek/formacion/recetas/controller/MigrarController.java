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
	String[] arraylinea = null;
	ArrayList<String[]> arrayTabla = new ArrayList<String[]>();

	// parametros conexion
	static final String URL = "jdbc:mysql://localhost:3306/concesionario";
	static final String DB_USER = "root";
	static final String DB_PASS = "";
	static final String DRIVER = "com.mysql.jdbc.Driver";

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
			// handle Exception,FileNotFound,IOException.
			e.printStackTrace();
		}

		request.getRequestDispatcher("ejercicios/validar-migracion.jsp").forward(request, response);
	}

	private void abrirConexionBD() throws Exception {
		// comprobar driver o libreria
		Class.forName(DRIVER);
		// establecer conexion
		conn = DriverManager.getConnection(URL, DB_USER, DB_PASS);
	}

	private void cerrarConexionBD() throws Exception {
		rs.close();
		pst.close();
		conn.close();
	}

	void leerArchivo() throws Exception {
		// Abrir fichero y asociar buffer
		FileReader file = new FileReader("C:/Desarrollo/Workspace/web-recetas/data/personas.txt");
		BufferedReader bf = new BufferedReader(file);

		// Leer linea a linea el fichero.

		while ((linea = bf.readLine()) != null) {
			arraylinea = linea.split(",");
			arrayTabla.add(arraylinea);
			arraylinea = null;

			// Cerrar buffer y file
			bf.close();
			file.close();

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	void insertarArchivo() throws Exception {

		// String sql = "INSERT INTO `persona` (`id`, `nombre`, `apellido1`,
		// `apellido2`,`edad`,`email`,`dni`,`puesto`) VALUES (NULL, ? , ? , ? ,
		// ? , ? , ? , ? );";
		String sql = "INSERT INTO `persona` (`id`, `nombre`)VALUES (NULL, ?);";

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
		// Crear fichero.
		FileWriter fw = new FileWriter("C:/Desarrollo/Workspace/web-recetas/data/ersonas-incompletas.txt");
		// Para recoger el texto del fichero.

		for (String string : strings) {
			fw.write(string);
		}

		fw.close();

	}
}
