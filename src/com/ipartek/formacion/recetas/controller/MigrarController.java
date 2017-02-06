package com.ipartek.formacion.recetas.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
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
	// conexion BBDD
	private static final String URL = "jdbc:mysql://localhost:3306/concesionario";
	private static final String DB_USER = "root";
	private static final String DB_PASS = "";
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private Connection conn = null;

	// leerArchivo
	private FileReader fr;
	private BufferedReader bf;
	private String linea = null;
	private String[] arrayLinea = null;
	private ArrayList<String[]> arrayTabla = new ArrayList<String[]>();

	// GuardarIncompletas
	private FileWriter fw;
	private BufferedWriter bw;

	// SQL
	private PreparedStatement pst;
	private String sql = "INSERT INTO `persona` (`id`, `nombre`, `apellido1`,`apellido2`, `edad`, `email`, `dni`, `puesto`) VALUES (NULL, ? , ? , ? , ? , ? , ? , ?);";
	private ArrayList<String[]> sqlEquivocado = new ArrayList<String[]>();

	// Mensaje
	private Mensaje msj = new Mensaje();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			leerArchivo();
			abrirConexionBD();
			insertarArchivo();
			guardarIncompletas();

			conn.commit();
			msj.setClase(Mensaje.CLASE_SUCCESS);
			msj.setDescripcion("Migracion Correcta");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			msj.setDescripcion(e.getMessage() + "driver no funciona " + DRIVER);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			msj.setDescripcion(e.getMessage() + "no encuentra archivo C:/java/workspace/web-recetas/data/personas.txt");

		} catch (SQLException e) {
			e.printStackTrace();
			msj.setDescripcion(e.getMessage() + "problemas al insertar datos");
			
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
				msj.setDescripcion(e1.getMessage() + "problemas con rollback");

			}

		} finally {
			request.setAttribute("msj", msj);
			request.getRequestDispatcher("ejercicios/validar-migracion.jsp").forward(request, response);

			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
				msj.setDescripcion(e.getMessage() + "problemas con cerrando la base de datos");
			}
		}
	}

	// INSERTAR EN BBDD desde ARRAY
	private void insertarArchivo() throws SQLException {

		for (String[] strings : arrayTabla) {

			if (strings.length != 7 || strings[5].length() != 9) {
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

	// LEER ARCHIVO txt con BBDD A MIGRAR
	private void leerArchivo() throws FileNotFoundException, IOException {
		fr = new FileReader("C:/desarrollo/workspace/web-recetas/data/personas.txt");
		bf = new BufferedReader(fr);

		while ((linea = bf.readLine()) != null) {
			arrayLinea = linea.split(",");
			arrayTabla.add(arrayLinea);
			arrayLinea = null;
		}

		bf.close();
		fr.close();

	}

	// GUARDAR LINEAS ERRONEAS
	private void guardarIncompletas() throws IOException {
		fw = new FileWriter("C:/desarrollo/workspace/web-recetas/data/personas-incompletas.txt");
		bw= new BufferedWriter(fw); 
		
		for (String[] strings : sqlEquivocado) {
			linea = "";
			for (String string : strings) {
				linea += string + ", ";
			}
			bw.write(linea);
			bw.newLine();
			
		}
		fw.close();
	}

	// CONEXION BASE DE DATOS
	private void abrirConexionBD() throws ClassNotFoundException, SQLException {
		Class.forName(DRIVER);
		conn = DriverManager.getConnection(URL, DB_USER, DB_PASS);
		conn.setAutoCommit(false);

	}

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
