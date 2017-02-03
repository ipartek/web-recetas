package com.ipartek.formacion.recetas.controller;

import java.io.BufferedReader;
import java.io.FileReader;
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
import com.ipartek.formacion.recetas.pojo.Persona;

/**
 * Servlet implementation class MigracionJDBCController
 */
@WebServlet("/migracion")
public class MigracionJDBCController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String VIEW = "ejercicios/jdbc/migracion-personas.jsp";
	public static final String PATH = "C:\\desarrollo\\workspace\\web-recetas\\data\\personas.txt";

	// parametros conexion
	static final String URL = "jdbc:mysql://localhost:3306/concesionario";
	static final String DB_USER = "root";
	static final String DB_PASS = "";
	static final String DRIVER = "com.mysql.jdbc.Driver";

	private Connection conn = null;
	private PreparedStatement pst = null;
	private ResultSet rs = null;

	private StringBuilder msjDescripcion = null;
	ArrayList<Persona> personas = null;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Mensaje msj = null;
		msjDescripcion = new StringBuilder();
		Persona p = null;

		try {
			msj = new Mensaje();
			personas = new ArrayList<Persona>();

			// comprobar driver o libreria
			Class.forName(DRIVER);

			// establecer conexion
			conn = DriverManager.getConnection(URL, DB_USER, DB_PASS);

			// leer del fichero
			// insertar(request);

			personas = leerFichero();

			listar();

			// mensaje usuario
			msj.setClase(Mensaje.CLASE_INFO);
			msjDescripcion.append("Consultado todas las personas");
			msj.setDescripcion(msjDescripcion.toString());

		} catch (SQLException e) {
			e.printStackTrace();
			msj.setDescripcion(e.getMessage());

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			msj.setDescripcion("No existe el Driver: " + DRIVER + " ¿seguro que has incluido la libreria .jar?");

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
			request.getRequestDispatcher(VIEW).forward(request, response);
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

	private void listar() throws SQLException {

		// crear sentencia SQL y preparar Statement
		String sql = "SELECT * FROM `persona`";
		pst = conn.prepareStatement(sql);

		// ejecutar SQL y recuperar resultados ( ResultSet )
		rs = pst.executeQuery();

		// iterar sobre ResultSEt y cargar array personas
		Persona p = null;
		while (rs.next()) {

			p = new Persona();

			p.setId(rs.getLong("id"));
			p.setNombre(rs.getString("nombre"));

			personas.add(p);

		}
	}

	private void insertar(Persona pers) throws SQLException {

		// recoger parametro
		Persona p = pers;
		StringBuilder insertTodo = new StringBuilder();

		// crear sentencia SQL y preparar Statement
		String sql = "INSERT INTO `persona` (`id`, `nombre`, `apellido1`, `apellido2`, `edad`, `email`, `dni`, `puesto`) VALUES (NULL, ?, ?, ?, ?, ?, ?, ?);";
		pst = conn.prepareStatement(sql);
		pst.setString(1, p.getNombre());
		pst.setString(2, p.getApellido1());
		pst.setString(3, p.getApellido2());
		pst.setInt(4, p.getEdad());
		pst.setString(5, p.getEmail());
		pst.setString(6, p.getDni());
		pst.setString(7, p.getPuesto());

		if (pst.executeUpdate() != 1) {
			throw new SQLException("Algo hemos programado mal, deberia retornar 1");
		}

		pst = null;

		msjDescripcion.append("Insertado nueva persona.<br>");

	}

	// Leer del fichero y sacar a un ArrayList<Vehiculo>
	public ArrayList<Persona> leerFichero() throws Exception {
		personas = new ArrayList<Persona>();
		Persona p = null;

		FileReader fr = new FileReader(PATH);
		BufferedReader br = new BufferedReader(fr);

		// Lectura del fichero
		String linea;
		p = new Persona();

		while ((linea = br.readLine()) != null) {

			// dividir en trozos la linea
			String[] trozos = linea.split(",");

			// comprobar el tamaño que sea igual a 7.

			if (trozos.length == 7) {

				// incluir los trozos en Persona
				p.setNombre(trozos[0]);
				p.setApellido1(trozos[1]);
				p.setApellido2(trozos[2]);
				p.setEdad(Integer.parseInt(trozos[3]));
				p.setEmail(trozos[4]);
				p.setDni(trozos[5]);
				p.setPuesto(trozos[6]);

				// incluir Persona en el ArrayList<Persona>
				personas.add(p);
			}

			// cerrar todo
			br.close();
			fr.close();

		}
		return personas;
	}
}
