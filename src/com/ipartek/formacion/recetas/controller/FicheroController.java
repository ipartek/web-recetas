package com.ipartek.formacion.recetas.controller;

import java.io.BufferedReader;
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
	public static final String PATH = "C:\\Desarrollo\\Workspace\\web-recetas\\ficheros\\";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Mensaje msj = null;
		try {
			msj = new Mensaje();

			// Recoger parametro
			String pFile = request.getParameter("file");

			// Abrir fichero y asociar buffer
			FileReader file = new FileReader(PATH + pFile);
			BufferedReader bf = new BufferedReader(file);

			// Leer linea a linea el fichero.
			String linea = "";
			String contenido = "";
			while ((linea = bf.readLine()) != null) {
				contenido += linea;

			}

			// Cerrar buffer y file
			bf.close();
			file.close();

			// Mensaje
			msj.setClase(Mensaje.CLASE_SUCCESS);
			msj.setDescripcion("Fichero leido con exito.");

			// Pasar atributos JSP
			request.setAttribute("filename", pFile);
			request.setAttribute("filecontent", contenido);

		} catch (Exception e) {
			e.printStackTrace();
			msj.setDescripcion(e.getMessage());
		} finally {
			request.setAttribute("msj", msj);
			request.getRequestDispatcher("ejercicios/leer-fichero.jsp").forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Mensaje msj = null;

		try {
			msj = new Mensaje();

			// Recoger parametros.
			String pNombre = request.getParameter("nombre");
			String pContenido = request.getParameter("contenido");

			// Crear fichero.
			FileWriter fw = new FileWriter(PATH + pNombre + EXTENSION);
			// Para recoger el texto del fichero.
			fw.write(pContenido);
			fw.close();

			// Mensaje usuario.
			msj.setClase(Mensaje.CLASE_INFO);
			msj.setDescripcion("Fichero creado en: " + pNombre + EXTENSION);
		} catch (Exception e) {
			e.printStackTrace();
			msj.setDescripcion(e.getMessage());

		} finally {
			request.setAttribute("msj", msj);
			request.getRequestDispatcher("ejercicios/crear-fichero.jsp").forward(request, response);
		}

	}

}
