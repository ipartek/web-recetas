package com.ipartek.formacion.controller;

import java.io.File;
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

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Mensaje msj = null;
		FileWriter fw = null;
		try {

			msj = new Mensaje();
			// recoger parametros
			String pNombre = request.getParameter("nombre");
			String sFichero = PATH+"pnombre+"+EXTENSION;

			// buscar
			if (fichero.exists()){

				msj.setClase(Mensaje.CLASE_SUCCESS);
				msj.setDescripcion("El fichero exixte);
				  }
				else{
					msj.setClase(Mensaje.CLASE_WARNING);
					msj.setDescripcion("El fichero No exixte);)
				}
			fw = new FileWriter(PATH + pNombre + EXTENSION);
			fw.write(pContenido);
			fw.close();
			// mensaje usuario
			msj.setClase(Mensaje.CLASE_SUCCESS);
			msj.setDescripcion("Fichero creado: <b>" + pNombre + EXTENSION + "</b> <br> ruta: " + PATH);
		 catch (Exception e) {
			e.printStackTrace();
			msj.setDescripcion(e.getMessage());
		} finally {
			request.setAttribute("msj", msj);
			request.getRequestDispatcher("ejercicios/CrearFicheroTexto.jsp").forward(request, response);
		}

	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
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
			fw = new FileWriter(PATH + pNombre + EXTENSION);
			fw.write(pContenido);
			fw.close();
			// mensaje usuario
			msj.setClase(Mensaje.CLASE_SUCCESS);
			msj.setDescripcion("Fichero creado: <b>" + pNombre + EXTENSION + "</b> <br> ruta: " + PATH);
		} catch (Exception e) {
			e.printStackTrace();
			msj.setDescripcion(e.getMessage());
		} finally {
			request.setAttribute("msj", msj);
			request.getRequestDispatcher("ejercicios/CrearFicheroTexto.jsp").forward(request, response);
		}

	}

}
