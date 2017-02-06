package com.ipartek.formacion.recetas.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
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
	public static final String PATH_I = "C:\\desarrollo\\workspace\\web-recetas\\data\\personasIncorrectos.txt";
	static final String URL = "jdbc:mysql://localhost:3306/concesionario";
	static final String DB_USER = "root";
	static final String DB_PASS = "";
	static final String DRIVER = "com.mysql.jdbc.Driver";
	Mensaje msj = null; 
    int contCorrectos = 0;
    int contIncorrectos = 0;
    int total = 0;
    String[] trozos = null;
    Float time;
    
    Connection conn = null;
	PreparedStatement pst = null;
	long system1,system2 = 0;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		contCorrectos = 0;
	    contIncorrectos = 0;
	    total = 0;
		system1 = System.currentTimeMillis();
		
		//Creamos archivo de los datos incorrectos
		FileWriter fw = new FileWriter(PATH_I);
		
		
		
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
		    			++contCorrectos;
		    		
		    	} else  {
		    		++contIncorrectos;
		    		fw.write(linea + "\r\n");
		    	}
		    	total++;
		    }
		    
		    try{
		    	
		    	conn.commit();
		    	msj.setClase(Mensaje.CLASE_INFO);
		    	msj.setDescripcion("Datos insertados correctamente");
		    
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
				fw.close();
				pst.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}	
		} 
		system2 = System.currentTimeMillis();
		system2 -= system1;
		time = (float) (system2);
		time /= 1000;
		request.setAttribute("tiempo", time);
		request.setAttribute("correctos", contCorrectos);
		request.setAttribute("incorrectos", contIncorrectos);
		request.setAttribute("total", total);
		request.setAttribute("msj", msj);
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
