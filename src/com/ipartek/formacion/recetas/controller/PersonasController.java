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

/**
 * Servlet implementation class PersonasController
 */
@WebServlet("/personas")
public class PersonasController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	static final String URL = "jdbc:mysql://localhost:3306/concesionario";
	static final String DBUSER = "root";
	static final String DBPASS = "";
	static final String DRIVER = "com.mysql.jdbc.Driver";
	public static final String PATH = "C:\\Desarrollo\\workspace\\web-recetas\\data\\personas.txt";
	public static final String PATH2 = "C:\\Desarrollo\\workspace\\web-recetas\\data\\personasincorrectas.txt";
	public static final String PATH3 = "C:\\Desarrollo\\workspace\\web-recetas\\data\\menoresdeedad.txt";
    Connection conn = null;
    String[] trozos = null;
    PreparedStatement pst = null;
    
    
    
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("ejercicios/personas/volcar-lista.jsp").forward(request, response);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int contCorrecto = 0;
	    int contIncorrecto = 0;
	    int contEdad = 0;
		File archivo = null;
	    FileReader fr = null;
	    BufferedReader br = null;
	    FileWriter fw = new FileWriter(PATH2);
	    FileWriter fw2 = new FileWriter(PATH3);
	    long millis1 = System.currentTimeMillis();
	    try{
	    
		    // comprobar driver o libreria
			Class.forName(DRIVER);
	
			// establecer conexion
			conn = DriverManager.getConnection(URL, DBUSER, DBPASS);	
			conn.setAutoCommit(false);
		    	
			//leer fichero
			archivo = new File (PATH);
			fr = new FileReader (archivo);
		    br = new BufferedReader(fr);
	
		    // Lectura del fichero
		    String linea;
		    while((linea=br.readLine())!=null){
		    	trozos = linea.split(",");
		        if(trozos.length == 7 && trozos[5].length() == 9){
		        	if(Integer.valueOf(trozos[3]) > 17){
		        		insertar();
		        		contCorrecto++;
		        	}else{
		        		fw2.write(linea + "\r\n");
		        		contEdad++;
		        	}
		        }else{
		        	fw.write(linea + "\r\n");
		        	contIncorrecto++;
		        }
		        	
		    }
		    
		    try{
		    	
		    	conn.commit();
		    	
		    } catch (SQLException e) {
		    	
		    	if (conn != null) {
		    		conn.rollback();
		    	}
		    
		    }
	    
		
	    }catch(SQLException e){
	    	
	    	e.printStackTrace();
		
	    }catch(Exception e){
	    	
	    	e.printStackTrace();
	    	
	    }finally{
	    	
	    	try{
	    		fw.close();
	    		fw2.close();
				pst.close();
				conn.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
	    	
	    
	    }
	    
	    long millis2 = System.currentTimeMillis();
	    millis2 -= millis1;
	    
	    request.setAttribute("tiempo", millis2);
		request.setAttribute("correctos", contCorrecto);
		request.setAttribute("erroneos", contIncorrecto);
		request.setAttribute("menores", contEdad);
		request.getRequestDispatcher("ejercicios/personas/volcar-lista.jsp").forward(request, response);
	}

	
	private void insertar() throws SQLException {
		
		String sql = "INSERT INTO `personas` (`id`, `nombre`, `apellido1`, `apelido2`, `edad`, `email`, `dni`, `puesto`) VALUES (NULL, ? , ? , ? , ? , ? , ? , ? );";
		
		pst = conn.prepareStatement(sql);
		pst.setString(1, trozos[0]);
		pst.setString(2, trozos[1]);
		pst.setString(3, trozos[2]);
		pst.setString(4, trozos[3]);
		pst.setString(5, trozos[4]);
		pst.setString(6, trozos[5]);
		pst.setString(7, trozos[6]);
		
		if(pst.executeUpdate() != 1){
			
			throw new SQLException("Algo hemos programado mal, deberia retornar 1");
			
		}	
	
	}

}
