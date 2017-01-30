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
	private static final String VIEW_JSP = "ejercicios/crear-fichero.jsp";
	private static final String EXTENSION = ".txt";
	private static final String PATH = "C:\\desarrollo\\workspace\\web-recetas\\ficheros\\";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		throw new ServletException("sin implementar metodo GET");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Mensaje msj = null;
		File fichero = null;

		try {
			msj = new Mensaje();

			// recoger parametros
			String pNombre = request.getParameter("nombre");
			String pContenido = request.getParameter("contenido");

			// ver si existe el fichero
			fichero = new File(PATH + pNombre + EXTENSION);

			if (fichero.exists()) {
				FileReader fr = new FileReader(PATH + pNombre + EXTENSION);
				BufferedReader br = new BufferedReader(fr);

				// Lectura del fichero
				String contenido;
				String linea;
				while ((linea = br.readLine()) != null) {
					// lectura por linea

				}
			} else {
				// crear fichero
				FileWriter fw = new FileWriter(PATH + pNombre + EXTENSION);
				fw.write(pContenido);
				fw.close();
			}

			// mensaje usuario
			msj.setClase(Mensaje.CLASE_INFO);
			msj.setDescripcion("Fichero creado: " + "<b>" + pNombre + EXTENSION + "</b><br>Ruta: " + PATH);

		} catch (Exception e) {
			e.printStackTrace();
			msj.setDescripcion(e.getMessage());

		} finally {
			request.setAttribute("msj", msj);
			request.getRequestDispatcher(VIEW_JSP).forward(request, response);

		}
	}
}
