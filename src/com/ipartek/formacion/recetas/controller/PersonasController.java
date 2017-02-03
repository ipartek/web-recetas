package com.ipartek.formacion.recetas.controller;

import java.io.BufferedReader;
import java.io.File;
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
 * Servlet implementation class PersonasController
 */
@WebServlet("/personas")
public class PersonasController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String PATH = "C:\\desarrollo\\workspace\\web-recetas\\data\\personas.txt";
	static final String URL = "jdbc:mysql://localhost:3306/concesionario";
	static final String DB_USER = "root";
	static final String DB_PASS = "";
	static final String DRIVER = "com.mysql.jdbc.Driver";
	Mensaje msj = null; 
    int contC = 0;
    int contI = 0;
    int total = 0;
    String[] trozos = null;
    
    Connection conn = null;
	PreparedStatement pst = null;
	long system1,system2 = 0;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String texto = "";
		try {
			File archivo = null;
		    FileReader fr = null;
		    BufferedReader br = null;    
		    msj = new Mensaje();
			archivo = new File (PATH );
	        fr = new FileReader (archivo);
	        br = new BufferedReader(fr);
	        
	     // comprobar driver o libreria
			Class.forName(DRIVER);

			// establecer conexion
			conn = DriverManager.getConnection(URL, DB_USER, DB_PASS);
			conn.setAutoCommit(false);
	        
	        String linea;
		    while((linea=br.readLine())!=null) {
		    	trozos = linea.split(",");
		    	if (trozos.length == 7 && trozos[5].length() == 9) {
		    		
		    			insertar();
		    			++contC;
		    		
		    	} else  {
		    		++contI;
		    	}
		    	total++;
		    }
		    try{
		    	system1 = System.currentTimeMillis();
		    	conn.commit();
		    
		    } catch (SQLException e) {
		    	if (conn != null) {
		    		conn.rollback();
		    	}
		    } 
		} catch (SQLException e) {
			e.printStackTrace();
			msj.setDescripcion(e.getMessage());

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			msj.setDescripcion("No existe el Driver: " + DRIVER + " ¿ seguro que has incluido la libreria .jar?");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			// cerrar conexiones y objetos asociados
			
			try {
				
				pst.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}	
		} 
		system2 = System.currentTimeMillis();
		system2 -= system1;
//		system2 /= 1000;
		request.setAttribute("tiempo", system2);
		request.setAttribute("correctos", contC);
		request.setAttribute("incorrectos", contI);
		request.setAttribute("total", total);
		request.getRequestDispatcher("ejercicios/personas/volcar-lista.jsp").forward(request, response);
	}

	private void insertar() throws SQLException {
		String sql = "INSERT INTO `persona` (`id`, `nombre`, `apellido1`, `apellido2`, `edad`, `email`, `dni`, `puesto`) VALUES (NULL, ? , ? , ?, ? , ? , ? , ?);";
		
		pst = conn.prepareStatement(sql);
		pst.setString(1, trozos[0]);
		pst.setString(2, trozos[1]);
		pst.setString(3, trozos[2]);
		pst.setString(4, trozos[3]);
		pst.setString(5, trozos[4]);
		pst.setString(6, trozos[5]);
		pst.setString(7, trozos[6]);
		
		if (pst.executeUpdate() != 1){
			throw new SQLException("Algo hemos programado mal en el INSERT, deberia retornar 1");
		}
	
		
		
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("ejercicios/personas/volcar-lista.jsp").forward(request, response);
	}

}
