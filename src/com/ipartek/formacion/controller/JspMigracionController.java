package com.ipartek.formacion.controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.vehiculo.pojo.Mensaje;

/**
 * Servlet implementation class JspMigracionController
 */
@WebServlet("/migracion")
public class JspMigracionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String PATH = "C:\\desarrollo\\workspace\\web-recetas\\data\\personas.txt\\";

	Mensaje msj = null;
	// Parametros conexion
	static final String URL = "jdbc:mysql://localhost:3306/concesionario";
	final static String dPASS = "";
	final static String dUSER = "root";
	final static String dDRIVER = "com.mysql.jdbc.Driver";
	// variables de trabajo

	private Connection conn = null;
	private PreparedStatement pst = null;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			msj = new Mensaje();

			try {
				// leer fichero
				insertarDatos(PATH);

			} catch (Exception e) {

				e.printStackTrace();
			}

			// pasar att jsp

		} catch (Exception e) {
			e.printStackTrace();
			msj.setDescripcion(e.getMessage());
		} finally {
			request.setAttribute("msj", msj);
			request.getRequestDispatcher("ejercicios/listar-ficheros.jsp").forward(request, response);
		}

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	/**
	 * lee y separa los campos del fichero(en este caso 7)
	 */
	private int insertarDatos(String path) throws IOException, FileNotFoundException, SQLException {
		// TODO clase persona
		int insertErrors = 0;
		// abrir y asociar al buffer
		FileReader file = new FileReader(path);
		BufferedReader bf = new BufferedReader(file);
		String linea = null;

		while ((linea = bf.readLine()) != null) {
			if (separarDatos(linea, 7) != null) {
				insertarEnDDBB(separarDatos(linea, 6));

			} else {
				insertErrors++;
			}
		} // end while
			// cerrar buffer y file
		bf.close();
		file.close();
		// mensaje
		msj.setClase(Mensaje.CLASE_SUCCESS);
		msj.setDescripcion("Leido con Exito");

		return insertErrors;
	}

	/**
	 * Separa y comprueba los campos
	 *
	 * @param str
	 */
	private String[] separarDatos(String str, int nCol) {
		String[] trozos = str.split(",");
		String[] resul = null;

		if (trozos.length == nCol) {
			resul = trozos;

		}
		return resul;

	}

	private void insertarEnDDBB(String[] str) throws SQLException {

		String sql = "INSERT INTO `persona` (`id`, `nombre`, `apellido1`, `apellido2`, `edad`, `email`, `dni`, `puesto`) VALUES (NULL, ?, ?, ?, ?, ?, ?, ?);";

		pst = conn.prepareStatement(sql);
		pst.setString(1, str[0]);
		pst.setString(2, str[1]);
		pst.setString(3, str[2]);
		pst.setInt(4, Integer.parseInt(str[3]));
		pst.setString(5, str[4]);
		pst.setString(6, str[5]);
		pst.setString(7, str[6]);
		pst.executeUpdate();

	}

}
