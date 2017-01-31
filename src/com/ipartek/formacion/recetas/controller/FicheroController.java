package com.ipartek.formacion.recetas.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.recetas.pojo.Mensaje;

/**
 * Servlet implementation class FicheroController
 */
@WebServlet("/files")
public class FicheroController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String EXTENSION = ".txt";
	public static final String PATH = "C:\\Desarrollo\\workspace\\web-recetas\\WebContent\\ficheros\\";
       
   

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Mensaje msj = null;
		File archivo = null;
	    FileReader fr = null;
	    BufferedReader br = null;
	    String texto = "";
	      
		try{
			
			msj = new Mensaje();
			
			//recoger parametros
			
			String pNombre = request.getParameter("nombre");
			
			String pContenido = request.getParameter("contenido");
		
			
			//leer fichero
		    archivo = new File (PATH + pNombre);
			fr = new FileReader (archivo);
	        br = new BufferedReader(fr);

	        // Lectura del fichero
	        String linea;
	        while((linea=br.readLine())!=null){
	        	texto = texto.concat(linea);
	        }
	        
			//mensaje de usuario
			
			msj.setClase(Mensaje.CLASE_SUCCESS);
			msj.setDescripcion("Fichero leido!");
			
		}catch(Exception e){
			
			msj.setDescripcion(e.getMessage());
			
		}finally{
			
			request.setAttribute("msj",msj);
			request.setAttribute("texto", texto);
			request.getRequestDispatcher("ejercicios/leer-fichero.jsp").forward(request, response);
		}
		  
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Mensaje msj = null;
		
	      
		try{
			
			msj = new Mensaje();
			
			//recoger parametros
			
			String pNombre = request.getParameter("nombre");
			String pContenido = request.getParameter("contenido");
			
			//crear fichero
			
			FileWriter fw=new FileWriter(PATH + pNombre + EXTENSION);
			
			fw.write(pContenido);
			fw.close();
			
			//mensaje de usuario
			
			msj.setClase(Mensaje.CLASE_SUCCESS);
			msj.setDescripcion("Fichero creado: " + pNombre + EXTENSION);
			
		}catch(Exception e){
			
			msj.setDescripcion(e.getMessage());
			
		}finally{
			
			request.setAttribute("msj",msj);
			request.getRequestDispatcher("ejercicios/crear-fichero.jsp").forward(request, response);
		}
		
	}

}
