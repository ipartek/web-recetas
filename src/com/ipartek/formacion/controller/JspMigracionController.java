package com.ipartek.formacion.controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
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

import com.ipartek.formacion.vehiculo.pojo.Mensaje;

/**
 * Servlet implementation class JspMigracionController
 */
@WebServlet("/migracion")
public class JspMigracionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// variables globales
	// TODO Exportar todo a un servicio
	public static final String PATH = "C:\\desarrollo\\workspace\\web-recetas\\data\\personas.txt\\";
	private int contLineas = 0;
	private int contLineasOk = 0;
	private int contLineasError = 0;
	private int contLineasErrorEdad = 0;
	private int lineaError = 0;
	StringBuffer sbMensaje = new StringBuffer();
	Mensaje msj = null;
	// Parametros conexion
	static final String URL = "jdbc:mysql://localhost:3306/concesionario";
	final static String dPASS = "";
	final static String dUSER = "root";
	final static String dDRIVER = "com.mysql.jdbc.Driver";
	String sql = "INSERT INTO `persona` (`id`, `nombre`, `apellido1`, `apellido2`, `edad`, `email`, `dni`, `puesto`) VALUES (NULL, ?, ?, ?, ?, ?, ?, ?);";

	// variables de trabajo
	private Connection conn = null;
	private PreparedStatement pst = null;
	long tiempo = 0;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			msj = new Mensaje();

			// obtener tiempo
			tiempo = System.currentTimeMillis();
			// comprobar driver
			Class.forName(dDRIVER);
			// establecer conexion
			conn = DriverManager.getConnection(URL, dUSER, dPASS);
			// quitar autocommit
			conn.setAutoCommit(false);

			insertarDatos(PATH);
			// Comitar si todo bien

			// Medir tiempo
			tiempo = System.currentTimeMillis() - tiempo;
			// mensaje
			conn.commit();
			request.setAttribute("tiempo", "Duracion: " + tiempo + " ms");
			setMensaje();

		} catch (SQLException e) {
			StringBuffer sbError = new StringBuffer();
			// El rollback salta en SQLException
			try {
				if (conn.getAutoCommit() == false) {
					conn.rollback();
					sbError.append(e.getMessage() + "Error de Formato de datos en linea " + lineaError
							+ ", la base de datos no ha sido modificada<br>");
				}

			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();

			}
			e.printStackTrace();
			sbError.append(e.getMessage() + "Error Conexion bbdd");
			msj.setDescripcion(sbError.toString());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			msj.setDescripcion(e.getMessage() + " Error driver");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			msj.setDescripcion(e.getMessage() + "Error lectura fichero");
		} catch (Exception e) {
			e.printStackTrace();
			msj.setDescripcion(e.getMessage() + " Error General");
		}
		// Cerramos la conexion
		finally {
			if (pst != null) {
				try {

					pst.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} // end if
			if (conn != null) {
				try {

					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} // end if
				// Enviamos los datos al jsp
			request.setAttribute("msj", msj);
			request.getRequestDispatcher("ejercicios/jdbc/proceso-migracion.jsp").forward(request, response);
		} // end finally

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
	private void insertarDatos(String path)
			throws IOException, FileNotFoundException, SQLException, ClassNotFoundException {
		// TODO clase persona

		// abrir y asociar al buffer
		FileReader file = new FileReader(path);
		BufferedReader bf = new BufferedReader(file);
		String linea = null;
		String[] datosSeparados = null;

		while ((linea = bf.readLine()) != null) {
			contLineas++;
			datosSeparados = separarDatos(linea, 7);
			if (datosSeparados != null) {
				insertarEnDDBB(datosSeparados);
				contLineasOk++;
				lineaError++;

			} else {
				contLineasError++;
			}
		} // end while
			// cerrar buffer y file
		bf.close();
		file.close();
	}

	/**
	 * Separa y comprueba los campos
	 *
	 * @param str
	 *            Array de Strings con los datos de cada fila
	 */
	private String[] separarDatos(String str, int nCol) {
		String[] trozos = str.split(",");
		String[] resul = null;

		if (trozos.length == nCol) {
			// dni
			if (trozos[5].length() == 9) {
				// edad
				if (Integer.parseInt(trozos[3]) > 18) {
					resul = trozos;
				} else {
					contLineasErrorEdad++;
				}
			}

		}
		return resul;

	}

	private void insertarEnDDBB(String[] str) throws SQLException, ClassNotFoundException {

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

	private void setMensaje() {
		sbMensaje.append("numero lineas leidas " + contLineas + "<br>");
		sbMensaje.append("numero lineas Erroneas " + contLineasError + "<br>");
		sbMensaje.append("De las cuales por ser menores de edad " + contLineasErrorEdad + "<br>");
		sbMensaje.append("numero lineas correctas " + contLineasOk + "<br>");
		sbMensaje.append("Tiempo de proceso " + tiempo + "ms <br>");
		msj.setClase(Mensaje.CLASE_SUCCESS);
		msj.setDescripcion(sbMensaje.toString());

	}

}
