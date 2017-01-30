package com.ipartek.formacion.controller;

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

import com.ipartek.formacion.vehiculo.pojo.Mensaje;

/**
 * Servlet implementation class FicheroController
 */
@WebServlet("/files")
public class FicheroController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String EXTENSION = ".txt";
	private static final String PATH = "c:\\desarrollo\\workspace\\web-recetas\\ficheros\\";
	private static final String PATH_2= "/home/suglur/dat/Workspaces/eclipse/web-recetas/WebContent/files/";
/**
 * Busca un fichero ,y lo pinta
 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Mensaje msj = null;
		FileWriter fw = null;
		File buscado = null;
		try {

			msj = new Mensaje();
			// recoger parametros
			String pNombre = request.getParameter("nombre");
			String sFichero = PATH_2 + pNombre + EXTENSION;
			String cadena=null;
			buscado = new File(sFichero);
			// buscar
			if (buscado.exists()) {

				msj.setClase(Mensaje.CLASE_SUCCESS);
				msj.setDescripcion("El fichero existe");
				try {
					
				    FileReader f = new FileReader(buscado);
				      BufferedReader b = new BufferedReader(f);
				      while((cadena = b.readLine())!=null) {
				          cadena.concat(cadena);
				      }
				      b.close();
				} finally {
					request.setAttribute("contenido", cadena);
				}
			} else {
				msj.setClase(Mensaje.CLASE_DANGER);
				msj.setDescripcion("El fichero No existe");
				
			}//endif
		}catch (Exception e) {
			e.printStackTrace();
			msj.setDescripcion(e.getMessage());
		} finally {
			request.setAttribute("msj", msj);
			request.getRequestDispatcher("ejercicios/CrearFicheroTexto.jsp").forward(request, response);
		}

	}

	/**
	 * Crea un fichero
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Mensaje msj = null;
		FileWriter fw = null;
		try {

			msj = new Mensaje();
			// recoger parametros
			String pNombre = request.getParameter("nombre");
			String pContenido = request.getParameter("contenido");

			// crear Fichero
			fw = new FileWriter(PATH_2 + pNombre + EXTENSION);
			fw.write(pContenido);
			fw.close();
			// mensaje usuario
			msj.setClase(Mensaje.CLASE_SUCCESS);
			msj.setDescripcion("Fichero creado: <b>" + pNombre + EXTENSION + "</b> <br> ruta: " + PATH_2);
		} catch (Exception e) {
			e.printStackTrace();
			msj.setDescripcion(e.getMessage());
		} finally {
			request.setAttribute("msj", msj);
			request.getRequestDispatcher("ejercicios/CrearFicheroTexto.jsp").forward(request, response);
		}

	}

}
