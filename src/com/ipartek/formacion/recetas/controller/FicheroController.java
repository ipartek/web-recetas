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
	private static final String EXTENSION= ".txt";   
	public static final String PATH = "c:\\desarrollo\\workspace\\web-recetas\\ficheros\\";
    
	
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Mensaje msj = null;
		String texto = "";
		String pNombre = null;
		try {
				
			msj = new Mensaje();
			File archivo = null;
		    FileReader fr = null;
		    BufferedReader br = null;
			
		    // Lectura del fichero
		    pNombre = request.getParameter("nombre");
		    archivo = new File (PATH + pNombre);
	        fr = new FileReader (archivo);
	        br = new BufferedReader(fr);
		    
		    
		    String linea;
		    while((linea=br.readLine())!=null) {
		           texto = texto.concat(linea);
//		           texto  +=linea;
		    }
		    
		    //cerrar buffer y file
		    br.close();
		    fr.close();
		    
			//mensaje usuario
			msj.setClase(Mensaje.CLASE_INFO);
			msj.setDescripcion("Fichero leido correctamente");
			
		} catch(Exception e) {
			e.printStackTrace();
			msj.setClase(Mensaje.CLASE_DANGER);
			msj.setDescripcion(e.getMessage());
		} finally {
			request.setAttribute("msj", msj);
			request.setAttribute("nombre", pNombre);
			request.setAttribute("texto", texto);
			request.getRequestDispatcher("ejercicios/leer-fichero.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Mensaje msj = null;
		
		try {
				
			msj = new Mensaje();
		
			//recoger parametros
			String pNombre= request.getParameter("nombre");
			String pContenido= request.getParameter("contenido");
			
			//crear fichero
			FileWriter fw = new FileWriter(PATH + pNombre + EXTENSION);
			fw.write(pContenido);
			fw.close();
			
			//mensaje usuario
			msj.setClase(Mensaje.CLASE_INFO);
			msj.setDescripcion("Fichero creado: " + pNombre + EXTENSION + "<br> ruta: " + PATH);
			
		} catch(Exception e) {
			e.printStackTrace();
			msj.setDescripcion(e.getMessage());
		} finally {
			request.setAttribute("msj", msj);
			request.getRequestDispatcher("ejercicios/crear-fichero.jsp").forward(request, response);
		}
	}

}
