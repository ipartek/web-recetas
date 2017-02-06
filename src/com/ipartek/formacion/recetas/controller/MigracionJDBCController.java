package com.ipartek.formacion.recetas.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
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
	// public static final String PATH =
	// "/nagore/workspace/web-recetas/data/personas.txt";

	// parametros conexion
	static final String URL = "jdbc:mysql://localhost:3306/concesionario";
	static final String DB_USER = "root";
	static final String DB_PASS = "";
	// static final String DB_PASS = "root";
	static final String DRIVER = "com.mysql.jdbc.Driver";

	private Connection conn = null;
	private PreparedStatement pst = null;
	private ResultSet rs = null;
	Savepoint sp = null;

	private StringBuilder msjDescripcion = null;
	ArrayList<Persona> personas = null;
	private int contTotalPersonas;
	long tiempo;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Mensaje msj = null;
		msjDescripcion = new StringBuilder();
		// Persona p = null;
		contTotalPersonas = 0;

		try {

			tiempo = System.currentTimeMillis();
			msj = new Mensaje();
			personas = new ArrayList<Persona>();

			// comprobar driver o libreria
			Class.forName(DRIVER);

			// establecer conexion
			conn = DriverManager.getConnection(URL, DB_USER, DB_PASS);

			// leer del fichero
			personas = leerFichero();

			// Insertar todas las personas validas del fichero
			insertar(personas);

			// listar todo lo insertado
			listar();

			// mensaje usuario
			msj.setClase(Mensaje.CLASE_INFO);
			msjDescripcion.append("Consultado todas las personas");
			msj.setDescripcion(msjDescripcion.toString());

		} catch (SQLException e) {
			if (conn != null) {
				// En caso de Fallo
				try {
					conn.rollback(sp);
					personas.removeAll(personas);
				} catch (SQLException e1) {
					msj.setDescripcion(e.getMessage());
					e1.printStackTrace();
				}
			}
			e.printStackTrace();
			msj.setDescripcion(e.getMessage());

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			msj.setDescripcion("No existe el Driver: " + DRIVER + " Â¿seguro que has incluido la libreria .jar?");

		} catch (Exception e) {
			msj.setDescripcion(e.getMessage());
			e.printStackTrace();
		} finally {

			// cerrar conexiones y objetos asociados
			try {
				if (rs != null) {
					rs.close();
				}
				pst.close();
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

			tiempo = System.currentTimeMillis() - tiempo;
			request.setAttribute("msj", msj);
			request.setAttribute("tiempo", tiempo);
			request.setAttribute("numInsertado", personas.size());
			request.setAttribute("numTotalFichero", contTotalPersonas);
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

		personas = new ArrayList<Persona>();

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
			p.setApellido1(rs.getString("apellido1"));
			p.setApellido2(rs.getString("apellido2"));
			p.setEdad(rs.getInt("edad"));
			p.setEmail(rs.getString("email"));
			p.setDni(rs.getString("dni"));
			p.setPuesto(rs.getString("puesto"));

			personas.add(p);

		}
	}

	private void insertar(ArrayList<Persona> pers) throws SQLException {

		// Establecer conexion NO-COMITABLE: Autocommit a false
		conn.setAutoCommit(false);

		// set a Savepoint
		sp = conn.setSavepoint("sp");

		// Proceso de migracion: crear sentencia SQL y preparar Statement por
		// cada uno de las Personas
		for (Persona p : pers) {

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
		}

		conn.commit();

		pst = null;
		personas = null;

		msjDescripcion.append("Insertado todas las personas del fichero.<br>");

	}

	// Leer del fichero y sacar a un ArrayList<Vehiculo>
	public ArrayList<Persona> leerFichero() throws Exception {
		personas = new ArrayList<Persona>();
		Persona p = null;

		FileReader fr = new FileReader(PATH);
		BufferedReader br = new BufferedReader(fr);

		// Lectura del fichero
		String linea = "";

		while ((linea = br.readLine()) != null) {
			contTotalPersonas++;

			p = new Persona();
			// dividir en trozos la linea
			String[] trozos = linea.split(",");

			// comprobar el tamaño que sea igual a 7, que el dni tenga una
			// logitud de 9 y quitar aquellas personas que sean menores de 18
			// años

			if (trozos.length == 7 && trozos[5].length() == 9 && Integer.parseInt(trozos[3]) >= 18) {
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

		}

		// cerrar todo
		br.close();
		fr.close();

		return personas;
	}
}
