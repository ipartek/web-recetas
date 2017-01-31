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
	private static final String VIEW_CREAR = "ejercicios/crear-fichero.jsp";
	private static final String VIEW_LEER = "ejercicios/leer-fichero.jsp";
	private static final String EXTENSION = ".txt";
	public static final String PATH = "C:\\desarrollo\\workspace\\web-recetas\\ficheros\\";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Mensaje msj = null;
		try {

			// recoger parametro
			String pFile = request.getParameter("file");

			if (pFile != null) {

				msj = new Mensaje();

				// Abrir fichero y asociar buffer
				FileReader file = new FileReader(PATH + pFile);
				BufferedReader bf = new BufferedReader(file);

				// Lectura del fichero linea a linea
				String contenido = "";
				String linea = null;
				while ((linea = bf.readLine()) != null) {
					contenido += linea;
				}

				// Cerrar buffer y file
				bf.close();
				file.close();

				// Menasaje
				msj.setClase(Mensaje.CLASE_SUCCESS);
				msj.setDescripcion("Fichero leido con exito");

				// Pasar atributos JSP
				request.setAttribute("filename", pFile);
				request.setAttribute("filecontent", contenido);
			}
		} catch (Exception e) {
			e.printStackTrace();
			msj = new Mensaje();
			msj.setDescripcion(e.getMessage());

		} finally {

			request.setAttribute("msj", msj);
			request.getRequestDispatcher(VIEW_LEER).forward(request, response);
		}
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
				BufferedReader bf = new BufferedReader(fr);

				// Lectura del fichero
				String linea;
				while ((linea = bf.readLine()) != null) {
					pContenido += linea;
				}

				// Cerrar buffer y file
				bf.close();
				fr.close();
			}
			// crear fichero
			FileWriter fw = new FileWriter(PATH + pNombre + EXTENSION);
			fw.write(pContenido);
			fw.close();

			// mensaje usuario
			msj.setClase(Mensaje.CLASE_INFO);
			msj.setDescripcion("Fichero creado: " + "<b>" + pNombre + EXTENSION + "</b><br>Ruta: " + PATH);

		} catch (

		Exception e) {
			e.printStackTrace();
			msj.setDescripcion(e.getMessage());

		} finally {
			request.setAttribute("msj", msj);
			request.getRequestDispatcher(VIEW_CREAR).forward(request, response);

		}
	}
}
