package com.ipartek.formacion.recetas.controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.recetas.pojo.Mensaje;

/**
 * Servlet implementation class MigrarController
 */
@WebServlet("/migracion")
public class MigrarController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// parametros conexion
	static final String URL = "jdbc:mysql://localhost:3306/concesionario";
	static final String DB_USER = "root";
	static final String DB_PASS = "";
	static final String DRIVER = "com.mysql.jdbc.Driver";

	private String linea = null;
	private String[] arraylinea = null;
	private ArrayList<String[]> arrayTabla = new ArrayList<String[]>();
	private Connection conn = null;
	private PreparedStatement pst;

	private ArrayList<String[]> sqlEquivocado = new ArrayList<String[]>();

	// Mensaje
	private Mensaje msj = new Mensaje();

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

			conn.commit();
			msj.setClase(Mensaje.CLASE_SUCCESS);
			msj.setDescripcion("Migracion Correcta");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			msj.setDescripcion(e.getMessage() + "driver no funciona " + DRIVER);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			msj.setDescripcion(
					e.getMessage() + "No encuentra archivo C:/Desarrollo/Workspace/web-recetas/data/personas.txt");

		} catch (SQLException e) {
			e.printStackTrace();
			msj.setDescripcion(e.getMessage() + "problemas al insertar datos");
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
				msj.setDescripcion(e1.getMessage() + "Problemas de rollback");
			}

		} finally {
			request.setAttribute("msj", msj);
			request.getRequestDispatcher("ejercicios/validar-migracion.jsp").forward(request, response);
			try {
				cerrarConexionBD();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}

	// Abrir y cerrar conexion

	private void abrirConexionBD() throws ClassNotFoundException, SQLException {
		// comprobar driver o libreria
		Class.forName(DRIVER);
		// establecer conexion
		conn = DriverManager.getConnection(URL, DB_USER, DB_PASS);
		conn.setAutoCommit(false);
	}

	private void cerrarConexionBD() throws SQLException {
		conn.close();
	}

	// Leer archivo data.

	private void leerArchivo() throws FileNotFoundException, IOException {
		// Abrir fichero y asociar buffer
		FileReader file = new FileReader("C:/Desarrollo/Workspace/web-recetas/data/personas.txt");
		BufferedReader bf = new BufferedReader(file);

		// Leer linea a linea el fichero.

		while ((linea = bf.readLine()) != null) {
			arraylinea = linea.split(",");
			arrayTabla.add(arraylinea);
			arraylinea = null;

		}

		// Cerrar buffer y file
		bf.close();
		file.close();
	}

	// Insertar arrays

	void insertarArchivo() throws SQLException {

		String sql = "INSERT INTO `persona` (`id`, `nombre`, `apellido1`,`apellido2`, `edad`, `email`, `dni`, `puesto`) VALUES (NULL, ? , ? , ? , ? , ? , ? , ?);";

		for (String[] strings : arrayTabla) {
			if (strings.length != 7 || strings[5].length() > 9) {
				sqlEquivocado.add(strings);

			} else {
				pst = conn.prepareStatement(sql);
				pst.setString(1, strings[0]);
				pst.setString(2, strings[1]);
				pst.setString(3, strings[2]);
				pst.setInt(4, Integer.parseInt(strings[3]));
				pst.setString(5, strings[4]);
				pst.setString(6, strings[5]);
				pst.setString(7, strings[6]);
				pst.executeUpdate();
				pst.close();

			}
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
}
