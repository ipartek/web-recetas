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

import com.ipartek.formacion.recetas.ejercicios.herencia.Vehiculo;
import com.ipartek.formacion.recetas.ejercicios.herencia.VehiculoException;
import com.ipartek.formacion.recetas.pojo.Mensaje;

/**
 * Servlet implementation class JDBCController
 */
@WebServlet("/jdbc")
public class JDBCController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	// parametros conexion
		static final String URL = "jdbc:mysql://localhost:3306/concesionario";
		static final String DBUSER = "root";
		static final String DBPASS = "";
		static final String DRIVER = "com.mysql.jdbc.Driver";
		ArrayList<Vehiculo> vehiculos = null;
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		StringBuilder msjdescripcion = null;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Mensaje msj = null;
	
		try {
			msjdescripcion = new StringBuilder();
			msj = new Mensaje();
			vehiculos = new ArrayList<Vehiculo>();

			// comprobar driver o libreria
			Class.forName(DRIVER);

			// establecer conexion
			conn = DriverManager.getConnection(URL, DBUSER, DBPASS);

			if(request.getMethod().equalsIgnoreCase("POST")){
				insertar(request);
			}
			
			listar();
			
			

			// cerrar conexiones
			try{
				rs.close();
				pst.close();
				conn.close();
			}catch(SQLException e){
				e.printStackTrace();
			}

			// mensaje usuario
			msj.setClase(Mensaje.CLASE_INFO);
			msjdescripcion.append("Consultado todos los vehiculos");
			msj.setDescripcion(msjdescripcion.toString());


		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			msj.setDescripcion("No existe el Driver: " + DRIVER + " ¿ seguro que has incluido la libreria .jar?");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			request.setAttribute("msj", msj);
			request.setAttribute("vehiculos", vehiculos);
			request.getRequestDispatcher("ejercicios/jdbc/consulta-bbdd.jsp").forward(request, response);
		}

	}
		

	private void insertar(HttpServletRequest request) throws SQLException {
		
		String sql = "INSERT INTO `vehiculo` (`id`, `modelo`, `plazas`, `potecia`) VALUES (NULL, ? ,'5','1500')";
		String pModelo = request.getParameter("modelo");
		
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1, pModelo);
		
		if(pst.executeUpdate() != 1){
	
			throw new SQLException("Algo hemos programado mal, deberia retornar 1");
			
		}
		
		pst = null;
		
		msjdescripcion.append("Insertado nuevo vehiculo");
	}


	private void listar() throws SQLException, VehiculoException {
		// crear sentencia SQL y preparar Statement
		String sql = "SELECT * FROM `vehiculo`";
		pst = conn.prepareStatement(sql);

		// ejecutar SQL y recuperar resultados ( ResultSet )
		rs = pst.executeQuery();

		// iterar sobre ResultSEt y cargar array vehiculos
		Vehiculo v = null;
		while (rs.next()) {
			v = new Vehiculo();

			v.setId(rs.getLong("id"));
			v.setModelo(rs.getString("modelo"));

			vehiculos.add(v);

		}
		
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
